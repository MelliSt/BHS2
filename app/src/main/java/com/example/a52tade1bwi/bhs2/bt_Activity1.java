package com.example.a52tade1bwi.bhs2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by 52tade1bwi on 10.04.2018.
 */

public class bt_Activity1 extends MainActivity {
public Button L1btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bt_layout1);

        L1btn1 = (Button) findViewById(R.id.L1btn1);
        L1btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

    }

    public void openActivity2() {
        Intent intent = new Intent(this, bt_Activity2.class);
        startActivity(intent);
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

    }








