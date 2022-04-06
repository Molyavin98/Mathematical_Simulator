package com.example.mathematical_simulator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.mathematical_simulator.activity.MenuSettingActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnStart;
    private TextView textMath, textMathExample;
    Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();
    }

    private void initialization(){
        btnStart = findViewById(R.id.btnStart);
        textMath = findViewById(R.id.textMath);
        textMathExample = findViewById(R.id.textMathExample);
        anim = AnimationUtils.loadAnimation(this, R.anim.anim);

        btnStart.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnStart.startAnimation(anim);
        textMath.startAnimation(anim);
        textMathExample.startAnimation(anim);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnStart:
                Intent intent = new Intent(getApplication(), MenuSettingActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}