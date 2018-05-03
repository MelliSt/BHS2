package com.example.a52tade1bwi.bhs2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Created by 52tade1bwi on 10.04.2018.
 */

public class bt_Activity2 extends Activity implements View.OnClickListener{
    public Button L2btn1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bt_layout2);

        L2btn1 = (Button) findViewById(R.id.L2btn1);
        L2btn1.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        int ce = view.getId();

        if(ce == R.id.L2btn1){
            Intent inten = new Intent(bt_Activity2.this, bt_Activity3.class);
            startActivity(inten);
        }



    }}