package G171210009;

public class MerkeziIslemBirimiCihaz implements IMerkeziIslemBirimiCihaz {
    private final ISicaklikAlgilayici sicaklikAlgilayici;
    private final IEyleyici eyleyici;
    private final ISubject publisher;

    private int sonSicaklik;
    private boolean yetki;
    private String tur;


    public MerkeziIslemBirimiCihaz() {
        this.sicaklikAlgilayici = new SicaklikAlgilayiciCelsius();
        this.eyleyici = new EyleyiciX();
        this.publisher = new Publisher();

        this.tur = "°C";
        this.sonSicaklik = 25;
        this.publisher.attach(this.eyleyici.kritikSogutma);
    }

    @Override
    public void sicaklikOku() throws InterruptedException {
        this.sonSicaklik = this.sicaklikAlgilayici.sicaklikOku();
        if (this.sonSicaklik >= (tur == "°C" ? 40 : 40 + 273)) {
            this.sonSicaklik = this.publisher.kritikDurumBildir("***Sıcaklık Kritik Eşiğin Üzerinde!!***", this.sonSicaklik, this.eyleyici, this.tur);
        }
    }

    @Override
    public void sogutucuAc() throws InterruptedException {
        this.sonSicaklik = this.eyleyici.sogutucuAc(this.sonSicaklik, this.tur);
    }

    @Override
    public void sogutucuKapat() throws InterruptedException {
        this.eyleyici.sogutucuKapat();
    }


}
