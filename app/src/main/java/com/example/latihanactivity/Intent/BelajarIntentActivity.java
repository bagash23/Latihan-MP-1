package com.example.latihanactivity.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.latihanactivity.R;
import com.example.latihanactivity.utils.Person;

public class BelajarIntentActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonData;
    private Button buttonMove;
    private Button btnMoveWithObject;
    private Button btnDialPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belajar_intent);
        buttonMove = findViewById(R.id.btn_move_activity);
        buttonData = findViewById(R.id.btn_move_activity_data);
        buttonData.setOnClickListener(this);
        buttonMove.setOnClickListener(this);
        btnMoveWithObject = findViewById(R.id.btn_move_activity_object);
        btnMoveWithObject.setOnClickListener(this);
        btnDialPhone = findViewById(R.id.btn_dial_number);
        btnDialPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(BelajarIntentActivity.this, MoveActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_move_activity_data:
                Intent moveWithDataIntent = new Intent(BelajarIntentActivity.this,MoveDataActivity.class);
                moveWithDataIntent.putExtra(MoveDataActivity.EXTRA_NAME, "Bina Sarana Informatika");
                moveWithDataIntent.putExtra(MoveDataActivity.EXTRA_AGE,32);
                startActivity(moveWithDataIntent);
                break;
            case R.id.btn_move_activity_object:
                Person mPerson = new Person();
                mPerson.setName("Bina Sarana Informatika");
                mPerson.setAge(32);
                mPerson.setEmail("ubsi@bsi.ac.id");
                mPerson.setCity("DKI Jakarta");
                Intent moveWithObjectIntent = new Intent(BelajarIntentActivity.this,MoveWithObjectActivity.class);
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON,mPerson);
                startActivity(moveWithObjectIntent);
                break;
            case  R.id.btn_dial_number:
                String phoneNumber = "08123456789";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhoneIntent);
                break;
        }
    }
}