package G171210009;

import java.time.LocalDateTime;

public class Log {
    private static Log instance;

    public static synchronized Log getInstance() {
        if (instance == null)
            instance = new Log();
        return instance;
    }

    public void ekranaYaz(String mesaj) {
        System.out.print(LocalDateTime.now() + ": " + mesaj);
    }

    public void ekranaYazln(String mesaj){
        System.out.println(LocalDateTime.now() + ": " + mesaj);
    }
}
