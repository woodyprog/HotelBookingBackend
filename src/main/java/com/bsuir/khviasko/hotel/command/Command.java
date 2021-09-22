package com.bsuir.khviasko.hotel.command;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public interface Command {
    void execute(BufferedReader reader, BufferedWriter writer, Gson gson) throws IOException;
}
