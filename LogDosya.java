package G171210009;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class LogDosya {

    private static LogDosya instance;
    private PrintWriter out;

    private LogDosya(){
        try {
            out = new PrintWriter(new FileWriter("log.txt",true), true);
        } catch (IOException e) {e.printStackTrace();}
    }

    public static synchronized LogDosya getInstance() {
        if (instance == null)
            instance = new LogDosya();
        return instance;
    }

    public void dosyayaYaz(String mesaj) {
        out.println(LocalDateTime.now()+":"+mesaj);
    }
}
