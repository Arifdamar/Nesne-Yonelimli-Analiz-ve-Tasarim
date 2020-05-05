package G171210009;

import java.util.Random;

public class SicaklikAlgilayiciCelsius implements ISicaklikAlgilayici {

    @Override
    public int sicaklikOku() throws InterruptedException {
        LogEkran.getInstance().ekranaYazln("Sıcaklık Okunuyor...");
        Random rand = new Random();
        int randomValue = rand.nextInt(60);
        Thread.sleep(1000);
        LogEkran.getInstance().ekranaYazln("Sıcaklık: " + randomValue + "°C");
        return randomValue;
    }
}