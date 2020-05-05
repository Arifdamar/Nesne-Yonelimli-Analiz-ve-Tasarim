package G171210009;

public class EyleyiciY implements IEyleyici {

    KritikSogutma kritikSogutma;

    public EyleyiciY() {
        this.kritikSogutma = new KritikSogutma();
    }

    public KritikSogutma getKritikSogutma() {
        return this.kritikSogutma;
    }

    @Override
    public int sogutucuAc(int sicaklik, String tur) throws InterruptedException {
        Log.getInstance().ekranaYazln("Soğutucu Açılıyor... Sıcaklık Düşürülüyor...");
        Thread.sleep(2000);
        Log.getInstance().ekranaYaz("Sıcaklık, " + sicaklik + " " + tur + "'den ");
        sicaklik -= 15;
        Log.getInstance().ekranaYaz(sicaklik + " " + tur + "'e düşürüldü...\n");
        return sicaklik;
    }

    @Override
    public void sogutucuKapat() throws InterruptedException {
        Log.getInstance().ekranaYazln("Soğutucu Kapatılıyor...");
        Thread.sleep(2000);
        Log.getInstance().ekranaYazln("Soğutucu Kapatıldı...");
    }
}
