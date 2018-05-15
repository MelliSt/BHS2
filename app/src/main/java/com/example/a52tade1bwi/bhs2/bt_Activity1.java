package com.example.a52tade1bwi.bhs2;
import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.UUID;
import android.util.Log;
/**
 * Created by 52tade1bwi on 10.04.2018.
 */

public class bt_Activity1 extends Activity implements View.OnClickListener{
    public Button L1btn1;
    private BluetoothAdapter BTAdapter = null;
    private AlertDialog.Builder alertDialogBuilder = null;
    private UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private static final String LOG_TAG = "BluetoothApp";
    private static String mac_adresse = "00:06:66:08:17:C6";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bt_layout1);

     //   Log.d(LOG_TAG, "Bluetest: OnCreate");


        L1btn1 = (Button) findViewById(R.id.L1btn1);
        L1btn1.setOnClickListener(this);




        BTAdapter = BluetoothAdapter.getDefaultAdapter();
        // Phone does not support Bluetooth so let the user know and exit.

    }

    @Override
    public void onClick(View view) {


        int ce = view.getId();



        if(ce == R.id.L1btn1){
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

            }
                else{
                    Intent inten = new Intent(bt_Activity1.this, bt_Activity2.class);
            startActivity(inten);}

        }

    }



        }




















  //  public void yourMethodName(View v){
    //    startActivity(new Intent(bt_Activity1.this, bt_Activity2.class));
    //}

//private void button(){
  //  L1btn1 = (Button)findViewById(R.id.L1btn1);
//}
   // public void geraetSuche(View view){
     //   startActivity(new Intent(bt_Activity1.this, bt_Activity2.class));
//

//public void buttonKlick(){
  //  L1btn1.setOnClickListener(new View.OnClickListener() {


    //  @Override
      //  public void onClick(View view) {
        //    onClick(L1btn1);
       // }
   //});










