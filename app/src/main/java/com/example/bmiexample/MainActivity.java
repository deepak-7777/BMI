package com.example.bmiexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtHeightFt, edtWeight, edtHeightIn;
    TextView txtResult;
    Button btnCalculate;
    LinearLayout llmain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.llmain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        
        edtHeightFt = findViewById(R.id.editTextText2);
        edtHeightIn = findViewById(R.id.editTextText3);
        edtWeight = findViewById(R.id.editTextText1);
        txtResult = findViewById(R.id.textView);
        btnCalculate = findViewById(R.id.button);
        llmain = findViewById(R.id.llmain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             int wt = Integer.parseInt(edtWeight.getText().toString() );
             int ft = Integer.parseInt(edtHeightFt .getText().toString() );
             int in = Integer.parseInt(edtHeightFt .getText().toString() );

             int totalIn = ft*12 + in;

             double totalCm = totalIn * 2.53;

             double totalM = totalCm / 100;

             double bmi = wt/(totalM * totalM);

             if(bmi>25) {
                 txtResult.setText("You're Overweighted");
                 llmain.setBackgroundColor(getResources().getColor(R.color.colorOw ) );
             }
             else if (bmi<18) {
                 txtResult.setText("You're Underweighted");
                 llmain.setBackgroundColor(getResources().getColor(R.color.colorUw ) );
             }
             else {
                 txtResult.setText("You're Healthy");
                 llmain.setBackgroundColor(getResources().getColor(R.color.colorH ) );
             }


            }
        });

    }
}