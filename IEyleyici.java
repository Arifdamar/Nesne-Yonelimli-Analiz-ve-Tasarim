package G171210009;

public interface IEyleyici {
    IObserver getKritikSogutma();

    int sogutucuAc(int sicaklik, String tür) throws InterruptedException;

    void sogutucuKapat() throws InterruptedException;

}
