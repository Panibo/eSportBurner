package fi.hyte.esportsburner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

/**
 * @author Ville
 * aktiviteetti, jossa on ilmoituksen rakentaja.
 *broadcastreceiver luokka
 */

public class Notification extends BroadcastReceiver {
    @Override
    /**
     * Menetelmä kun BroadcastReceiver vastaanottaa intent koodin.
     * Eli, kun nappia painetaan notification rakentuu.
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
         *From metodi hakee komennon (napin painaminen) ja lähettää ilmoituksen kännykkään.
         */


        NotificationManagerCompat nm = NotificationManagerCompat.from(context);

        nm.notify(1, rakentaja.build());




    }
}
