package com.example.a52tade1bwi.bhs2;

import android.app.Activity;
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

import com.goodiebag.pinview.Pinview;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/**
 * Created by 52tade1bwi on 10.04.2018.
 */

public class bt_Activity4 extends Activity   implements View.OnClickListener{

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
        setContentView(R.layout.bt_layout4);

        L4btn1 = (Button) findViewById(R.id.L4btn1);
        L4btn1.setOnClickListener(this);

        pw_id = (EditText) findViewById(R.id.pw_id);

    }


    @Override
    public void onClick(View view) {
        int ce = view.getId();

        if(ce == R.id.L4btn1){


            if(pw_id.getText().toString().equals(pw)){

                pw_richtig = true;
                senden(view);

               empfangen(view);



            }
            else{
                Toast.makeText(this, "Passwort falsch" ,
                        Toast.LENGTH_LONG).show();
                recreate();
            }




        }




    }
    public void senden(View view) {
        String message = "pwok";
        byte[] msgBuffer = message.getBytes();
        if (is_connected) {
            Log.d(LOG_TAG, "Sende Nachricht: " + message);
            try {
                stream_out.write(msgBuffer);
            } catch (IOException e) {
                Log.e(LOG_TAG,
                        "Bluetest: Exception beim Senden: " + e.toString());
            }
        }
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

                if(msg.toString().equals("FP_aktiv")){
                    Intent inten = new Intent(bt_Activity4.this, bt_Activity5.class);
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





