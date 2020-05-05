package G171210009;

import java.util.Random;

public class SicaklikAlgilayiciKelvin implements ISicaklikAlgilayici {

    @Override
    public int sicaklikOku() {

        Random rand = new Random();
        int randomValue = rand.nextInt(60) + 273;
        Log.getInstance().ekranaYazln("Sıcaklık: " + randomValue + "°K");
        return randomValue;
    }
}
