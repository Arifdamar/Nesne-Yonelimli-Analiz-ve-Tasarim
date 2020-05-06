package G171210009;

import java.io.Serializable;
import java.util.List;

public class MerkeziIslemBirimiCihaz implements IMerkeziIslemBirimiCihaz {
    private final ISicaklikAlgilayici sicaklikAlgilayici;
    private final IEyleyici eyleyici;
    private final ISubject publisher;

    private int sonSicaklik;
    private String tur;
    private int kritikSicaklik;


    public MerkeziIslemBirimiCihaz() {
        this.sicaklikAlgilayici = new SicaklikAlgilayiciCelsius();
        this.eyleyici = new EyleyiciX();
        this.publisher = new Publisher();

        this.publisher.attach(this.eyleyici.kritikSogutma);
    }

    @Override
    public void sicaklikOku() throws InterruptedException {
        List<Serializable> algilayiciBilgileri = this.sicaklikAlgilayici.sicaklikOku();
        this.sonSicaklik = (int) algilayiciBilgileri.get(0); // 0. elemanda sıcaklık bilgisi bulunur
        this.kritikSicaklik = (int) algilayiciBilgileri.get(1); // 1. elemanda kritik sıcaklık bilgisi bulunur
        this.tur = (String) algilayiciBilgileri.get(2); // 2. elemanda algılayıcının hangi türde sıcaklık okuduğu bilgisi bulunur

        if (this.sonSicaklik >= this.kritikSicaklik) {
            this.sonSicaklik = this.publisher.kritikSicaklikBildir("***Sıcaklık Kritik Eşiğin Üzerinde!!***", this.sonSicaklik, this.eyleyici, this.tur);
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
