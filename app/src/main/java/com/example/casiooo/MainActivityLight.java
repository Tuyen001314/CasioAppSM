package com.example.casiooo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivityLight extends Activity implements View.OnClickListener {
    private TextView textResult;
    private EditText textEnter;
    private Button btnclose, btn7 , btn1, btn2, btn3, btn4, btn5, btn6, btn8, btn9, btn0, btnAC, btndot, btnequal, btnnhan, btnopen, btnDel, btndiv;
    private ImageButton btnplus, btntru;
    private float result = 0;
    private Brain brain;
    String s;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_light);

        textEnter = findViewById(R.id.textEnter);
        textResult = findViewById(R.id.textResult);
        btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        btn1 = findViewById(R.id.button1);
        btn1.setOnClickListener(this);
        btn0 = findViewById(R.id.buttonzero);
        btn0.setOnClickListener(this);
        btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(this);
        btn4 = findViewById(R.id.button4);
        btn4.setOnClickListener(this);
        btn5 = findViewById(R.id.button5);
        btn5.setOnClickListener(this);
        btn6 = findViewById(R.id.button6);
        btn6.setOnClickListener(this);
        btn8 = findViewById(R.id.button8);
        btn8.setOnClickListener(this);
        btn9 = findViewById(R.id.button9);
        btn9.setOnClickListener(this);
        btnAC = findViewById(R.id.buttonAC);
        btnAC.setOnClickListener(this);
        btndot = findViewById(R.id.buttondot);
        btndot.setOnClickListener(this);
        btnplus = findViewById(R.id.buttonplus);
        btnplus.setOnClickListener(this);
        btndiv = findViewById(R.id.buttondiv);
        btndiv.setOnClickListener(this);
        btnnhan = findViewById(R.id.buttonx);
        btnnhan.setOnClickListener(this);
        btntru = findViewById(R.id.buttonsub);
        btntru.setOnClickListener(this);
        btnequal = findViewById(R.id.buttonequal);
        btnequal.setOnClickListener(this);
        btnopen = findViewById(R.id.buttonOpen);
        btnopen.setOnClickListener(this);
        btnDel = findViewById(R.id.buttonDel);
        btnDel.setOnClickListener(this);
        btnclose = findViewById(R.id.buttonClose);
        btnclose.setOnClickListener(this);
        brain = new Brain();

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        if(v == btn7) textEnter.setText(textEnter.getText() + "7");
        else if(v == btn0) textEnter.setText(textEnter.getText() + "0");
        else if(v == btn1) textEnter.setText(textEnter.getText() + "1");
        else if(v == btn2) textEnter.setText(textEnter.getText() + "2");
        else if(v == btn3) textEnter.setText(textEnter.getText() + "3");
        else if(v == btn4) textEnter.setText(textEnter.getText() + "4");
        else if(v == btn5) textEnter.setText(textEnter.getText() + "5");
        else if(v == btn6) textEnter.setText(textEnter.getText() + "6");
        else if(v == btn8) textEnter.setText(textEnter.getText() + "8");
        else if(v == btn9) textEnter.setText(textEnter.getText() + "9");
        else if(v == btnAC) {
            textEnter.setText("");
            textResult.setText("");
        }
        else if(v == btnplus) textEnter.setText(textEnter.getText() + "+");
        else if(v == btnclose) textEnter.setText(textEnter.getText() + ")");
        else if(v == btntru) textEnter.setText(textEnter.getText() + "-");
        else if(v == btnnhan) textEnter.setText(textEnter.getText() + "x");
        else if(v == btndiv) textEnter.setText(textEnter.getText() + "/");
        else if(v == btndot) textEnter.setText(textEnter.getText() + ".");
        else if(v == btnDel) {
            textEnter.setText(textEnter.getText().toString().replaceFirst(".$",""));
        }
        else if(v == btnopen) {
            textEnter.setText(textEnter.getText() + "(");
        }
        else if(v == btnequal) {
            s = textEnter.getText().toString();
            textResult.setText(String.valueOf(brain.Solve(s)));
            result = Float.parseFloat(String.valueOf(brain.Solve(s)));
            Log.d("KQ", " " + s + " = " + result);
        }

        textEnter.setSelection(textEnter.getText().length());
    }

    public void onClickButtonDark(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
