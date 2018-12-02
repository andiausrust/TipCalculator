package com.andi.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText billedAmount;
    private SeekBar seekBar;
    private Button calculateButton;
    private TextView calculatedTip;
    private TextView textViewSeekBar;
    private int seekBarPercentage;
    private float enteredBillFloat;
    public static final String TAG = "MAIN ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billedAmount = findViewById(R.id.billAmountId);
        seekBar = findViewById(R.id.seekBar);
        calculateButton = findViewById(R.id.calculateButton);
        calculatedTip = findViewById(R.id.calculatedTip);
        textViewSeekBar = findViewById(R.id.textViewSeekBar);

        Toast.makeText(getApplicationContext(), "hell", Toast.LENGTH_LONG).show();

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewSeekBar.setText(String.valueOf(seekBar.getProgress()) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBarPercentage = seekBar.getProgress();
            }
        });
    }

    public void calculate(){
        float result = 0.0f;
        if (!billedAmount.getText().toString().equals("")) {
            enteredBillFloat = Float.parseFloat(billedAmount.getText().toString());
            result = enteredBillFloat*seekBarPercentage/100;
            textViewSeekBar.setText("Your tip will be " + String.valueOf(result));
            Log.d(TAG, "Hello from Calculate Method");
        }else {
            // Toast ... display text only for short period of time
            Toast.makeText(MainActivity.this, "Please enter a bill amount.", Toast.LENGTH_LONG).show();
        }
    }
}
