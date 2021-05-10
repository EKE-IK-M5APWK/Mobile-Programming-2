package hu.kormany.milan.wordmanagerapplication;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {

    private static final String CHANNEL_ID = "MyChannel";
    Context mContext;

    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.mContext = context;
    }

    @NonNull
    @Override
    public Result doWork() {

        Data data = getInputData();
        String message = data.getString("data");
        showMessage(message);
        Data outputData = new Data.Builder().putString("result", "Work finshed!").build();
        return Result.success(outputData);
    }

    private void showMessage(String message){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext,
                CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_announcement_black_24dp)
                .setContentTitle("Work Manager Notification")
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        int notificationId = 1;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Channel name";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel =
                    new NotificationChannel(CHANNEL_ID, name, importance);
            NotificationManager notificationManager =
                    mContext.getSystemService(NotificationManager.class);
            String description = "Channel description";
            channel.setDescription(description);
            notificationManager.createNotificationChannel(channel);
            notificationManager.notify(notificationId, builder.build());
        } else {
            NotificationManagerCompat notificationManager =
                    NotificationManagerCompat.from(mContext);
            notificationManager.notify(notificationId, builder.build());
        }
    }





}
