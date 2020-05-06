package G171210009;

import java.time.LocalDateTime;

public class LogEkran {
    private static LogEkran instance;

    private LogEkran() {

    }

    public static synchronized LogEkran getInstance() {
        if (instance == null)
            instance = new LogEkran();
        return instance;
    }

    public void ekranaYaz(String mesaj) {
        System.out.print(mesaj);
        LogDosya.getInstance().dosyayaYaz(mesaj);
    }

    public void ekranaYazln(String mesaj) {
        System.out.println(LocalDateTime.now() + ": " + mesaj);
        LogDosya.getInstance().dosyayaYaz(mesaj);
    }


}
