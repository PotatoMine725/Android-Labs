package com.example.bai4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    Button btnBack, btnSignup2;
    EditText edtUsername, edtPassword, edtPassword2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnBack = findViewById(R.id.btnBack);
        btnSignup2 = findViewById(R.id.btnSignup2);

        edtUsername = findViewById(R.id.editTextText);            // Username
        edtPassword = findViewById(R.id.txtPassword2);            // Password
        edtPassword2 = findViewById(R.id.editTextTextPassword2);  // Re-enter Password

        // Nút Back: chỉ quay về MainActivity, không gửi dữ liệu
        btnBack.setOnClickListener(v -> {
            setResult(RESULT_CANCELED); // không trả dữ liệu
            finish();
        });

        // Nút Create: kiểm tra và gửi dữ liệu về MainActivity
        btnSignup2.setOnClickListener(v -> {
            String username = edtUsername.getText().toString().trim();
            String password = edtPassword.getText().toString().trim();
            String password2 = edtPassword2.getText().toString().trim();

            if (username.isEmpty()) {
                edtUsername.setError("Vui lòng nhập Username");
                return;
            }
            if (password.isEmpty()) {
                edtPassword.setError("Vui lòng nhập Password");
                return;
            }
            if (!password.equals(password2)) {
                Toast.makeText(SignupActivity.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                return;
            }

            // Tạo intent chứa dữ liệu trả về
            Intent resultIntent = new Intent();
            resultIntent.putExtra("KEY_USERNAME", username);
            resultIntent.putExtra("KEY_PASSWORD", password);

            setResult(RESULT_OK, resultIntent); // trả dữ liệu về MainActivity
            finish(); // đóng SignupActivity
        });
    }
}