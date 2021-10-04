package fi.hyte.esportsburner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    }
}