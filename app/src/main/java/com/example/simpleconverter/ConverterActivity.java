package com.example.simpleconverter;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.simpleconverter.adapters.UnitSpinnerAdapter;
import com.example.simpleconverter.models.Conversion;

import java.util.List;

import static com.example.simpleconverter.MainActivity.CONVERSION_EXTRA;

public class ConverterActivity  extends AppCompatActivity {

    private Conversion mConversion;

    private TextView convertFromTextView;
    private TextView convertToTextView;
    private EditText convertFromEditText;
    private EditText convertToEditText;

    Spinner spinnerTo = findViewById(R.id.convert_to_spinner);
    Spinner spinnerFrom = findViewById(R.id.convert_from_spinner);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        convertFromTextView = findViewById(R.id.convert_from_tv);
        convertToTextView = findViewById(R.id.convert_to_tv);
        convertFromEditText = findViewById(R.id.convert_from_et);
        convertToEditText = findViewById(R.id.convert_to_et);

        Intent intent = getIntent();
        mConversion = (Conversion) intent.getSerializableExtra(CONVERSION_EXTRA);

        convertFromEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //convertToEditText.setText(Double.parseDouble(convertFromEditText.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        initConvertFromSpinner();
        initConvertToSpinner();


    }

    private void initConvertToSpinner() {
        spinnerTo.setAdapter(new UnitSpinnerAdapter(mConversion.getUnits()));

        spinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                convertToTextView.setText(mConversion.getUnits().get(position).getName());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    private void initConvertFromSpinner() {
        spinnerFrom.setAdapter(new UnitSpinnerAdapter(mConversion.getUnits()));
        spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                convertFromTextView.setText(mConversion.getUnits().get(position).getName());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }
}
