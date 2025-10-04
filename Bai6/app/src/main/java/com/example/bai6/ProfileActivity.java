package com.example.bai6;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    private ImageView imageView_111, imgSetting_111;
    private TextView txtUName_111, txtPass_111, txtPhone_111, txtEmail_111, textView5_111;
    private LinearLayout linInfo_111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile); // giữ nguyên vì file XML vẫn cùng tên

        // ánh xạ các view với id mới
        imageView_111 = findViewById(R.id.imageView_111);
        imgSetting_111 = findViewById(R.id.imgSetting_111);
        txtUName_111 = findViewById(R.id.txtUName_111);
        txtPass_111 = findViewById(R.id.txtPass_111);
        txtPhone_111 = findViewById(R.id.txtPhone_111);
        txtEmail_111 = findViewById(R.id.txtEmail_111);
        textView5_111 = findViewById(R.id.textView5_111);
        linInfo_111 = findViewById(R.id.linInfo_111);

        String username_111 = getIntent().getStringExtra("username");
        String password_111 = getIntent().getStringExtra("password");

        if (username_111 != null && password_111 != null) {
            txtUName_111.setText("Username: " + username_111);
            textView5_111.setText(username_111);
        } else {
            Toast.makeText(this, "Không tìm thấy thông tin đăng nhập", Toast.LENGTH_SHORT).show();
            finish();
        }

        if (password_111 != null) {
            txtPass_111.setText("Password: " + password_111);
        } else {
            txtPass_111.setText("***********");
            finish();
        }

        txtPhone_111.setText("Phone: 0123456789");
        txtEmail_111.setText("Email: " + (username_111 != null ? username_111 : "demo") + "@example.com");

        imgSetting_111.setOnClickListener(v -> {
            Intent intent_111 = new Intent(ProfileActivity.this, MainActivity.class);
            startActivity(intent_111);
            finish();
        });
    }
}
