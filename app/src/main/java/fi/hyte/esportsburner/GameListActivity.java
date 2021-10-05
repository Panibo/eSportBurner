package fi.hyte.esportsburner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class GameListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);

        ListView lv = findViewById(R.id.lista);

        lv.setAdapter(new ArrayAdapter<Game>(
        this,
                android.R.layout.simple_list_item_1,
                Global.getInstance().getGames()));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent nextActivity = new Intent(GameListActivity.this, GameDataActivity.class);
                nextActivity.putExtra("NIMI", Global.getInstance().getGames().get(i).toString());
                startActivity(nextActivity);
            }
        });

    }
}