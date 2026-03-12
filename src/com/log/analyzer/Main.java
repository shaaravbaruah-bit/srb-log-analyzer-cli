package com.log.analyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String file = "logs.txt";

        int error = 0;
        int warning = 0;
        int info = 0;
        int total = 0;

        ArrayList<String> errorLogs = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while((line = reader.readLine()) != null) {

                total++;

                if(line.contains("ERROR")) {
                    error++;
                    errorLogs.add(line);
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

            System.out.println("\n----- Error Logs -----");

            for(String log : errorLogs) {
                System.out.println(log);
            }

            try {

                FileWriter writer = new FileWriter("analysis_report.txt");

                writer.write("===== Log Analysis Report =====\n");
                writer.write("Total Logs: " + total + "\n");
                writer.write("Errors: " + error + "\n");
                writer.write("Warnings: " + warning + "\n");
                writer.write("Info: " + info + "\n\n");

                writer.write("----- Error Logs -----\n");

                for(String log : errorLogs) {
                    writer.write(log + "\n");
                }

                writer.close();

                System.out.println("\nReport saved to analysis_report.txt");

            }

            catch(IOException e) {
                System.out.println("Error writing report file.");
            }

        }

        catch(IOException e) {
            System.out.println("Error reading log file.");
        }
    }
}