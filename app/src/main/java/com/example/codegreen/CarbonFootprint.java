package com.example.codegreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CarbonFootprint extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.codegreen.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*Called when user taps calculate button*/
//    public void calculate(View view){
//        Intent intent = new Intent(this,Calculate.class);
//
//        EditText editText = (EditText) findViewById(R.id.editText);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
//    }

}
