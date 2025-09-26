package com.example.baith2;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumberSigned;
    EditText editTextNumberSigned2;
    Button btnAdd;
    Button btnSub;
    Button btnMul;
    Button btnDiv;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTextNumberSigned = findViewById(R.id.editTextNumberSigned);
        editTextNumberSigned2 = findViewById(R.id.editTextNumberSigned2);
        textViewResult = findViewById(R.id.textViewResult);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        View.OnClickListener btnListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = editTextNumberSigned.getText().toString();
                String s2 = editTextNumberSigned2.getText().toString();

                if (s1.isEmpty() || s2.isEmpty()) {
                    editTextNumberSigned.setError("Không được để trống");
                    editTextNumberSigned2.setError("Không được để trống");
                    return;
                }

                double a = Double.parseDouble(s1);
                double b = Double.parseDouble(s2);
                double result = 0;
                String op = "";

                int id = v.getId();
                if (id == R.id.btnAdd) {
                    result = a + b;
                    op = "+";
                } else if (id == R.id.btnSub) {
                    result = a - b;
                    op = "-";
                } else if (id == R.id.btnMul) {
                    result = a * b;
                    op = "*";
                } else if (id == R.id.btnDiv) {
                    if (b == 0) {
                        textViewResult.setText("Không thể chia cho 0");
                        return;
                    }
                    result = a / b;
                    op = "/";
                }

                textViewResult.setText(String.format("%.2f %s %.2f = %.2f", a, op, b, result));
            }
        };

        btnAdd.setOnClickListener(btnListener);
        btnSub.setOnClickListener(btnListener);
        btnMul.setOnClickListener(btnListener);
        btnDiv.setOnClickListener(btnListener);
    }
}