package hu.kormany.milan.serviceapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import android.os.Process;

public class MyService extends Service {

    private Looper serviceLooper;
    private ServiceHandler serviceHandler;
    // Handler ami megkapja a Thread üzeneteit
    private final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }
        @Override
        public void handleMessage(Message msg) {
            // Szokás szerint csak szimulálunk egy hosszan tartó folyamatot.
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            // Állítsuk le a Service-t az ID-vel, így véletlenül nem kerülhet leállításra
            // amikor egy másik feladaton dolgozik.
            stopSelf(msg.arg1);
        }
    }


    @Override
    public void onCreate() {
        // Mivel a Service a UIThread-en fut, emiatt indítunk egy saját thread-et.
        // Továbbá háttérthread-ként indítjuk, így a GUI működését nem akadályozzuk.
        HandlerThread thread = new HandlerThread("ServiceStartArguments",
                Process.THREAD_PRIORITY_BACKGROUND);
        thread.start();
        // A thread saját Looper-ét használjuk a saját Handler-ünkhöz
        serviceLooper = thread.getLooper();
        serviceHandler = new ServiceHandler(serviceLooper);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service starting", Toast.LENGTH_SHORT).show();
        // A handler előre elkészített Message példányát használjuk fel,
        // annak Message pool-jából. Továbbá abban tároljuk azt az ID-t amire hivatkozni
        // akarunk amikor meg akarjuk a Service-t állítani.
        Message msg = serviceHandler.obtainMessage();
        msg.arg1 = startId;
        serviceHandler.sendMessage(msg);
        // Ezzel tudjuk azt a rendszernek megadni, hogy ha leállításra kerül a Service,
        // akkor amint lehet indítsa újra.
        return START_STICKY;
    }
    @Override
    public IBinder onBind(Intent intent) {
        // Nem biztosítunk kötés kialakításához interfészt, csak indítani lehet a Service-t.
        return null;
    }
    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service done", Toast.LENGTH_SHORT).show();
    }
}