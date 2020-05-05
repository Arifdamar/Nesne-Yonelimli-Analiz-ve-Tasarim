package G171210009;

public class Eyleyici implements IEyleyici{

    KritikSogutucu kritikSogutucu;

    public Eyleyici(){
        this.kritikSogutucu = new KritikSogutucu();
    }

    public KritikSogutucu getKritikSogutucu(){
        return this.kritikSogutucu;
    }

    @Override
    public int sogutucuAc(int sicaklik, String tur) throws InterruptedException {
        Thread.sleep(1000);
        Log.getInstance().ekranaYazln("Soğutucu Açılıyor... Sıcaklık Düşürülüyor...");
        Log.getInstance().ekranaYaz("Sıcaklık, " + sicaklik + " " + tur + "'den ");
        sicaklik -= 10;
        Log.getInstance().ekranaYaz(sicaklik + " " + tur + "'e düşürüldü...\n");
        return sicaklik;
    }

    @Override
    public void sogutucuKapat() throws InterruptedException {
        Log.getInstance().ekranaYazln("Soğutucu Kapatılıyor...");
        Thread.sleep(1000);
        Log.getInstance().ekranaYazln("Soğutucu Kapatıldı...");
    }

}
