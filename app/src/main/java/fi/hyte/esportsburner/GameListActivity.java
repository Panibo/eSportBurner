package fi.hyte.esportsburner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Aktiviteetti joka näyttää käyttäjälle listan peleistä ja josta hän voi valita haluamansa pelin
 * @author Miro Mariapori
 */

public class GameListActivity extends AppCompatActivity {
    /**
     * Luo aktiviteetin
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);

        ListView lv = findViewById(R.id.lista);

        lv.setAdapter(new ArrayAdapter<>(
                this,
                R.layout.game_item_layout,
                Global.getInstance().getGames()));

        lv.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent nextActivity = new Intent(GameListActivity.this, GameDataActivity.class);
            nextActivity.putExtra("NIMI", Global.getInstance().getGames().get(i).toString());
            nextActivity.putExtra("KUVA", Global.getInstance().getGames().get(i).getImageid());
            nextActivity.putExtra("KALORIT", Global.getInstance().getGames().get(i).getKalorit());
            startActivity(nextActivity);
        });

    }
}