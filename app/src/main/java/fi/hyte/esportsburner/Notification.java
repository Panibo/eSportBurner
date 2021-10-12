package fi.hyte.esportsburner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

/**
 * @author Ville
 * aktiviteetti, jossa on ilmoituksen rakentaja.
 *
 */

public class Notification extends BroadcastReceiver {
    @Override
    /**
     * Menetelmä kun BroadcastReceiver vastaanottaa intent koodin.
     */
    public void onReceive(Context context, Intent intent) {

        /**
         * Tässä on rakentajaluokka NotificationCompat.Builder, joka rakentaa ilmoituksen.
         * Rakentaja asettaa ilmoitukselle kuvakkeen, otsikon, nimen ja prioriteetin.
         */

        NotificationCompat.Builder rakentaja = new NotificationCompat.Builder(context, "ville")
                .setSmallIcon(R.drawable.logomain)
                .setContentTitle("eSportsBurner")
                .setContentText("MUISTA PELATA!!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);


        /**
         * ilmoitukselle on luotava channel, jonka avulla ilmoitus tulee näkyviin.
         *Kun
         */


        NotificationManagerCompat nm = NotificationManagerCompat.from(context);

        nm.notify(1, rakentaja.build());




    }
}
