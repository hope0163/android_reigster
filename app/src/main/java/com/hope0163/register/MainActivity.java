package com.hope0163.register;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnRegister;
    EditText editEmail;
    EditText editPassword;
    EditText editCheckPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        editCheckPassword = findViewById(R.id.editCheckPassword);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = editEmail.getText().toString().trim();
                String password = editPassword.getText().toString().trim();
                String checkPassword = editCheckPassword.getText().toString().trim();

                // 필수 항목 체크
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.register_check, Toast.LENGTH_SHORT).show();
                    return;
                }

                // 이메일 형식이 맞는지 체크
                if (email.contains("@") == false) {
                    Toast.makeText(MainActivity.this, R.string.register_check2, Toast.LENGTH_SHORT).show();
                    return;
                }


                if (password.length() < 6 || password.length() > 12) {
                    Toast.makeText(MainActivity.this, "비밀번호는 6자리이상 12자리 이하로 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.equals(checkPassword) == false) {
                    Toast.makeText(MainActivity.this, "비밀번호를 일치하여 주십시오.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 이메일 주소를 앱 내 저장소에 저장하는 방법
                SharedPreferences sp = getSharedPreferences("avata_app", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("email", email);
                editor.commit();



                // 아바타 액티비티를 띄운다.
                Intent intent = new Intent(MainActivity.this, AvataActivity.class);
//                intent.putExtra("email", email);
                startActivity(intent);

//                다음 액티비티를 실행하고나서 현재 액티비티는 끝내주는게 좋다.
                finish();

            }
        });


    }
}