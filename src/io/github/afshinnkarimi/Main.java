package io.github.afshinnkarimi;

import java.util.Scanner;
import java.lang.Math;
import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {
        byte MONTHS_IN_YEAR = 12;
        byte PERCENT = 100;
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInerest = scanner.nextFloat();
        float monthlyInterest = annualInerest / PERCENT / MONTHS_IN_YEAR;

        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                    * Math.pow(1 + monthlyInterest, numberOfPayments)
                    / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgateFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgateFormatted);

    }
}
