package com.example.a52tade1bwi.bhs2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by 52tade1bwi on 10.04.2018.
 */

public class bt_Activity3 extends Activity implements View.OnClickListener{

    public Button L3btn1oeffnen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bt_layout3);

        L3btn1oeffnen = (Button) findViewById(R.id.L3btn1oeffnen);
        L3btn1oeffnen.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        int ce = view.getId();

        if(ce == R.id.L3btn1oeffnen){
            Intent inten = new Intent(bt_Activity3.this, bt_Activity4.class);
            startActivity(inten);
        }

    }}
