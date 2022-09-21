package com.example.csv;

import java.util.Calendar;
import java.util.Scanner;
import java.util.UUID;

public class CommercialPurpose extends Electricity {
    static int penalty_per_day, fixedcharge, per_unitCost, charge_to_reconnect;

    public CommercialPurpose(String name, Calendar Date, String address, String Mail, String contact) {
        this.account_holder_NAME = name;
        this.joiningDate = Date;
        this.consumerID = UUID.randomUUID();
        this.Previous_reading = 0;
        this.Address = address;
        this.Previous_amount = 0;
        this.delay_to_pay = 0;
        StringBuffer str = new StringBuffer();
        str.append(Date.get(Calendar.DATE)).append("-")
                .append(Date.get(Calendar.MONTH)).append("-")
                .append(Date.get(Calendar.YEAR));
        this.last_billing_date = str;
        this.power_cut = false;
        this.mailID = Mail;
        this.contact = contact;
        this.BillType = "Commercial";
    }

    static {
        penalty_per_day = 100;
        fixedcharge = 1000;
        per_unitCost = 25;
        charge_to_reconnect = 10000;
    }

    @Override
    void calculateBILL(Calendar Curr, int Current_reading) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter Customer Name\t");
        String name = scn.next();
        scn.nextLine();
        System.out.println("Enter Customer Name\t");
        String contact = scn.next();
        String[] line = readcsv(name, contact);
        String date = line[10];
        String[] row = date.split("-");
        int last_billingyear = Integer.parseInt(row[2]);
        int curr_year = Curr.get(Calendar.YEAR);
        int last_billingmonth = Integer.parseInt(row[1]);
        int curr_month = Curr.get(Calendar.MONTH);
        int last_billingdate = Integer.parseInt(row[0]);
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
        return;

    }

}
