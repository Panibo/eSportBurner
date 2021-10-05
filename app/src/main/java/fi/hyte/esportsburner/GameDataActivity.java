package fi.hyte.esportsburner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameDataActivity extends AppCompatActivity {

    private String nimi;
    private int kalorit;
    private TextView kaloriView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_data);

        TextView nimiView = findViewById(R.id.nimiView);
        kaloriView = findViewById(R.id.kaloriView);

        Intent intent = getIntent();
        nimi = intent.getStringExtra("NIMI");
        nimiView.setText(nimi);

        SharedPreferences prefGet = getSharedPreferences(nimi ,Activity.MODE_PRIVATE);
        kalorit = prefGet.getInt("KALORIT", 0);
        kaloriView.setText(String.valueOf(kalorit));

        Button lisaaButton = findViewById(R.id.button_lisaa);
        lisaaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lisaa();
            }
        });
    }

    private void lisaa(){
        EditText editText = findViewById(R.id.editTunnit);
        kalorit += Integer.parseInt(String.valueOf(editText.getText()));
        kaloriView.setText(String.valueOf(kalorit));
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefPut = getSharedPreferences(nimi, Activity.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefPut.edit();
        prefEditor.putInt("KALORIT", kalorit);
        prefEditor.commit();

    }
}