package G171210009;

public interface ISubject {
    void attach(IObserver obs);
    void detach(IObserver obs);
    int kritikDurumBildir(String message, int kritikSicaklik, IEyleyici eyleyici, String tur) throws InterruptedException;
}
