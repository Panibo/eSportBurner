package fi.hyte.esportsburner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton nappi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nappi = (ImageButton) findViewById(R.id.ilmoitusnappi);
        nappi.setOnClickListener(view -> showNotification());


        Kellotin kellotin = new Kellotin(this);
        kellotin.cancelAlarmManager();
        kellotin.setAlarmManager();

        ImageButton listaButton = findViewById(R.id.button_lista);
        listaButton.setOnClickListener(view -> goToLista());
    }

    private void showNotification() {

        String id = "main_channel";
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        CharSequence nimi = "eSportsBurner";
        String sisalto = "MUISTA PELATA!";
        int tärkeys = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel notificationChannel = new NotificationChannel(id, nimi, tärkeys);
        notificationChannel.setDescription(sisalto);
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(Color.WHITE);
        notificationChannel.enableVibration(true);
        if(notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, id);
        notificationBuilder.setSmallIcon(R.mipmap.ic_launcher);
        notificationBuilder.setContentTitle("eSportsBurner");
        notificationBuilder.setContentText("MUISTA PELATA!");
        notificationBuilder.setLights(Color.WHITE, 500, 5000);
        notificationBuilder.setColor(Color.BLUE);
        notificationBuilder.setDefaults(Notification.DEFAULT_SOUND);
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(1000, notificationBuilder.build());

    }



    public void goToLista(){
        Intent intent = new Intent(this, GameListActivity.class);
        startActivity(intent);
    }





}