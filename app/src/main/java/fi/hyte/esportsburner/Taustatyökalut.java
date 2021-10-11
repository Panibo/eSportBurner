package fi.hyte.esportsburner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Taustatyökalut extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "MUISTA PELATA!", Toast.LENGTH_SHORT).show();

    }
}
