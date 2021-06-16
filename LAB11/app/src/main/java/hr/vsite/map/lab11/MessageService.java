package hr.vsite.map.lab11;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import java.io.IOException;
import java.util.Calendar;


public class MessageService extends IntentService {

    public MessageService() {
        super("MessageService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
                Intent noviIntent = new Intent(this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 12, noviIntent, 0);

                NotificationCompat.Builder graditeljObavijesti = new NotificationCompat.Builder(this, MainActivity.CHANNEL_ID );
            for(int i=0;i<5;++i) {
                graditeljObavijesti
                        .setContentTitle("Current Time Notification")
                        .setContentText(Calendar.getInstance().getTime().toString())
                        .setSmallIcon(R.drawable.ic_android)
                        .setContentIntent(pendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setAutoCancel(true);

                Notification obavijest = graditeljObavijesti.build();
                NotificationManager servisManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                servisManager.notify(1, obavijest);
                android.os.SystemClock.sleep(30000);
            }
        }
    }
}
