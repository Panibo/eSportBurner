package fi.hyte.esportsburner;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * @author Ville
 * Tämä
 */

public class MainActivity extends AppCompatActivity {


    ImageButton nappi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * Metodi, joka auttaa luomaan ilmoitus kanavan.
         */
        createNotificationChannel();

        /**
         * Tässä etsitään button_lista nappi id:n avulla ja asetetaan onclick listener.
         * Nappia painamalla päästään GameListActivityyn.
         */

        ImageButton listaButton = findViewById(R.id.button_lista);
        listaButton.setOnClickListener(view -> goToLista());


        ImageButton profiiliButton = findViewById(R.id.button_profiili);
        profiiliButton.setOnClickListener(view -> goToProfiili());

        /**
         * Luodaan toinen nappi, joka etsitään id:n avulla.
         * Asetetaan onclick listener, joka toteutuu, kun käyttäjä painaa kyseistä nappia.
         */

        nappi = (ImageButton) findViewById(R.id.ilmoitusnappi);
        nappi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /**
                 * Toast komento tapahtuu, kun nappia painetaan.
                 * Ruudulle tulee teksti "ilmoitus luotu!" nappia painamalla.
                 */

                Toast.makeText(getApplicationContext(), "Ilmoitus luotu!", Toast.LENGTH_SHORT).show();

                /**
                 * Intent on toiminnan käynnistämisen koodi, joka tässä luodaan.
                 * Luo aktiviteetin.
                 */

                Intent intent = new Intent(MainActivity.this, Notification.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this,0,intent,0);

                /**
                 * Ajastin, joka laskee 10 sekunttia painamisesta, jonka jälkeen ilmoitus käynnistyy.
                 */

                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                long napinpainaminen = System.currentTimeMillis();
                long tunti = 1000 * 10;

                alarmManager.set(AlarmManager.RTC_WAKEUP, napinpainaminen + tunti, pendingIntent);

            }
        });




    }

    /**
     * Ilmoituskanava, jonka avulla ilmoitus tulee käyttäjällä näkyviin.
     */
    private void createNotificationChannel() {
        String nimi = "ville";
        String sisältö = "Channelville";
        int tärkeys = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel kanava = new NotificationChannel("ville", nimi, tärkeys);
        kanava.setDescription(sisältö);

        NotificationManager nm = getSystemService(NotificationManager.class);
        nm.createNotificationChannel(kanava);



    }

    /**
     *
     */

    private void goToLista(){
        Intent intent = new Intent(this, GameListActivity.class);
        startActivity(intent);
    }

    private void goToProfiili(){
        Intent intent = new Intent(this, ProfiiliActivity.class);
        startActivity(intent);
    }



}