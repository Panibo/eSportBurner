package fi.hyte.esportsburner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

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

public class MainActivity extends AppCompatActivity {

    ImageButton nappi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();

        ImageButton listaButton = findViewById(R.id.button_lista);
        listaButton.setOnClickListener(view -> goToLista());

        nappi = (ImageButton) findViewById(R.id.ilmoitusnappi);
        nappi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Ilmoitus luotu!", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(MainActivity.this, Notification.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this,0,intent,0);

                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                long napinpainaminen = System.currentTimeMillis();
                long tunti = 1000 * 10;

                alarmManager.set(AlarmManager.RTC_WAKEUP, napinpainaminen + tunti, pendingIntent);

            }
        });




    }

    private void createNotificationChannel() {
        String nimi = "ville";
        String sisältö = "Channelville";
        int tärkeys = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel kanava = new NotificationChannel("ville", nimi, tärkeys);
        kanava.setDescription(sisältö);

        NotificationManager nm = getSystemService(NotificationManager.class);
        nm.createNotificationChannel(kanava);



    }



    private void goToLista(){
        Intent intent = new Intent(this, GameListActivity.class);
        startActivity(intent);
    }





}