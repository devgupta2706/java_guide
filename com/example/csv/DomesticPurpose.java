package com.example.csv;

import java.util.Calendar;
import java.util.UUID;

public class DomesticPurpose extends Electricity {
    public DomesticPurpose(String name, Calendar Date, String address, String Mail, String contact) {
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
        this.BillType = "Domestic";
        this.contact = contact;

    }
}
