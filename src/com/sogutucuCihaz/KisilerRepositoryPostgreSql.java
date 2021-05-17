package com.sogutucuCihaz;

//import sun.security.krb5.internal.crypto.KeyUsage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList; //
import java.util.List;

public class KisilerRepositoryPostgreSql implements IKisilerRepository{

    private Connection baglan() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AkilliSogutucu",
                    "postgres", "3217589");
            if (conn != null)
                System.out.println("Veritabanina baglanildi.");
            else
                System.out.println("Veritabanina bağlanılamadı.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public boolean kullaniciDogrula(Kullanici kullanici) {
        System.out.println("Kullanici dogrulaniyor...\n");

        boolean sonuc = false;

        String sql = "SELECT * FROM \"Kullanicilar\" WHERE isim = \'" + kullanici.getIsim() +
                "\' AND sifre = \'" + kullanici.getSifre() + "\'" ;

        Connection conn = this.baglan();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            //***** Bağlantı sonlandırma *****
            conn.close();

            sonuc = rs.next();

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sonuc;
    }
}