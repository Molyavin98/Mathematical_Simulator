package com.example.mathematical_simulator.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.example.mathematical_simulator.R;

public class MenuSettingActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnPlus, btnMinus, btnMultiplication, btnDivision, btnNum1, btnNum2, btnNum3, btnNum4, btnNext;
    private int actionsId;
    private int numberId;
    private Animation animation;
    private boolean isTestingActionsIdOnClick, isTestingNumberIdOnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_setting);

        initialization();
    }

    private void initialization() {
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiplication = findViewById(R.id.btnMultiplication);
        btnDivision = findViewById(R.id.btnDivision);
        btnNum1 = findViewById(R.id.btnNum1);
        btnNum2 = findViewById(R.id.btnNum2);
        btnNum3 = findViewById(R.id.btnNum3);
        btnNum4 = findViewById(R.id.btnNum4);
        btnNext = findViewById(R.id.btnNext);

        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiplication.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnNum1.setOnClickListener(this);
        btnNum2.setOnClickListener(this);
        btnNum3.setOnClickListener(this);
        btnNum4.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        animation = AnimationUtils.loadAnimation(this, R.anim.anim);
        btnNext.startAnimation(animation);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        Intent intent;

        switch (view.getId()) {

            //Layout Actions
            case R.id.btnPlus:
                btnPlus.setBackgroundColor(Color.WHITE);
                btnMinus.setBackgroundColor(Color.GRAY);
                btnMultiplication.setBackgroundColor(Color.GRAY);
                btnDivision.setBackgroundColor(Color.GRAY);
                actionsId = 1;
                break;
            case R.id.btnMinus:
                btnPlus.setBackgroundColor(Color.GRAY);
                btnMinus.setBackgroundColor(Color.WHITE);
                btnMultiplication.setBackgroundColor(Color.GRAY);
                btnDivision.setBackgroundColor(Color.GRAY);
                actionsId = 2;
                break;
            case R.id.btnMultiplication:
                btnPlus.setBackgroundColor(Color.GRAY);
                btnMinus.setBackgroundColor(Color.GRAY);
                btnMultiplication.setBackgroundColor(Color.WHITE);
                btnDivision.setBackgroundColor(Color.GRAY);
                actionsId = 3;
                break;
            case R.id.btnDivision:
                btnPlus.setBackgroundColor(Color.GRAY);
                btnMinus.setBackgroundColor(Color.GRAY);
                btnMultiplication.setBackgroundColor(Color.GRAY);
                btnDivision.setBackgroundColor(Color.WHITE);
                actionsId = 4;
                break;
            //Layout number
            case R.id.btnNum1:
                btnNum1.setBackgroundColor(Color.WHITE);
                btnNum2.setBackgroundColor(Color.GRAY);
                btnNum3.setBackgroundColor(Color.GRAY);
                btnNum4.setBackgroundColor(Color.GRAY);
                numberId = 1;
                break;
            case R.id.btnNum2:
                btnNum1.setBackgroundColor(Color.GRAY);
                btnNum2.setBackgroundColor(Color.WHITE);
                btnNum3.setBackgroundColor(Color.GRAY);
                btnNum4.setBackgroundColor(Color.GRAY);
                numberId = 2;
                break;
            case R.id.btnNum3:
                btnNum1.setBackgroundColor(Color.GRAY);
                btnNum2.setBackgroundColor(Color.GRAY);
                btnNum3.setBackgroundColor(Color.WHITE);
                btnNum4.setBackgroundColor(Color.GRAY);
                numberId = 3;
                break;
            case R.id.btnNum4:
                btnNum1.setBackgroundColor(Color.GRAY);
                btnNum2.setBackgroundColor(Color.GRAY);
                btnNum3.setBackgroundColor(Color.GRAY);
                btnNum4.setBackgroundColor(Color.WHITE);
                numberId = 4;
                break;
            //Button next;
            case R.id.btnNext:
                //Checking button on click;
                checkPressedButtons();
                if (isTestingActionsIdOnClick && isTestingNumberIdOnClick) {
                    intent = new Intent(this, BoardActivity.class);
                    intent.putExtra("actionsId", actionsId);
                    intent.putExtra("numberId", numberId);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Виберіть налаштування!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    //Method for checked pressed button
    private void checkPressedButtons() {
        isTestingActionsIdOnClick = actionsId == 1 || actionsId == 2 || actionsId == 3 || actionsId == 4;
        isTestingNumberIdOnClick = numberId == 1 || numberId == 2 || numberId == 3 || numberId == 4;
    }

    @Override
    public void onBackPressed() {
    }
}