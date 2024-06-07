package com.hope0163.register;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Welcome extends AppCompatActivity {

    TextView txtWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

//        String email = getIntent().getStringExtra("email");

        // 앱 내 저장소에 저장된 데이터를 가져온다.
        SharedPreferences sp = getSharedPreferences("avata_app", MODE_PRIVATE);
        String email = sp.getString("email", "");

        txtWelcome = findViewById(R.id.txtWelcome);

        txtWelcome.setText(email + " 님\n" + "회원가입을 축하합니다.");

    }
}