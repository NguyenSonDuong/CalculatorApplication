package com.example.calculatorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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
    ImageButton btnAC;
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
    TextView edtKetQua;
    EditText edtBieuThuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setOnclickButton();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
        btnAmDuong.setOnClickListener(this);
        btnAC.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                edtBieuThuc.setText("");
                edtKetQua.setText("");
                bieuThuc = new StringBuffer();
                return false;
            }
        });
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
        btnAC = (ImageButton) findViewById(R.id.btnAC);
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

        edtKetQua = (TextView) findViewById(R.id.edtKetQua);
        edtBieuThuc = (EditText) findViewById(R.id.edtBieuThuc);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn0:
                setTextForAll(v.getId());
                break;
            case R.id.btn1:
                setTextForAll(v.getId());
                break;
            case R.id.btn2:
                setTextForAll(v.getId());
                break;
            case R.id.btn3:
                setTextForAll(v.getId());
                break;
            case R.id.btn4:
                setTextForAll(v.getId());
                break;
            case R.id.btn5:
                setTextForAll(v.getId());
                break;
            case R.id.btn6:
                setTextForAll(v.getId());
                break;
            case R.id.btn7:
                setTextForAll(v.getId());
                break;
            case R.id.btn8:
                setTextForAll(v.getId());
                break;
            case R.id.btn9:
                setTextForAll(v.getId());
                break;
            case R.id.btnAC:
                if(edtBieuThuc.getText().toString().isEmpty())
                    return;
                String text = edtBieuThuc.getText().toString();
                int start = edtBieuThuc.getSelectionStart();
                int end = edtBieuThuc.getSelectionEnd();
                if(start == end)
                {
                    edtBieuThuc.setText(text.substring(0,text.length()-1));
                    edtBieuThuc.setSelection(edtBieuThuc.getText().toString().length());
                    bieuThuc.deleteCharAt(bieuThuc.length()-1);
                }else {
                    edtBieuThuc.setText(text.replace(text.substring(start,end),""));
                    edtBieuThuc.setSelection(edtBieuThuc.getText().toString().length());
                    bieuThuc.delete(start,end);
                }

                break;
            case R.id.btnCong:
                setTextForAll(v.getId());
                break;
            case R.id.btnTru:
                setTextForAll(v.getId());
                break;
            case R.id.btnNhan:
                setTextForAll(v.getId());
                break;
            case R.id.btnChia:
                setTextForAll(v.getId());
                break;
            case R.id.btnAmDuong:
                setTextForAmDuong(v.getId());
                break;
            case R.id.btnPhay:
                setTextForAll(v.getId());
                break;
            case R.id.btnDongNgoac:
                setTextForAll(v.getId());
                break;
            case R.id.btnMoNgoac:
                setTextForAll(v.getId());
                break;
            case R.id.btnBang:
                setTextForBang(v.getId());
                break;
            case R.id.btnPhanTram:
                break;

        }
    }
    public void setTextForBang(int id){
        double kq = 0;
        try{
            kq = XuLy.calculator(bieuThuc.toString());
        }catch (Exception ex){
            Toast.makeText(getApplicationContext(), ex.getMessage(),Toast.LENGTH_SHORT).show();
        }

        if(kq%1==0)
            edtKetQua.setText(""+(long)kq);
        else
            edtKetQua.setText(""+kq);
    }
    public void setTextForAll(int id){
        Button btn = (Button) findViewById(id);
        edtBieuThuc.append(btn.getText().toString());
        if(id == R.id.btnTru)
            bieuThuc.append("$");
        else
            bieuThuc.append(btn.getText().toString());
    }
    public void setTextForAmDuong(int id){
        edtBieuThuc.append("-");
        bieuThuc.append("-");
    }
}
