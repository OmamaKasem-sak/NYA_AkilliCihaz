package com.sogutucuCihaz;

public class AkilliSogutucu {
    IEkran ekran;
    ITusTakimi tusTakimi;
    IAgArayuzu agArayuzu;
    ISicaklikAlgilayici sicaklikAlgilayici;
    IKisilerRepository KisilerRepositoryPostgreSql;
    ISicaklikRepository sicaklikRepositoryPostgreSql;

    AkilliSogutucu(){
        ekran = new Ekran();
        tusTakimi = new TusTakimi();
        agArayuzu = new AgArayuzu();
        KisilerRepositoryPostgreSql = new KisilerRepositoryPostgreSql();
        sicaklikRepositoryPostgreSql = new SicaklikRepositoryPostgreSql();
        sicaklikAlgilayici = new SicaklikAlgilayici();

        sicaklikAlgilayici.attach(sicaklikRepositoryPostgreSql);
    }

    public void basla(){
        ekran.acilisMesaji();
        Kullanici users;

        Thread thread = new Thread(sicaklikAlgilayici);
        thread.start();

        boolean cikisMi = false;
        int options = 0;

        users = ekran.kullaniciGirisEkrani(tusTakimi);
        boolean userValidation = KisilerRepositoryPostgreSql.kullaniciDogrula(users);
        ekran.kullaniciDogrulanmaMesaji(userValidation);
        do {
            if (userValidation){
            	options = ekran.kullaniciSecenekleri(tusTakimi);
                cikisMi = kullaniciIslemleri(options);
            }
            else {
                ekran.mesajYaz("Tekrar seçim yapcak misiniz? (E/H)");
                boolean tekrarDenensinMi = tusTakimi.stringVeriAl().equalsIgnoreCase("E");
                if (tekrarDenensinMi){
                	users = ekran.kullaniciGirisEkrani(tusTakimi);
                	userValidation = KisilerRepositoryPostgreSql.kullaniciDogrula(users);
                }
                else
                	cikisMi = true;
            }
        }while (!cikisMi);

        ekran.kullaniciCikisEkrani();
        thread.stop();
    }

    private boolean kullaniciIslemleri(int option2){
        boolean cikisMi = false;

        switch (option2){
            case 0:
            	cikisMi = true;
                break;
            case 1:
            	ekran.sogutucuAc(agArayuzu);
                
                break;
            case 2:
            	ekran.sogutucuKapat(agArayuzu);
                break;
            case 3:
            	ekran.sicaklikGoruntule(agArayuzu);
                break;
        }

        return cikisMi;
    }

}


