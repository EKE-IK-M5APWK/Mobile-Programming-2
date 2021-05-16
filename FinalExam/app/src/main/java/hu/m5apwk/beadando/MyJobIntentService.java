package hu.m5apwk.beadando;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

public class MyJobIntentService extends JobIntentService {

    private static final String TAG = "MyJobIntentService";
    private static final int JOB_ID = 42;

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        int i = intent.getIntExtra("data",-1);

        Log.d(TAG, "MyJobIntentService started ...");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.d(TAG, "Result: " + String.valueOf(i));
    }

    static void enqueueWork(Context context, Intent intent){
        enqueueWork(context, MyJobIntentService.class, JOB_ID, intent);
    }
}
