package com.example.simpleconverter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        convertFromTextView = (TextView) findViewById(R.id.convert_from_tv);
        convertToTextView = (TextView) findViewById(R.id.convert_to_tv);

        Intent intent = getIntent();
        mConversion = (Conversion) intent.getSerializableExtra(CONVERSION_EXTRA);

        initConvertFromSpinner();
        initConvertToSpinner();


    }

    private void initConvertToSpinner() {
        Spinner spinner = findViewById(R.id.convert_from_spinner);
        spinner.setAdapter(new UnitSpinnerAdapter(mConversion.getUnits()));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    private void initConvertFromSpinner() {
        Spinner spinner = findViewById(R.id.convert_to_spinner);

    }



}
