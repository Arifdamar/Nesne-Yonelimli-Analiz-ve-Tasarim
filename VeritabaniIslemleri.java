package G171210009;

import java.sql.*;

public class VeritabaniIslemleri {

    public boolean girisYap(String k_adi, String pass) { // Başarılı bir şekilde giriş yapılıp yapılmadığını döndürür
        try {
            boolean girisDurumu;
            User kullanici = null;

            /***** Bağlantı kurulumu *****/
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/G171210009_DB",
                    "postgres", "123456789");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else {
                System.out.println("Bağlantı girişimi başarısız!");
                return false;
            }


            String sql = "SELECT *  FROM \"_User\" WHERE \"userName\"='" + k_adi + "' and \"password\"='" + pass + "'";

            /***** Sorgu çalıştırma *****/
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);


            /***** Bağlantı sonlandırma *****/
            conn.close();

            Thread.sleep(500);
            if (rs.next() == false) {
                System.out.println("Böyle bir kullanıcı bulunamadı...");
                girisDurumu = false;
            }
            else {
                System.out.println("Giriş başarılı...");
                kullanici = new User(rs.getInt("Id"), rs.getString("userName"), rs.getString("password"));
                LogDosya.getInstance().dosyayaYaz("Yeni Oturum... Kullanıcı Bilgileri: Id: " + kullanici.id
                + " userName: " + kullanici.userName);
                girisDurumu = true;
            }

            /***** Kaynakları serbest bırak *****/
            rs.close();
            stmt.close();
            return girisDurumu;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
