package G171210009;

public class KritikSogutucu implements IObserver {

    @Override
    public int kritikDurum(int kritikSicaklik, IEyleyici eyleyici) throws InterruptedException {
        return eyleyici.sogutucuAc(kritikSicaklik, eyleyici instanceof SicaklikAlgilayiciCelsius ? "°C" : "°F");
    }

}
