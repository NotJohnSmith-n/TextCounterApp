package com.example.textcounterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etInputText;
    private Spinner spnMetricType;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInputText = findViewById(R.id.etInputText);
        spnMetricType = findViewById(R.id.spnMetricType);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.calculation_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnMetricType.setAdapter(adapter);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = etInputText.getText().toString();
                if (text.trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.error_empty_input, Toast.LENGTH_SHORT).show();
                    return;
                }

                int result = 0;
                int selected = spnMetricType.getSelectedItemPosition();

                switch (selected) {
                    case 0: result = TextAnalyzer.countSentences(text); break;
                    case 1: result = TextAnalyzer.countWords(text); break;
                    case 2: result = TextAnalyzer.countPunctuation(text); break;
                    case 3: result = TextAnalyzer.countNumbers(text); break;
                }
                tvResult.setText(getString(R.string.result_text) + result);
            }
        });
    }
}