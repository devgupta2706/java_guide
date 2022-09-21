package com.example.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class updatecsv {
    void add_csv(String customer) {
        String file = "C:\\dev.c\\Biller.csv";
        File f = new File(file);
        BufferedReader reader = null;
        String line = "";
        StringBuilder allcontent = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                allcontent.append(line).append("\n");
            }

        } catch (IOException e) {
            System.out.println("File doesn't exists");
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            f.delete();
            allcontent.append(customer).append("\n");

            try (FileWriter Writer = new FileWriter("C:\\dev.c\\Biller.csv")) {

                Writer.write(allcontent.toString());
                System.out.println("Reached");
            } catch (IOException e) {
                System.out.println("Not Reached");
                e.printStackTrace();
            } finally {

            }
        }
    }
}
