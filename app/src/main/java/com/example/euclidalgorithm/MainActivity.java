package com.example.euclidalgorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EuclidsAlgorithm euclidsAlgorithm;

    private static final String TAG = "MainActivity";

    private EditText editTextNumerator, editTextDenominator;
    private TextView textViewExpressions, textViewReducedForm;
    private Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        euclidsAlgorithm = new EuclidsAlgorithm();

        editTextNumerator = (EditText) findViewById(R.id.editText_numerator);
        editTextDenominator = (EditText) findViewById(R.id.editText_denominator);
        textViewExpressions = (TextView) findViewById(R.id.textView_euclid_expressions);
        textViewReducedForm = (TextView) findViewById(R.id.textView_reduced_form);

        buttonCalculate = (Button) findViewById(R.id.button_calculate);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Button calculate clicked.");

                int numerator = Integer.valueOf(editTextNumerator.getText().toString());
                int denominator = Integer.valueOf(editTextDenominator.getText().toString());

                if (euclidsAlgorithm.getListOfExpressions().size() > 0) {
                    euclidsAlgorithm.clearListOfExpressions();
                }

                Fraction reducedFraction = euclidsAlgorithm.getReducedForm(new Fraction(numerator, denominator));

                textViewReducedForm.setText(reducedFraction.toString());
                textViewExpressions.setText(euclidsAlgorithm.toString());
            }
        });
    }
}
