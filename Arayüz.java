package G171210009;

import java.util.Scanner;

public class Arayüz {

    public static void main(String[] args) throws InterruptedException {

        Scanner scan = new Scanner(System.in);
        MerkeziIslemBirimiGiris giris = new MerkeziIslemBirimiGiris();

        String kullaniciAdi, sifre;

        /* Durum,
            1 ise -> Cihaz Kapalı (cihaz aç)
            2 ise -> Cihaz Beklemede(soğutucu aç, kapat, sıcaklık oku)
            3 ise -> Cihazın sıcaklığı okuduğu durum
            4 ise -> Cihazın soğutucuyu açıp kapatması esnasındaki durum
         */
        int durum = 1; // Cihaz kapalı olarak başlar

        System.out.println("**Kullanıcı Adınızı Giriniz**");
        kullaniciAdi = scan.nextLine();

        System.out.println("**Şifrenizi Giriniz**");
        sifre = scan.nextLine();

        if (giris.girisYap(kullaniciAdi, sifre)) {

            if (durum == 1) {
                int secim = 0;
                do {
                    System.out.println("**Cihazı açmak için 1'e basınız**");
                    secim = scan.nextInt();
                } while (secim != 1);
                durum = 2;
            }


            if (durum == 2) {

                IMerkeziIslemBirimiCihaz islemci = new MerkeziIslemBirimiCihaz();
                int secim = 0;
                do {
                    System.out.println("Lütfen Bir İşlem Seçiniz");
                    System.out.println("1-Sıcaklığı Oku");
                    System.out.println("2-Soğutucuyu Aç");
                    System.out.println("3-Soğutucuyu Kapat");
                    System.out.println("4-Çıkış Yap");
                    secim = scan.nextInt();

                    switch (secim) {
                        case 1:
                            islemci.sicaklikOku();
                            break;
                        case 2:
                            islemci.sogutucuAc();
                            break;
                        case 3:
                            islemci.sogutucuKapat();
                            break;
                        case 4:
                            System.out.println("Çıkış Yapılıyor...");
                            Thread.sleep(1000);
                            break;
                        default:
                            System.out.println("**Lütfen Geçerli Bir Seçenek Giriniz**");
                    }

                } while (secim != 4);
            }

        }

    }
}
