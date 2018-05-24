package com.example.a52tade1bwi.bhs2;

import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/**
 * Created by 52tade1bwi on 10.04.2018.
 */

public class bt_Activity6 extends MainActivity{
    public Button L4btn1;
    private String pw = "1234";
    public EditText pw_id;
    public boolean pw_richtig = false;
    public Button L3btn1oeffnen;
    public Button L2btn1;
    private BluetoothSocket socket = null;
    private BluetoothAdapter BTAdapter = null;
    private boolean is_connected = false;
    private OutputStream stream_out = null;
    private InputStream stream_in = null;
    private AlertDialog.Builder alertDialogBuilder = null;
    private UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private static final String LOG_TAG = "BluetoothApp";
    private static String mac_adresse = "00:06:66:08:17:C6";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bt_layout6);



    }

    public void empfangen(View view) {
        byte[] buffer = new byte[1024]; // Puffer
        int laenge; // Anzahl empf. Bytes
        String msg = "";
        try {
            if (stream_in.available() > 0) {
                laenge = stream_in.read(buffer);
                Log.d(LOG_TAG,
                        "Anzahl empfangender Bytes: " + String.valueOf(laenge));

                // Message zusammensetzen:
                for (int i = 0; i < laenge; i++)
                    msg += (char) buffer[i];

                Log.d(LOG_TAG, "Message: " + msg);
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

                if(msg.toString().equals("Tuer_geschlossen")){
                    Intent inten = new Intent(bt_Activity6.this, bt_Activity1.class);
                    startActivity(inten);
                }

            } else
                Toast.makeText(this, "Nichts empfangen", Toast.LENGTH_LONG)
                        .show();
        } catch (Exception e) {
            Log.e(LOG_TAG, "Fehler beim Empfangen: " + e.toString());




        }
    }


}
