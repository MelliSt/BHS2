package com.example.a52tade1bwi.bhs2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.goodiebag.pinview.Pinview;

public class MainActivity extends AppCompatActivity {

    private Button L1btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bt_layout1);

    }

    public void bt_activity1(View view){
        Intent intent = new Intent(this, bt_Activity2.class);
        startActivity(intent);


    }








}