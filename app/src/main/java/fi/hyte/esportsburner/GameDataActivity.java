package fi.hyte.esportsburner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Aktiviteetti joka näyttää käyttäjälle valitsemansa pelin tallennetut tiedot
 * ja josta hän pystyy myös muokata pelattua tuntimäärää
 * @author Miro Mariapori
 */

public class GameDataActivity extends AppCompatActivity {
    /**
     * Tallentaa paikallisesti pelin nimen
     */
    private String nimi;
    /**
     * Tallentaa paikallisesti paljonko peli polttaa kaloreita tunnissa
     */
    private int kaloritTunnissa;

    /**
     * Tallentaa paikallisesti pelatut tunnit
     */
    private int tunnit;

    /**
     * Luo aktiviteetin
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_data);

        TextView nimiView = findViewById(R.id.nimiView);
        ImageView gameView = findViewById(R.id.gameImage);

        Intent intent = getIntent();
        nimi = intent.getStringExtra("NIMI");
        kaloritTunnissa = intent.getIntExtra("KALORIT", 0);
        nimiView.setText(nimi);
        gameView.setImageResource(intent.getIntExtra("KUVA", R.drawable.eikuvaa));

        tunnit = getPreviousData();
        setTeksti();

        Button lisaaButton = findViewById(R.id.button_lisaa);
        ImageButton resetButton = findViewById(R.id.button_reset);
        lisaaButton.setOnClickListener(view -> lisaa());
        resetButton.setOnClickListener(view -> reset());
    }

    /**
     * Asettaa pelatut tunnit ja poltetut kalorit käyttäjälle näkyviin
     */
    private void setTeksti(){
        TextView kaloriView = findViewById(R.id.kaloriView);
        TextView tuntiView = findViewById(R.id.tuntiView);
        tuntiView.setText(String.valueOf(tunnit));
        kaloriView.setText(String.valueOf(tunnit*kaloritTunnissa));
    }

    /**
     * Hakee tallennetusta preferenssistä aikaisemmat tiedot
     * @return palauttaa aikaisemmat pelatut tunnit
     */
    private int getPreviousData(){

        SharedPreferences prefGet = getSharedPreferences(nimi ,Activity.MODE_PRIVATE);
        return prefGet.getInt("TUNNIT", 0);

    }
    private void reset(){
        tunnit = 0;
        setTeksti();
    }

    /**
     * Lisää käyttäjän antamat tunnit paikalliseen muuttujaan
     */
    private void lisaa(){
        EditText editText = findViewById(R.id.editTunnit);
        if(editText.getText().toString().matches("")){
            return;
        }
        tunnit += Integer.parseInt(String.valueOf(editText.getText()));
        setTeksti();
        editText.setText("");
    }

    /**
     * Tallentaa tunnit preferenssiin
     */
    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefPut = getSharedPreferences(nimi, Activity.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefPut.edit();
        prefEditor.putInt("TUNNIT", tunnit);
        prefEditor.commit();

    }
}