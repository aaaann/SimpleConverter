package com.example.simpleconverter;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.simpleconverter.adapters.UnitSpinnerAdapter;
import com.example.simpleconverter.models.Conversion;
import com.example.simpleconverter.models.Unit;

import java.util.PrimitiveIterator;

import static com.example.simpleconverter.MainActivity.CONVERSION_EXTRA;

public class ConverterActivity extends AppCompatActivity {

    private Conversion mConversion;

    private TextView convertFromTextView;
    private TextView convertToTextView;
    private EditText convertFromEditText;
    private EditText convertToEditText;

    Spinner spinnerTo;
    Spinner spinnerFrom;

    private TextWatcher textWatcher;

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

        spinnerFrom = findViewById(R.id.convert_from_spinner);
        spinnerTo = findViewById(R.id.convert_to_spinner);

        initConvertFromSpinner();
        initConvertToSpinner();

        textWatcher = getTextWatcher();


        convertFromEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ON_CLICK", "convertFromEditText");
                convertToEditText.removeTextChangedListener(textWatcher);
                Log.d("REMOVED_TEXT_WATCHER", "convertToEditText");
                convertFromEditText.addTextChangedListener(textWatcher);
            }
        });
        convertToEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ON_CLICK", "convertToEditText");
                convertFromEditText.removeTextChangedListener(textWatcher);
                convertToEditText.addTextChangedListener(textWatcher);
            }
        });


        //convertToEditText.addTextChangedListener(getTextWatcher());


//        convertFromEditText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Unit currentUnitFrom = mConversion.getUnits().get(spinnerFrom.getSelectedItemPosition());
//                Unit currentUnitTo = mConversion.getUnits().get(spinnerTo.getSelectedItemPosition());
//                convertToEditText.setText(convertFromEditText.getText().length() == 0 ? "" : String.valueOf((Double.parseDouble(convertFromEditText.getText().toString()) * currentUnitFrom.getProportion())
//                        / currentUnitTo.getProportion()));
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });


    }

    private TextWatcher getTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Unit currentUnitFrom = mConversion.getUnits().get(spinnerFrom.getSelectedItemPosition());
                Unit currentUnitTo = mConversion.getUnits().get(spinnerTo.getSelectedItemPosition());
                Log.d("FOCUS", "convertFromEditText.hasFocus(): " + convertFromEditText.hasFocus());
                Log.d("FOCUS", "convertToEditText.hasFocus(): " + convertToEditText.hasFocus());
                if (convertFromEditText.hasFocus()) {
                    Log.d("ON_TEXT_CHANGED", "convertFromEditText");
                    convertToEditText.setText(convertFromEditText.getText().length() == 0 ? "" : String.valueOf((Double.parseDouble(convertFromEditText.getText().toString()) * currentUnitFrom.getProportion())
                            / currentUnitTo.getProportion()));
                } else if (convertToEditText.hasFocus()){
                    Log.d("ON_TEXT_CHANGED", "convertToEditText");
                    convertFromEditText.setText(convertToEditText.getText().length() == 0 ? "" : String.valueOf((Double.parseDouble(convertToEditText.getText().toString()) * currentUnitFrom.getProportion())
                            / currentUnitTo.getProportion()));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }



    private void initConvertToSpinner() {
//        spinnerTo = findViewById(R.id.convert_to_spinner);
        spinnerTo.setAdapter(new UnitSpinnerAdapter(mConversion.getUnits()));

        spinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                convertToTextView.setText(mConversion.getUnits().get(position).getName());
                Unit currentUnitFrom = mConversion.getUnits().get(spinnerFrom.getSelectedItemPosition());
                Unit currentUnitTo = mConversion.getUnits().get(spinnerTo.getSelectedItemPosition());
                Log.d("FOCUS", "convertFromEditText.hasFocus(): " + convertFromEditText.hasFocus());
                Log.d("FOCUS", "convertToEditText.hasFocus(): " + convertToEditText.hasFocus());
                if (convertFromEditText.hasFocus()) {
                    Log.d("ON_TEXT_CHANGED", "convertFromEditText");
                    convertToEditText.setText(convertFromEditText.getText().length() == 0 ? "" : String.valueOf((Double.parseDouble(convertFromEditText.getText().toString()) * currentUnitFrom.getProportion())
                            / currentUnitTo.getProportion()));
                } else if (convertToEditText.hasFocus()){
                    Log.d("ON_TEXT_CHANGED", "convertToEditText");
                    convertFromEditText.setText(convertToEditText.getText().length() == 0 ? "" : String.valueOf((Double.parseDouble(convertToEditText.getText().toString()) * currentUnitFrom.getProportion())
                            / currentUnitTo.getProportion()));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    private void initConvertFromSpinner() {
//        spinnerFrom = findViewById(R.id.convert_from_spinner);
        spinnerFrom.setAdapter(new UnitSpinnerAdapter(mConversion.getUnits()));
        spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                convertFromTextView.setText(mConversion.getUnits().get(position).getName());
                Unit currentUnitFrom = mConversion.getUnits().get(spinnerFrom.getSelectedItemPosition());
                Unit currentUnitTo = mConversion.getUnits().get(spinnerTo.getSelectedItemPosition());
                Log.d("FOCUS", "convertFromEditText.hasFocus(): " + convertFromEditText.hasFocus());
                Log.d("FOCUS", "convertToEditText.hasFocus(): " + convertToEditText.hasFocus());
                if (convertFromEditText.hasFocus()) {
                    Log.d("ON_TEXT_CHANGED", "convertFromEditText");
                    convertToEditText.setText(convertFromEditText.getText().length() == 0 ? "" : String.valueOf((Double.parseDouble(convertFromEditText.getText().toString()) * currentUnitFrom.getProportion())
                            / currentUnitTo.getProportion()));
                } else if (convertToEditText.hasFocus()){
                    Log.d("ON_TEXT_CHANGED", "convertToEditText");
                    convertFromEditText.setText(convertToEditText.getText().length() == 0 ? "" : String.valueOf((Double.parseDouble(convertToEditText.getText().toString()) * currentUnitFrom.getProportion())
                            / currentUnitTo.getProportion()));
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }
}
