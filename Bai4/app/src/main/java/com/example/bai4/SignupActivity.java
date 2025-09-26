package com.example.bai4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    Button btnBack, btnSignup2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnBack = findViewById(R.id.btnBack);
        btnSignup2 = findViewById(R.id.btnSignup2);

        // Nút Back: quay về MainActivity
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // đóng SignupActivity
            }
        });

        // Nút Create: hiện popup thông báo
        btnSignup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignupActivity.this,
                        "Tài khoản đã được tạo thành công (demo)",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}