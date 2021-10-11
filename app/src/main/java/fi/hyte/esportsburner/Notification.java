package fi.hyte.esportsburner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class Notification extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder rakentaja = new NotificationCompat.Builder(context, "ville")
                .setSmallIcon(R.drawable.logomain)
                .setContentTitle("eSportsBurner")
                .setContentText("MUISTA PELATA!!")

                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat nm = NotificationManagerCompat.from(context);

        nm.notify(1, rakentaja.build());




    }
}
