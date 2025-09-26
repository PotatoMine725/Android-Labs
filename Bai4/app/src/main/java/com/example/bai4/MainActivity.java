package com.example.bai4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnLogin, btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);

        // Nút Login: tạm thời chỉ hiện popup (vì không có màn hình Secondary)
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Có thể thay bằng Toast hoặc AlertDialog
                android.widget.Toast.makeText(MainActivity.this,
                        "Đăng nhập thành công (demo)",
                        android.widget.Toast.LENGTH_SHORT).show();
            }
        });

        // Nút Sign up: mở màn hình đăng ký
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}