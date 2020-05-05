package com.salimuddin.guessinggamedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText ValueId;
    private Button BtnId;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ValueId = findViewById(R.id.guessId);
        BtnId = findViewById(R.id.btnId);
        result = findViewById(R.id.result);

        BtnId.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String Number = ValueId.getText().toString();

        int GivenNumber = Integer.parseInt(Number);

        if (GivenNumber>10){
            error();
        }

        //Random number Generate
        Random random = new Random();
        int randomNumber = random.nextInt(10)+1;


        if (Number.equals(" ")){

            error();

        }
        else {

            if (randomNumber == GivenNumber){
                result.setText("Congratulation! You Won");
            }
            else {
                result.setText("Sorry! You Lost. Generated Number is: "+randomNumber);
            }

        }

    }

    public void error(){
        result.setText("Pleaser Enter an valid Input");
        result.requestFocus();
        return;
    }
}
