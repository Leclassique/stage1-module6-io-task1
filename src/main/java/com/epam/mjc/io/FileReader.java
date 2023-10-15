package com.epam.mjc.io;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReader {
    private static final Logger logger = Logger.getLogger(FileReader.class.getName());
    public Profile getDataFromFile(File file) {
        StringBuilder str = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] strings = line.split(": ");
                str.append(strings[1]).append(",");
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            logger.log(Level.INFO, "Error reading file");
        }
        String[] params = str.toString().split(",");
        return new Profile(params[0], params[1], params[2], params[3]);
    }
}