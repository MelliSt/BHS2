package com.example.a52tade1bwi.bhs2;

import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.goodiebag.pinview.Pinview;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private BluetoothAdapter BTAdapter = null;
    private AlertDialog.Builder alertDialogBuilder = null;
    private UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private static final String LOG_TAG = "BluetoothApp";
    private static String mac_adresse = "00:06:66:08:17:C6";
    private Button L1btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bt_layout1);
        BTAdapter = BluetoothAdapter.getDefaultAdapter();

    }

    public void bt_activity1(View view) {
        int ce = view.getId();


        if (ce == R.id.L1btn1) {
            BTAdapter = BluetoothAdapter.getDefaultAdapter();
            if (BTAdapter == null || !BTAdapter.isEnabled()) {

                new AlertDialog.Builder(this)
                        .setTitle("Not compatible")
                        .setMessage("Your phone does not support Bluetooth")
                        .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                System.exit(0);
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

            } else {
                Intent inten = new Intent(MainActivity.this, bt_Activity2.class);
                startActivity(inten);
            }

        }


    }

}