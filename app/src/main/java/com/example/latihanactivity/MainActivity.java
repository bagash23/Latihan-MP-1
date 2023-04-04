package com.example.latihanactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.latihanactivity.Intent.BelajarIntentActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtWidth, edtHeight, edtLenght;
    private Button btnCalculate;
    private Button btnNext;
    private TextView tvResult;
    private static final String STATE_HASIL = "state_hasil";
    private Button btnIntent;

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString(STATE_HASIL, tvResult.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtWidth=(EditText)findViewById(R.id.edit_width);
        edtHeight=(EditText)findViewById(R.id.edit_height);
        btnNext=(Button)findViewById(R.id.btn_next);
        edtLenght=(EditText)findViewById(R.id.edit_lenght);
        btnCalculate=(Button)findViewById(R.id.btn_calculate);
        tvResult=(TextView)findViewById(R.id.tv_result);
        btnIntent = findViewById(R.id.btn_latihan_intent);

        btnIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move = new Intent(MainActivity.this, BelajarIntentActivity.class);
                startActivity(move);
            }
        });

        btnCalculate.setOnClickListener(this);
        if (savedInstanceState !=null) {
            String hasil = savedInstanceState.getString(STATE_HASIL);
            tvResult.setText(hasil);
        }

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PindahWebActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn_calculate){
            String lenght = edtLenght.getText().toString().trim();
            String width = edtWidth.getText().toString().trim();
            String height = edtHeight.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(lenght)){
                isEmptyFields=true;
                edtWidth.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(width)){
                isEmptyFields=true;
                edtWidth.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(height)){
                isEmptyFields = true;
                edtHeight.setError("Field ini tidak boleh kosong");
            }
            if(!isEmptyFields){
                double l = Double.parseDouble(lenght);
                double w = Double.parseDouble(width);
                double h = Double.parseDouble(height);
                double volume = l*w*h;
                tvResult.setText(String.valueOf(volume));
            }
        }
    }
}