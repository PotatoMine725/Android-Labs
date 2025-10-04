package com.example.baith4;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtHeight, edtWeight;
    Button btnResult;
    TextView txtResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtHeight = findViewById(R.id.edtHeight);
        edtWeight = findViewById(R.id.edtWeight);
        btnResult = findViewById(R.id.btnResult);
        txtResult = findViewById(R.id.txtResult);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        });
    }
    protected void calculateBMI () {
        double height = Double.parseDouble(edtHeight.getText().toString());
        double weight = Double.parseDouble(edtWeight.getText().toString());
        height = height/100;
        double bmi = weight / (height * height);

        String category;
        if (bmi < 18.5) {
            category = "Thiếu cân";
        } else if (bmi < 24.9) {
            category = "Bình thường";
        } else if (bmi < 29.9) {
            category = "Béo phì độ I";
        } else if (bmi < 34.9) {
            category = "Béo phì độ II";
        } else{
            category = "Béo phì độ III";
        }
        String result = String.format("Chỉ số BMI: %.2f\nThể trạng: %s", bmi, category);
        txtResult.setText(result);
    }
}