package com.sogutucuCihaz;

public class Ekran implements IEkran {

    @Override
    public void acilisMesaji() {
        System.out.println("Cihaz Acildi\n");
    }

    @Override
    public Kullanici kullaniciGirisEkrani(ITusTakimi tusTakimi) {
        System.out.println("ID: ");
        String id = tusTakimi.stringVeriAl();

        System.out.println("Password: ");
        String pass = tusTakimi.stringVeriAl();

        return new Kullanici.Builder(id, pass).build();
    }

    @Override
    public void kullaniciDogrulanmaMesaji(boolean result) {
        this.mesajYaz("");
        if (result) this.mesajYaz("Hos geldiniz\n");
        else this.mesajYaz("Kullanici bulunamadi.\n");
        this.mesajYaz("");
    }

    @Override
    public void kullaniciCikisEkrani() {
        this.mesajYaz("Cihaz kapatiliyor.\n");
    }

    @Override
    public int kullaniciSecenekleri(ITusTakimi tusTakimi) {
        boolean secenekResult = false;
        int secenek;

        do {
            this.mesajYaz("Secim yapiniz: ");
            this.mesajYaz("1.Sogutucuyu aç ");
            this.mesajYaz("2.Sogutucuyu kapat");
            this.mesajYaz("3.Sicakligi gorüntüle");
            this.mesajYaz("0.Cikis");

            secenek = tusTakimi.intVeriAl();

            if (secenek < 0 || secenek > 3) {
                this.mesajYaz("\nHatali giris");
                secenekResult = true;
            }
        } while (secenekResult);

        return secenek;
    }

    @Override
    public void mesajYaz(String message) {
        System.out.println(message);
    }

    @Override
    public void sicaklikGoruntule(IAgArayuzu agArayuzu) {
        int sicaklik = agArayuzu.sicaklikOku();
        this.mesajYaz("\n Sicaklik degeri okundu : " + sicaklik +  " C\n");
    }

    @Override
    public void sogutucuAc(IAgArayuzu agArayuzu) { 
        agArayuzu.sogutucuAc();
        this.mesajYaz("\nSogutucu acildi. \n");
    }

    @Override
    public void sogutucuKapat(IAgArayuzu agArayuzu) {
        agArayuzu.sogutucuKapat();
        this.mesajYaz("\nSogutucu kapatildi.\n");
    }
}
