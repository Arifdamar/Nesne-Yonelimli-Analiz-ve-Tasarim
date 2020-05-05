package G171210009;
import java.util.Random;

public class SicaklikAlgilayiciCelsius implements ISicaklikAlgilayici {

    @Override
    public int sicaklikOku() {
        Random rand = new Random();
        int randomValue = rand.nextInt(60);
        Log.getInstance().ekranaYazln("Sıcaklık: " + randomValue + "°C");
        return randomValue;
    }
}