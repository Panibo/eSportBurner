package fi.hyte.esportsburner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.StringTokenizer;

public class GameDataActivity extends AppCompatActivity {
    /**
     Holds the name of the game
     */
    private String nimi;
    /**
     Holds the ammount of calories burned in one hour
     */
    private int kaloritTunnissa;
    /**
     Stores the played hours
     */
    private int tunnit;
    /**
     Holds the R.Drawable id of the image of the game
     */
    private int imageid;
    /**
     Holds the TextView that displays the total burned calories to the user
     */
    private TextView kaloriView;
    /**
     Holds the TextView that displays the total hours played to the user
     */
    private TextView tuntiView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_data);

        TextView nimiView = findViewById(R.id.nimiView);
        ImageView gameView = findViewById(R.id.gameImage);

        kaloriView = findViewById(R.id.kaloriView);
        tuntiView = findViewById(R.id.tuntiView);

        getIntentData();
        getPreviousData();

        nimiView.setText(nimi);
        gameView.setImageResource(imageid);

        Button lisaaButton = findViewById(R.id.button_lisaa);
        lisaaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lisaa();
            }
        });
    }


    private void getIntentData(){

        Intent intent = getIntent();
        nimi = intent.getStringExtra("NIMI");
        kaloritTunnissa = intent.getIntExtra("KALORIT", 0);
        imageid = intent.getIntExtra("KUVA", R.drawable.eikuvaa);
        tuntiView.setText(String.valueOf(tunnit));
        kaloriView.setText(String.valueOf(tunnit*kaloritTunnissa));
    }

    private int getPreviousData(){

        SharedPreferences prefGet = getSharedPreferences(nimi ,Activity.MODE_PRIVATE);
        return prefGet.getInt("TUNNIT", 0);

    }

    private void lisaa(){
        EditText editText = findViewById(R.id.editTunnit);
        if(editText.getText().toString().matches("")){
            return;
        }
        tunnit += Integer.parseInt(String.valueOf(editText.getText()));
        tuntiView.setText(String.valueOf(tunnit));
        kaloriView.setText(String.valueOf(tunnit*kaloritTunnissa));
        editText.setText("");
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefPut = getSharedPreferences(nimi, Activity.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefPut.edit();
        prefEditor.putInt("TUNNIT", tunnit);
        prefEditor.commit();

    }
}