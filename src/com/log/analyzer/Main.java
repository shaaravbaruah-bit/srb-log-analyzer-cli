package com.log.analyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        String file = "logs.txt";

        int error = 0;
        int warning = 0;
        int info = 0;
        int total = 0;

        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while((line = reader.readLine()) != null) {

                total++;

                if(line.contains("ERROR")) {
                    error++;
                }

                else if(line.contains("WARNING")) {
                    warning++;
                }

                else if(line.contains("INFO")) {
                    info++;
                }
            }

            reader.close();

            System.out.println("===== Log Analysis =====");
            System.out.println("Total Logs: " + total);
            System.out.println("Errors: " + error);
            System.out.println("Warnings: " + warning);
            System.out.println("Info: " + info);

        }

        catch(IOException e) {
            System.out.println("Error reading log file.");
        }
    }
}