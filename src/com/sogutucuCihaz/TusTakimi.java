package com.sogutucuCihaz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TusTakimi implements ITusTakimi{

    @Override
    public String stringVeriAl() {
        Scanner klavyeGirisi = new Scanner(System.in);
        return klavyeGirisi.nextLine();
    }

    @Override
    public int intVeriAl() {
        Scanner klavyeGirisi = new Scanner(System.in);

        int sayi = 0;
        boolean error;

        do {
            if (klavyeGirisi.hasNextInt()){
                sayi = klavyeGirisi.nextInt();
                error = false;
            }
            else {
                System.out.println("\nHATALI GIRIS YAPTINIZ");
                System.out.println("Lütfen sayi giriniz:");
                klavyeGirisi.next();
                error = true;
            }
        } while (error);
        return sayi;
    }
}
