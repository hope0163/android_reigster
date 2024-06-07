package com.hope0163.register;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AvataActivity extends AppCompatActivity {

    ImageView imgAvata;
    Button btnRabbit;
    Button btnTurtle;
    Button btnFinish;
    String email;

    // 유저가 아바타를 선택하면, 선택한 아바타가 무엇인지 저장하는 용도
    // 0 : 아무것도 선택 안한것 / 1 : 토끼 / 2 : 거북이
    int imageType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avata);

        imgAvata = findViewById(R.id.imgAvata);
        btnRabbit = findViewById(R.id.btnRabbit);
        btnTurtle = findViewById(R.id.btnTurtle);
        btnFinish = findViewById(R.id.btnFinish);

//        email = getIntent().getStringExtra("email");

        btnRabbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgAvata.setImageResource(R.drawable.rabbit);
                imageType = 1;
            }
        });


        btnTurtle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgAvata.setImageResource(R.drawable.turtle);
                imageType = 2;
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageType == 0) {
                    Toast.makeText(AvataActivity.this, "아바타를 선택하세요.", Toast.LENGTH_SHORT).show();
                }

                // Alert 다이얼로그를 띄운다.
                showAlertDialog();

            }
        });



    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(AvataActivity.this);
        builder.setCancelable(true);
        builder.setTitle("회원가입 완료");
        builder.setMessage("완료하시겠습니까?");
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(AvataActivity.this, Welcome.class);
//                intent.putExtra("email", email);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("아니오", null);
        builder.show();

    }
}