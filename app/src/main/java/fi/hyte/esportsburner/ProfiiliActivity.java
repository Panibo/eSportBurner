package fi.hyte.esportsburner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ProfiiliActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiili);

        Button tallennaButton = findViewById(R.id.button_tallenna);
        tallennaButton.setOnClickListener(view -> tallenna());
    }

    private void tallenna(){
        EditText editText = findViewById(R.id.editPaino);
        if(editText.getText().toString().matches("")){
            return;
        }
        SharedPreferences prefPut = getSharedPreferences("PROFIILI", Activity.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefPut.edit();
        prefEditor.putInt("PAINO", Integer.parseInt(String.valueOf(editText.getText())));
        prefEditor.commit();
        editText.setText("");
    }
}