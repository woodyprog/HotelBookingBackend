package com.bsuir.khviasko.hotel.command.impl.user;

import com.bsuir.khviasko.hotel.command.Command;
import com.bsuir.khviasko.hotel.connection.QueryWrapper;
import com.bsuir.khviasko.hotel.entity.Reservation;
import com.bsuir.khviasko.hotel.entity.User;
import com.bsuir.khviasko.hotel.repository.reservation.ReservationRepository;
import com.bsuir.khviasko.hotel.repository.reservation.impl.ReservationRepositoryImpl;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReservationsReportCommand implements Command {
    ReservationRepository reservationRepository;

    public ReservationsReportCommand() {
        this.reservationRepository = new ReservationRepositoryImpl();
    }

    @Override
    public void execute(BufferedReader reader, BufferedWriter writer, Gson gson, QueryWrapper queryWrapper) throws IOException {
        User user = gson.fromJson(reader.readLine(), User.class);
        List<Reservation> reservations = reservationRepository.getUserReservations(user);
        FileWriter fileWriter = new FileWriter("C:/report.txt");
        reservations.forEach(reservation -> {
            try {
                fileWriter.write(reservation.getData());

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        writer.close();
    }
}
