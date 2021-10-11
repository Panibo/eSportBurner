package fi.hyte.esportsburner;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class Kellotin {

    private Context context;
    public Kellotin(Context context) {
        this.context = context;
    }

    public void setAlarmManager() {
        Intent intent = new Intent(context, Taustatyökalut.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 2, intent, 0);
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        if (am != null) {
            long painamisenJalkeen = 60 * 60 * 1000 * 24;
            long tamanJalkeenAina = 60 * 60 * 1000 * 24;

            am.setRepeating(AlarmManager.RTC_WAKEUP, 0, 0, sender);
        }
    }

    public void cancelAlarmManager() {
        Intent intent = new Intent(context, Taustatyökalut.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 2, intent, 0);
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        if (am != null) {
            am.cancel(sender);
        }


    }
}
