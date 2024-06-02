package com.example.basiccalculatortask01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button PlusBtn,SubBtn,multiplyBtn,DivBtn;
    EditText Number1,Number2;
    TextView textView;
    int num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        PlusBtn = findViewById(R.id.PlusBtn);
        SubBtn = findViewById(R.id.SubBtn);
        multiplyBtn = findViewById(R.id.multiplyBtn);
        DivBtn = findViewById(R.id.DivBtn);
        Number1 = findViewById(R.id.Number1);
        Number2 = findViewById(R.id.Number2);
        textView = findViewById(R.id.Answer);

        PlusBtn.setOnClickListener(this);
        SubBtn.setOnClickListener(this);
        multiplyBtn.setOnClickListener(this);
        DivBtn.setOnClickListener(this);
    }
    public int getIntfromEditText(EditText editText) {
        if (editText.getText().toString().equals("")) {
            Toast.makeText(this, "Enter number", Toast.LENGTH_SHORT).show();
            return 0;
        }
        return Integer.parseInt(editText.getText().toString());
    }





    @Override
    public void onClick(View view) {
        num1 = getIntfromEditText(Number1);
        num2 = getIntfromEditText(Number2);

        // Use if-else statements to handle button clicks
        if (view.getId() == R.id.PlusBtn) {
            textView.setText("Answer = " + (num1 + num2));
        } else if (view.getId() == R.id.SubBtn) {
            textView.setText("Answer = " + (num1 - num2));
        } else if (view.getId() == R.id.multiplyBtn) {
            textView.setText("Answer = " + (num1 * num2));
        } else if (view.getId() == R.id.DivBtn) {
            if (num2 != 0) {
                textView.setText("Answer = " + ((float) num1 / num2));
            } else {
                textView.setText("Cannot divide by zero");
            }
        }
}
}

