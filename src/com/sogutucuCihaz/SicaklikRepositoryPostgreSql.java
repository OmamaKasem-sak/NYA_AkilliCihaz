package com.sogutucuCihaz;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SicaklikRepositoryPostgreSql implements ISicaklikRepository {

    @Override
    public void update(int sicaklikDegeri) {
        this.kaydet(sicaklikDegeri);
    }

    private Connection baglan() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AkilliSogutucu",
                    "postgres", "3217589");
            if (conn == null)
                System.out.println("Veritabanına bağlanılamadı: sıcaklık değeri ölçülemedi");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    private void kaydet(int sicaklik) {
        String sql = "INSERT INTO  \"Sicaklik\" (\"sicaklik\",\"saat\") " +
                "VALUES(\'" + sicaklik + "\',\'" + new Timestamp(System.currentTimeMillis()) + "\')";

        Connection conn = this.baglan();

        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            //***** Bağlantı sonlandırma *****
            conn.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int sonSicaklikGetir() {
        String sql = "SELECT \"sicaklik\" FROM \"Sicaklik\" ORDER BY \"saat\" DESC LIMIT 1";
        int sicaklikDegeri = 9999;

        Connection conn = this.baglan();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            //***** Bağlantı sonlandırma *****
            conn.close();

            while (rs.next()) {
            	sicaklikDegeri = rs.getInt("sicaklik");
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sicaklikDegeri;
    }
}