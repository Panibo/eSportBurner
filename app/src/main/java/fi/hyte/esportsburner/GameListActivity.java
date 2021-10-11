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
                R.layout.game_item_layout,
                Global.getInstance().getGames()));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent nextActivity = new Intent(GameListActivity.this, GameDataActivity.class);
                nextActivity.putExtra("NIMI", Global.getInstance().getGames().get(i).toString());
                nextActivity.putExtra("KUVA", Global.getInstance().getGames().get(i).getImageid());
                nextActivity.putExtra("KALORIT", Global.getInstance().getGames().get(i).getKalorit());
                startActivity(nextActivity);
            }
        });

    }
}