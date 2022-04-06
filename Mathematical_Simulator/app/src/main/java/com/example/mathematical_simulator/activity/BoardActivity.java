package com.example.mathematical_simulator.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathematical_simulator.R;
import com.example.mathematical_simulator.mathematicaloperations.DataToGenerate;
import com.example.mathematical_simulator.mathematicaloperations.GenerationOfNumbers;

public class BoardActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView textExample, textCorrectResult, textCountMoney;
    private EditText editTextResult;
    private Button btnCheck, btnNextExample;
    private ImageButton btnHint, btnSetting;
    private GenerationOfNumbers mathOperations;
    private DataToGenerate dataToGenerate;

    private int result;
    private static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        initialization();
        readyExample();
    }

    private void initialization() {

        textExample = findViewById(R.id.textExample);
        textCorrectResult = findViewById(R.id.textCorrectResult);
        editTextResult = findViewById(R.id.editTextResult);
        btnCheck = findViewById(R.id.btnCheck);
        btnHint = findViewById(R.id.btnHint);
        btnNextExample = findViewById(R.id.btnNextExample);
        btnSetting = findViewById(R.id.btnSetting);
        textCountMoney = findViewById(R.id.textCountMoney);

        mathOperations = new GenerationOfNumbers();
        dataToGenerate = new DataToGenerate();

        btnCheck.setOnClickListener(this);
        btnHint.setOnClickListener(this);
        btnNextExample.setOnClickListener(this);
        btnSetting.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnCheck:
                if(editTextResult.getText().length() == 0)
                    Toast.makeText(getApplicationContext(), "Поле відповіді пусте!", Toast.LENGTH_LONG).show();
                try {
                    int number = Integer.parseInt(String.valueOf(editTextResult.getText()));
                    if (result == number) {
                        count++;
                        updateData();
                        textCountMoney.setText(String.valueOf(count));
                        readyExample();
                    } else {
                        editTextResult.setTextColor(Color.RED);
                    }
                }catch (RuntimeException e){
                    e.printStackTrace();
                }
                break;
            case R.id.btnHint:
                textCorrectResult.setText("Підсказка: "+result+"\t");
                break;
            case R.id.btnNextExample:
                updateData();
                readyExample();
                break;
            case R.id.btnSetting:
                count = 0;
                Intent intent = new Intent(this, MenuSettingActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    //Method that determines which settings are given
    @SuppressLint("SetTextI18n")
    private void readyExample() {
        //Getting data from class MenuSettingActivity
        int actionsIdentifier = getIntent().getIntExtra("actionsId", 0);
        int numberIdentifier = getIntent().getIntExtra("numberId", 0);

        //mathOperations.setActionsId(actionsIdentifier);
        dataToGenerate.setActionsId(actionsIdentifier);

        int a = dataToGenerate.getA();
        int b = dataToGenerate.getB();

        switch (numberIdentifier) {

            case 1:
                mathOperations.creatingExampleForPositionsNum1();
                break;
            case 2:
                mathOperations.creatingExampleForPositionsNum2();
                break;
            case 3:
                mathOperations.creatingExampleForPositionsNum3();
                break;
            case 4:
                mathOperations.creatingExampleForPositionsNum4();
                break;
        }

        switch (actionsIdentifier) {
            case 1:
                textExample.setText(mathOperations.getA() +" + "+ mathOperations.getB() +" = ");
                result = a + b;
                break;
            case 2:
                textExample.setText(mathOperations.getA() +" - "+ mathOperations.getB() +" = ");
                result = a - b;
                break;
            case 3:
                textExample.setText(mathOperations.getA() +" * "+ mathOperations.getB() +" = ");
                result = a * b;
                break;
            case 4:
                textExample.setText(mathOperations.getA() +" / "+ mathOperations.getB() +" = ");
                try {
                    result = a / b;
                }catch (ArithmeticException e){
                    e.printStackTrace();
                }
                break;
        }
    }

    //Method which update data in app
    private void updateData(){
        editTextResult.setTextColor(Color.WHITE);
        textCorrectResult.setText(null);
        editTextResult.setText(null);
    }

    @Override
    public void onBackPressed() {
    }
}