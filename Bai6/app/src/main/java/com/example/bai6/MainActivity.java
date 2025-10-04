package com.example.bai6;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtUserName_111, edtPassword_111;
    private Button btnLogin_111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main); // không cần đổi vì file XML tên vẫn vậy

        // ánh xạ view với id đã thêm hậu tố _111
        edtUserName_111 = findViewById(R.id.edtUserName_111);
        edtPassword_111 = findViewById(R.id.edtPassword_111);
        btnLogin_111 = findViewById(R.id.btnLogin_111);

        btnLogin_111.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username_111 = edtUserName_111.getText().toString().trim();
                String password_111 = edtPassword_111.getText().toString().trim();

                if (username_111.isEmpty() || password_111.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Vui lòng nhập tên đăng nhập và mật khẩu", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent_111 = new Intent(MainActivity.this, ProfileActivity.class);
                    intent_111.putExtra("username", username_111);
                    intent_111.putExtra("password", password_111);
                    startActivity(intent_111);
                    finish();
                }
            }
        });
    }
}
