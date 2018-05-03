package com.example.a52tade1bwi.bhs2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.goodiebag.pinview.Pinview;

/**
 * Created by 52tade1bwi on 10.04.2018.
 */

public class bt_Activity4 extends Activity implements View.OnClickListener{

    public Button L4btn1;
    private String pw = "1234";
    public EditText pw_id;
    public boolean pw_richtig = false;



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
                Intent inten = new Intent(bt_Activity4.this, bt_Activity5.class);
                startActivity(inten);
            }
            else{
                Toast.makeText(this, "Passwort falsch" ,
                        Toast.LENGTH_LONG).show();
                recreate();
            }

        }

    }}





