package com.example.baith3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumber;
    Button btnKiemTra;
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber = findViewById(R.id.editTextNumber);
        btnKiemTra = findViewById(R.id.btnKiemTra);
        txtKetQua = findViewById(R.id.txtKetQua);

        btnKiemTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editTextNumber.getText().toString().trim();

                if (input.isEmpty()) {
                    editTextNumber.setError("Vui lòng nhập số");
                    return;
                }

                int number;
                try {
                    number = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    txtKetQua.setText("Giá trị nhập không hợp lệ");
                    return;
                }

                if (number < 2) {
                    txtKetQua.setText(number + " không phải là số nguyên tố");
                    return;
                }

                boolean isPrime = true;
                for (int i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    txtKetQua.setText(number + " là số nguyên tố");
                } else {
                    txtKetQua.setText(number + " không phải là số nguyên tố");
                }
            }
        });
    }
}