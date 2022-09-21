package com.example.csv;

import java.io.*;

public class readcsv {
    public static void main(String[] args) {
        String file = "C:\\dev.c\\Biller.csv";
        File f = new File(file);
        BufferedReader reader = null;
        String line = "";
        StringBuilder allcontent = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
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
            System.out.println(allcontent);

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
