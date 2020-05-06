package G171210009;

import java.sql.*;

public class VeritabaniIslemleri implements IVeritabaniIslemleri {

    private Connection baglan() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/G171210009_DB",
                    "postgres", "123456789");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    @Override
    public boolean girisYap(String k_adi, String pass) { // Başarılı bir şekilde giriş yapılıp yapılmadığını döndürür
        try {
            boolean girisDurumu;

            Connection conn = this.baglan(); // Veritabanı bağlantısı yapılır

            // Konsoldan girilen bilgilere uygun kişiyi veritabanından seçmek için gerekli SQL sorgusu yazılır
            String sql = "SELECT *  FROM \"_User\" WHERE \"userName\"='" + k_adi + "' and \"password\"='" + pass + "'";

            // Sorgu çalıştırılır
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Veritabanı bağlantısı sonlandırılır
            conn.close();

            Thread.sleep(500);
            if (!rs.next()) { // Veritabanından dönen ResultSet boş ise böyle bir kullanıcı yoktur
                System.out.println("Böyle bir kullanıcı bulunamadı...");
                girisDurumu = false;
            } else { // ResultSet boş değilse giriş başarılıdır
                System.out.println("Giriş başarılı...");

                // Oturum, kullanıcı bilgileriyle birlikte dosyaya loglanır
                LogDosya.getInstance().log("Yeni Oturum... Kullanıcı Bilgileri: Id: " + rs.getInt("Id")
                        + " userName: " + rs.getString("userName"));
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
