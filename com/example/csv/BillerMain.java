package com.example.csv;

import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;

public class BillerMain {
    public static String Password = "12345";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(System.in);
        Calendar cal = (Calendar) Calendar.getInstance();
        char ch;
        int i;
        for (i = 0; i < 3; i++) {
            System.out.println("\nEnter password to access the document\t");
            String Pass = scn.next();
            if (Pass.equals(Password)) {
                break;
            } else {
                System.out.printf("Retry %d times left", 2 - i);
                System.out.println();
            }
        }
        if (i == 3) {
            System.exit(0);
        }
        do {
            int n;
            System.out.println("Enter your choice" +
                    "\n1)Create Csv\n2)Delete Csv\n3)Adding Customer\n" +
                    "4)Update Contact\n5)Update E-mail\n" +
                    "6)Search Customer\n7)Pay bill\n8)Calculate Bill");
            n = scn.nextInt();
            switch (n) {
                case 1:
                    Electricity.create_csv();
                    break;
                case 2:
                    Electricity.delete_csv();
                    break;
                case 3:
                    System.out.println("1) Commercial Bill\n2) Domestic Bill\n");
                    n = scn.nextInt();
                    if (n == 1) {
                        System.out.println("Enter Name\n");
                        String name = scn.next();
                        scn.nextLine();
                        System.out.println("Enter Address\n");
                        String address = scn.next();
                        scn.nextLine();
                        System.out.println("Enter E-mail ID\n");
                        String Mail = scn.next();
                        scn.nextLine();
                        System.out.println("Enter Contact Number \n");
                        String contact = scn.next();
                        scn.nextLine();
                        CommercialPurpose C = new CommercialPurpose(name, cal, address, Mail, contact);
                        Electricity.add_csv(C);
                    } else {
                        System.out.println("Enter Name\n");
                        String name = scn.next();
                        scn.nextLine();
                        System.out.println("Enter Address\n");
                        String address = scn.next();
                        scn.nextLine();
                        System.out.println("Enter E-mail ID\n");
                        String Mail = scn.next();
                        scn.nextLine();
                        System.out.println("Enter Contact Number \n");
                        String contact = scn.next();
                        scn.nextLine();
                        DomesticPurpose D = new DomesticPurpose(name, cal, address, Mail, contact);
                        Electricity.add_csv(D);
                    }
                    break;
                case 4:
                    System.out.println("Enter E-mail to update contact ID\n");
                    String Mail = scn.next();
                    scn.nextLine();
                    System.out.println("Enter  New Contact Number  \n");
                    String contact = scn.next();
                    Electricity.change_mobilenumber(Mail, contact);
                    break;
                case 5:
                    System.out.println("Enter Contact Number to update E-mail ID \n");
                    String Mcontact = scn.next();
                    System.out.println("Enter New E-mail ID\n");
                    String EMail = scn.next();
                    scn.nextLine();
                    Electricity.change_MailID(EMail, Mcontact);
                    break;
                case 6:
                    System.out.println("Enter E-mail ID\n");
                    String E_Mail = scn.next();
                    scn.nextLine();
                    System.out.println("Enter Contact Number \n");
                    String M_contact = scn.next();
                    scn.nextLine();
                    String[] Info = Electricity.readcsv(E_Mail, M_contact);
                    System.out.println("Customer Details\n");
                    System.out.println("BillType=" + Info[0] + "\nConsumerID=" + Info[1]);
                    System.out.println(
                            "\nConsumer Name=" + Info[2] +
                                    "\nJoining Date=" + Info[3] + "\nPrevious Reading=" + Info[4] + "\nAmount="
                                    + Info[5] + "\nEmail ID=" + Info[6] + "\nContact No.=" + Info[7] +
                                    "\nAddress=" + Info[8] + "\nConnection=" + Info[9]);
                    System.out.print("\nLast Bill Date=" + Info[10]);
                    break;
                case 7:
                    System.out.println("Enter E-mail ID\n");
                    String E_MaiL = scn.next();
                    scn.nextLine();
                    System.out.println("Enter Contact Number \n");
                    String M_contacT = scn.next();
                    scn.nextLine();
                    String[] Infos = Electricity.readcsv(E_MaiL, M_contacT);
                    System.out.println("Customer Details\n");
                    System.out.println("BillType=" + Infos[0] + "\nConsumerID=" + Infos[1]);
                    System.out.println(
                            "\nConsumer Name=" + Infos[2] +
                                    "\nJoining Date=" + Infos[3] + "\nPrevious Reading=" + Infos[4] + "\nAmount="
                                    + Infos[5] + "\nEmail ID=" + Infos[6] + "\nContact No.=" + Infos[7] +
                                    "\nAddress=" + Infos[8] + "\nConnection=" + Infos[9]);
                    System.out.print("\nLast Bill Date=" + Infos[10]);
                    System.out.print("\nEnter Amount to pay\n");
                    int Amount = scn.nextInt();
                    Electricity.pay_bill(M_contacT, Amount);
                    break;
                case 8:
                    Electricity E = new Electricity();
                    System.out.print("Enter Current Reading\t");
                    int Current_reading = scn.nextInt();
                    E.calculateBILL(cal, Current_reading);
                    break;
                default:
                    break;

            }

            System.out.println("\nDo you want to continue\t");
            ch = scn.next().charAt(0);

        } while (ch == 'y' || ch == 'Y');

        scn.close();
    }

}
