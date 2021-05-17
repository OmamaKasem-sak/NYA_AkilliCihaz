package com.sogutucuCihaz;

public interface IEkran {
    public void acilisMesaji();
    public Kullanici kullaniciGirisEkrani(ITusTakimi tusTakimi);
    public void kullaniciDogrulanmaMesaji(boolean dogrulandiMi);
    public void kullaniciCikisEkrani();
    public int kullaniciSecenekleri(ITusTakimi tusTakimi);
    public void mesajYaz(String mesaj);
    public void sicaklikGoruntule(IAgArayuzu agArayuzu);
    public void sogutucuAc(IAgArayuzu agArayuzu);
    public void sogutucuKapat(IAgArayuzu agArayuzu);
}
