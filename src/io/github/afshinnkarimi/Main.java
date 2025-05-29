package io.github.afshinnkarimi;

import java.util.Scanner;
import java.lang.Math;
import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {
        byte MONTHS_IN_YEAR = 12;
        byte PERCENT = 100;
        
        Scanner scanner = new Scanner(System.in);

        int principal = 0;
        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if (principal >= 1_000 && principal <= 1_000_000) {
                break; // Valid input, exit the loop
            }
            System.out.println("Enter a number between 1,000 and 1,000,000.");   
        }

        float annualInterest = 0;
        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
            if (annualInterest > 0 && annualInterest <= 30) {
                break; // Valid input, exit the loop
            }
                System.out.println("Enter a value greater than 0 and less than or equal to 30.");
        }

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                    * Math.pow(1 + monthlyInterest, numberOfPayments)
                    / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);

        scanner.close(); // Close the scanner
    }
}
