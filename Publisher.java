package G171210009;

import java.util.ArrayList;
import java.util.List;

public class Publisher implements ISubject {

    private List<IObserver> subscribers = new ArrayList<>();

    @Override
    public void attach(IObserver subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void detach(IObserver subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public int kritikDurumBildir(String mesaj, int kritikSicaklik, IEyleyici eyleyici) throws InterruptedException {
        Log.getInstance().ekranaYazln(mesaj);
        for(IObserver subscriber: subscribers) {
            kritikSicaklik = subscriber.kritikDurum(kritikSicaklik, eyleyici);
        }
        return kritikSicaklik;
    }
}
