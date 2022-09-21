package com.example.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;
import java.util.UUID;

public class Electricity {
    String account_holder_NAME;
    UUID consumerID;
    String Address, mailID, contact;
    int Previous_reading, delay_to_pay;// in days;
    static int penalty_per_day, fixedcharge, per_unitCost, charge_to_reconnect;
    Calendar joiningDate;
    StringBuffer last_billing_date;
    int Previous_amount;
    boolean power_cut = false;
    String BillType;

    public Electricity() {

    }

    static {
        penalty_per_day = 25;
        fixedcharge = 150;
        per_unitCost = 10;
        charge_to_reconnect = 5000;
    }

    void calculateBILL(Calendar Curr, int Current_reading) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter Customer Name\t");
        this.account_holder_NAME = scn.next();
        scn.nextLine();
        System.out.println("Enter Customer Contact\t");
        this.contact = scn.next();
        String[] line = readcsv(account_holder_NAME, contact);
        String date = line[10];
        String[] element = date.split("-");
        int last_billingyear = Integer.parseInt(element[2]);
        int curr_year = Curr.get(Calendar.YEAR);
        int last_billingmonth = Integer.parseInt(element[1]);
        int curr_month = Curr.get(Calendar.MONTH);
        int last_billingdate = Integer.parseInt(element[0]);
        int curr_date = Curr.get(Calendar.DATE);
        if (curr_year == last_billingyear) {
            if (curr_month - last_billingmonth >= 4 && Previous_amount > 2000) {
                this.power_cut = true;
                System.out.println("Electricity cut");
                Previous_amount += charge_to_reconnect;
            } else if (Previous_amount > 2000) {
                delay_to_pay = (curr_month - last_billingmonth - 2) * 30;
                delay_to_pay += curr_date + last_billingdate;

            }
        } else if (curr_year == last_billingyear + 1) {
            if (12 - last_billingmonth + curr_month >= 4 && Previous_amount > 2000) {
                this.power_cut = true;
                System.out.println("Electricity cut");
                Previous_amount += charge_to_reconnect;
            } else if (Previous_amount > 2000) {
                delay_to_pay = (12 + curr_month - last_billingmonth - 2) * 30;
                delay_to_pay += curr_date + last_billingdate;
            }
        } else if (Previous_amount > 2000) {
            power_cut = true;
            System.out.println("Electricity cut");
            Previous_amount += charge_to_reconnect;
        }
        int units = Current_reading - Previous_reading;
        Previous_reading = Current_reading;
        Previous_amount = Previous_amount + (units * per_unitCost) + (fixedcharge) + (delay_to_pay * penalty_per_day);

        String file = "C:\\dev.c\\Biller.csv";
        File f = new File(file);
        BufferedReader reader = null;
        String lines = "";
        StringBuilder allcontent = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((lines = reader.readLine()) != null) {
                String[] row = lines.split(",");
                if (row[7].equals(contact)) {
                    allcontent.append(row[0]).append(",").append(row[1]).append(",")
                            .append(row[2]).append(",")
                            .append(row[3])
                            .append(",").append(Previous_reading)
                            .append(",").append(Previous_amount).append(",").append(row[6])
                            .append(",").append(row[7]).append(",").append(row[8]);
                    if (power_cut == false)
                        allcontent.append(",").append("Yes");
                    else
                        allcontent.append(",").append("No");
                    allcontent.append(",").append(row[10]).append("\n");
                } else {
                    allcontent.append(lines).append("\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        f.delete();
        try (FileWriter Writer = new FileWriter("C:\\dev.c\\Biller.csv")) {

            Writer.write(allcontent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

    void Payment_and_Update(int money, Calendar Today) {
        Previous_amount -= money;
        if (Previous_amount <= 0) {
            StringBuffer str = new StringBuffer();
            str.append(Today.get(Calendar.DATE)).append("-")
                    .append(Today.get(Calendar.MONTH)).append("-")
                    .append(Today.get(Calendar.YEAR));
            last_billing_date = str;
            this.power_cut = false;
            delay_to_pay = 0;
        }
        return;
    }

    public static void create_csv() {
        StringBuilder str = new StringBuilder();
        String Header = "BillType,ConsumerID,Consumer Name,Joining Date,Previous Reading,Amount,Email ID,Contact No.,Address,Connection,Last Bill Date";
        str.append(Header).append("\n");
        try (FileWriter Writer = new FileWriter("C:\\dev.c\\Biller.csv")) {
            Writer.write(str.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void add_csv(Electricity E) {
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
        }
        f.delete();
        allcontent.append(E.BillType).append(",").append(E.consumerID).append(",")
                .append(E.account_holder_NAME).append(",")
                .append(E.joiningDate.get(Calendar.DATE) + "-" +
                        E.joiningDate.get(Calendar.MONTH) + "-"
                        + E.joiningDate.get(Calendar.YEAR))
                .append(",").append(E.Previous_reading)
                .append(",").append(E.Previous_amount).append(",")
                .append(E.mailID).append(",").append(E.contact)
                .append(",").append(E.Address).append(",");
        if (E.power_cut == false)
            allcontent.append("Yes").append(",");
        else
            allcontent.append("No").append(",");
        allcontent
                .append(E.joiningDate.get(Calendar.DATE) + "-" +
                        E.joiningDate.get(Calendar.MONTH) + "-"
                        + E.joiningDate.get(Calendar.YEAR))
                .append("\n");
        try (FileWriter Writer = new FileWriter("C:\\dev.c\\Biller.csv")) {

            Writer.write(allcontent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void delete_csv() {
        String file = "C:\\dev.c\\Biller.csv";
        File f = new File(file);
        f.delete();
    }

    public static void change_mobilenumber(String EmailID, String mobile) {
        String file = "C:\\dev.c\\Biller.csv";
        File f = new File(file);
        BufferedReader reader = null;
        String line = "";
        StringBuilder allcontent = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[6].equals(EmailID)) {
                    row[7] = mobile;
                    allcontent.append(row[0]).append(",").append(row[1]).append(",")
                            .append(row[2]).append(",")
                            .append(row[3])
                            .append(",").append(row[4])
                            .append(",").append(row[5]).append(",").append(row[6])
                            .append(",").append(row[7]).append(",").append(row[8])
                            .append(",").append(row[9])
                            .append(",").append(row[10])
                            .append("\n");
                } else {
                    allcontent.append(line).append("\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        f.delete();
        try (FileWriter Writer = new FileWriter("C:\\dev.c\\Biller.csv")) {

            Writer.write(allcontent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void change_MailID(String EmailID, String mobile) {
        String file = "C:\\dev.c\\Biller.csv";
        File f = new File(file);
        BufferedReader reader = null;
        String line = "";
        StringBuilder allcontent = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[7].equals(mobile)) {
                    row[6] = EmailID;
                    allcontent.append(row[0]).append(",").append(row[1]).append(",")
                            .append(row[2]).append(",")
                            .append(row[3])
                            .append(",").append(row[4])
                            .append(",").append(row[5]).append(",").append(row[6])
                            .append(",").append(row[7]).append(",").append(row[8])
                            .append(",").append(row[9]).append(",").append(row[10])
                            .append("\n");
                } else {
                    allcontent.append(line).append("\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        f.delete();
        try (FileWriter Writer = new FileWriter("C:\\dev.c\\Biller.csv")) {

            Writer.write(allcontent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void pay_bill(String Mobile, int Amount) {
        String file = "C:\\dev.c\\Biller.csv";
        File f = new File(file);
        BufferedReader reader = null;
        String line = "";
        StringBuilder allcontent = new StringBuilder();
        Calendar today = Calendar.getInstance();
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row[7].equals(Mobile)) {
                    Electricity E = new Electricity();
                    E.Previous_amount = Integer.parseInt(row[5]);
                    E.Payment_and_Update(Amount, today);
                    Amount = Integer.parseInt(row[5]) - Amount;

                    allcontent.append(row[0]).append(",").append(row[1]).append(",")
                            .append(row[2]).append(",")
                            .append(row[3])
                            .append(",").append(row[4])
                            .append(",").append(Amount).append(",").append(row[6])
                            .append(",").append(row[7]).append(",").append(row[8])
                            .append(",").append(row[9]).append(",");
                    if (E.Previous_amount <= 0) {
                        allcontent.append(E.last_billing_date);
                        allcontent.append("\n");
                    }

                    else {
                        allcontent.append(row[10]).append("\n");
                    }
                } else {
                    allcontent.append(line).append("\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        f.delete();
        try (FileWriter Writer = new FileWriter("C:\\dev.c\\Biller.csv")) {

            Writer.write(allcontent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] readcsv(String name, String contact) {
        String file = "C:\\dev.c\\Biller.csv";
        BufferedReader reader = null;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (name.equals(row[2]) || contact.equals(row[7])) {
                    return row;
                }
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
        }
        return null;

    }
}
