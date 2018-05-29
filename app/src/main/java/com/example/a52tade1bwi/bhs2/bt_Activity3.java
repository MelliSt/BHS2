package com.example.a52tade1bwi.bhs2;

import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/**
 * Created by 52tade1bwi on 10.04.2018.
 */

public class bt_Activity3 extends Activity implements View.OnClickListener {

    public Button L3btn1oeffnen;
    public Button L2btn1;
    private BluetoothSocket socket = null;
    private BluetoothAdapter BTAdapter = null;
    BluetoothDevice remote_device = null;
    public boolean is_connected = false;
    private OutputStream stream_out = null;
    private InputStream stream_in = null;
    private AlertDialog.Builder alertDialogBuilder = null;
    //    private UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private static final String LOG_TAG = "BluetoothApp";
    private UUID uuid = UUID.fromString("80DDBE66-26F2-6642-986D-050F8FFCB7CA");
    //    private static String mac_adresse = "00:06:66:08:17:C6";
    private static String mac_adresse = "80:A5:89:31:24:42";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bt_layout3);


        L3btn1oeffnen = (Button) findViewById(R.id.L3btn1oeffnen);
        L3btn1oeffnen.setOnClickListener(this);

        BTAdapter = BluetoothAdapter.getDefaultAdapter();
        try {
            remote_device = BTAdapter.getRemoteDevice(mac_adresse);
            Log.d(LOG_TAG, "Remote device geholt");
        } catch (Exception e) {
            Log.e(LOG_TAG, "Remote device nicht geholt" + e.toString());
        }


        // Socket erstellen
        try {
            socket = remote_device
                    .createInsecureRfcommSocketToServiceRecord(uuid);
            Log.d(LOG_TAG, "Socket erstellt");
        } catch (Exception e) {
            Log.e(LOG_TAG, "Socket Erstellung fehlgeschlagen: " + e.toString());
        }


        try {
            BTAdapter.cancelDiscovery();
            Log.d(LOG_TAG, "Discovery canceled");
        } catch (Exception e) {
            Log.e(LOG_TAG, "Discovery nicht gecanceled" + e.toString());
        }


        // Socket verbinden
        try {
            socket.connect();
            Log.d(LOG_TAG, "Socket verbunden");
            is_connected = true;
        } catch (IOException e) {
            is_connected = false;
            Log.e(LOG_TAG, "Socket kann nicht verbinden: " + e.toString());
        }

        // Socket beenden, falls nicht verbunden werden konnte
        if (!is_connected) {
            try {
                socket.close();
            } catch (Exception e) {
                Log.e(LOG_TAG,
                        "Socket kann nicht beendet werden: " + e.toString());
            }
        }


        // Outputstream erstellen:
        try

        {
            stream_out = socket.getOutputStream();
            Log.d(LOG_TAG, "OutputStream erstellt");
        } catch (
                IOException e)

        {
            Log.e(LOG_TAG, "OutputStream Fehler: " + e.toString());
            is_connected = false;
        }

        // Inputstream erstellen
        try

        {
            stream_in = socket.getInputStream();
            Log.d(LOG_TAG, "InputStream erstellt");
        } catch (
                IOException e)

        {
            Log.e(LOG_TAG, "InputStream Fehler: " + e.toString());
            is_connected = false;
        }

        if (is_connected)

        {
            Toast.makeText(this, "Verbunden mit " + mac_adresse,
                    Toast.LENGTH_LONG).show();
            ((TextView) findViewById(R.id.L3txt2gruen)).setVisibility(View.VISIBLE);
            ((TextView) findViewById(R.id.L3txt3rot)).setVisibility(View.INVISIBLE);
        } else

        {
            Toast.makeText(this, "Verbindungsfehler, gehen Sie zurück",
                    Toast.LENGTH_LONG).show();
            ((TextView) findViewById(R.id.L3txt2gruen)).setVisibility(View.INVISIBLE);
            ((TextView) findViewById(R.id.L3txt3rot)).setVisibility(View.VISIBLE);
            ((Button) findViewById(R.id.L3btn1oeffnen)).setVisibility(View.INVISIBLE);

        }


    }

    @Override
    public void onClick(View view) {
        int ce = view.getId();

        if (ce == R.id.L3btn1oeffnen) {
            Intent inten = new Intent(bt_Activity3.this, bt_Activity4.class);
            startActivity(inten);
        }

    }
}
