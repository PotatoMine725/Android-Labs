package com.example.bai4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnLogin, btnSignup;
    EditText txtUsername, txtPassword;

    // requestCode để phân biệt khi nhận kết quả
    private static final int REQUEST_SIGNUP = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);

        // Nút Login: tạm thời chỉ hiện popup
        btnLogin.setOnClickListener(v ->
                Toast.makeText(MainActivity.this,
                        "Đăng nhập thành công (demo)",
                        Toast.LENGTH_SHORT).show()
        );

        // Nút Sign up: mở màn hình đăng ký và chờ kết quả trả về
        btnSignup.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SignupActivity.class);
            startActivityForResult(intent, REQUEST_SIGNUP);
        });
    }

    // Nhận dữ liệu trả về từ SignupActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_SIGNUP && resultCode == RESULT_OK && data != null) {
            String username = data.getStringExtra("KEY_USERNAME");
            String password = data.getStringExtra("KEY_PASSWORD");

            if (username != null) {
                txtUsername.setText(username);
            }
            if (password != null) {
                txtPassword.setText(password);
            }
        }
    }
}