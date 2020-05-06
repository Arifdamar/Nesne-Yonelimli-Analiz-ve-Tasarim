package G171210009;

public class EyleyiciX implements IEyleyici {

    @Override
    public int sogutucuAc(int sicaklik, String tur) throws InterruptedException {
        LogEkran.getInstance().ekranaYazln("Soğutucu Açılıyor... Sıcaklık Düşürülüyor...");
        Thread.sleep(1000);
        sicaklik -= 10;
        LogEkran.getInstance().ekranaYazln("Sıcaklık, " + (sicaklik + 10) + " " + tur + "'den " + sicaklik + " " + tur + "'e düşürüldü...");
        return sicaklik;
    }

    @Override
    public void sogutucuKapat() throws InterruptedException {
        LogEkran.getInstance().ekranaYazln("Soğutucu Kapatılıyor...");
        Thread.sleep(1000);
        LogEkran.getInstance().ekranaYazln("Soğutucu Kapatıldı...");
    }

}
