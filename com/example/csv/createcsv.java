package com.example.csv;

import java.io.FileWriter;
import java.io.IOException;

public class createcsv {
    public static void main(String[] args) {

        StringBuilder str = new StringBuilder();
        str.append("Name").append(",").append("Country").append("\n");
        str.append("Dev").append(",").append("India").append("\n");
        try (FileWriter Writer = new FileWriter("C:\\dev.c\\Biller.csv")) {
            Writer.write(str.toString());
            System.out.println("Csv Created");
        } catch (IOException e) {

        }
    }
}
