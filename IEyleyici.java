package G171210009;

public interface IEyleyici {
    IObserver getKritikSogutucu();
    int sogutucuAc(int sicaklik, String tür) throws InterruptedException;
    void sogutucuKapat() throws InterruptedException;

}
