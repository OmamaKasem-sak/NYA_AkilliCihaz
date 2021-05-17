package com.sogutucuCihaz;

import java.util.Random;

public class SicaklikKontrolcusu implements Runnable{
    private int sicaklik;
    @Override
    public void run() {
        Random random = new Random();
        try {
            Thread.sleep(10000);
            int sicaklikDegeri = random.nextInt(10)-8;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
