package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity2 extends AppCompatActivity {
    private EditText set_drink;
    private RadioGroup rg1,rg2;
    private Button btn_send;
    private String suger = "無糖";
    private String ice_opt = "去冰";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rg1 = findViewById(R.id.rGroup);
        rg1.setOnCheckedChangeListener((rGroup,i)->{
            if (i == R.id.rButton1){
                suger = "無糖";
            }else if(i == R.id.rButton2){
                suger = "少糖";
            }else if(i == R.id.rButton3){
                suger = "半糖";
            } else if (i == R.id.rButton4) {
                suger = "全糖";
            }
        });

        rg2 = findViewById(R.id.rGroup2);
        rg2.setOnCheckedChangeListener((rGroup,i)->{
            if (i == R.id.rButton5){
                suger = "去冰";
            }else if(i == R.id.rButton6){
                suger = "微冰";
            }else if(i == R.id.rButton7){
                suger = "少冰";
            } else if (i == R.id.rButton8) {
                suger = "全冰";
            }
        });

        btn_send = findViewById(R.id.btn_send);
        btn_send.setOnClickListener(view -> {
            set_drink = findViewById(R.id.ed_drink);
            String drink = set_drink.getText().toString();
            Intent i = new Intent();
            Bundle b = new Bundle();
            b.putString("drink",drink);
            b.putString("suger",suger);
            b.putString("ice",ice_opt);
            i.putExtras(b);
            setResult(Activity.RESULT_OK,i);
            finish();
        });
    }
}