package com.example.calculatorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    StringBuffer bieuThuc = new StringBuffer();

    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnAC;
    Button btnCong;
    Button btnTru;
    Button btnNhan;
    Button btnChia;
    Button btnAmDuong;
    Button btnPhay;
    Button btnDongNgoac;
    Button btnMoNgoac;
    Button btnBang;
    Button btnPhanTram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setOnclickButton();
    }

    private void setOnclickButton() {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        btnAC.setOnClickListener(this);
        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);
        btnPhay.setOnClickListener(this);
        btnDongNgoac.setOnClickListener(this);
        btnMoNgoac.setOnClickListener(this);
        btnBang.setOnClickListener(this);
        btnPhanTram.setOnClickListener(this);
    }

    private void init() {
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnAC = (Button) findViewById(R.id.btnAC);
        btnCong = (Button) findViewById(R.id.btnCong);
        btnTru = (Button) findViewById(R.id.btnTru);
        btnNhan = (Button) findViewById(R.id.btnNhan);
        btnChia = (Button) findViewById(R.id.btnChia);
        btnAmDuong = (Button) findViewById(R.id.btnAmDuong);
        btnPhay = (Button) findViewById(R.id.btnPhay);
        btnDongNgoac = (Button) findViewById(R.id.btnDongNgoac);
        btnMoNgoac = (Button) findViewById(R.id.btnMoNgoac);
        btnBang = (Button) findViewById(R.id.btnBang);
        btnPhanTram = (Button) findViewById(R.id.btnPhanTram);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn0:
                break;
            case R.id.btn1:
                break;
            case R.id.btn2:
                break;
            case R.id.btn3:
                break;
            case R.id.btn4:
                break;
            case R.id.btn5:
                break;
            case R.id.btn6:
                break;
            case R.id.btn7:
                break;
            case R.id.btn8:
                break;
            case R.id.btn9:
                break;
            case R.id.btnAC:
                break;
            case R.id.btnCong:
                break;
            case R.id.btnTru:
                break;
            case R.id.btnNhan:
                break;
            case R.id.btnChia:
                break;
            case R.id.btnAmDuong:
                break;
            case R.id.btnPhay:
                break;
            case R.id.btnDongNgoac:
                break;
            case R.id.btnMoNgoac:
                break;
            case R.id.btnBang:
                break;
            case R.id.btnPhanTram:
                break;

        }
    }
}
