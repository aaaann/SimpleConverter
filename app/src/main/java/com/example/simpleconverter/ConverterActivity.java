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
import com.example.simpleconverter.models.Unit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnFocusChange;

import static com.example.simpleconverter.MainActivity.CONVERSION_EXTRA;

public class ConverterActivity extends AppCompatActivity {

    private Conversion mConversion;

    @BindView(R.id.convert_from_tv)
    TextView convertFromTextView;
    @BindView(R.id.convert_to_tv)
    TextView convertToTextView;
    @BindView(R.id.convert_from_et)
    EditText convertFromEditText;
    @BindView(R.id.convert_to_et)
    EditText convertToEditText;

    @BindView(R.id.convert_to_spinner)
    Spinner spinnerTo;
    @BindView(R.id.convert_from_spinner)
    Spinner spinnerFrom;

    private TextWatcher textWatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        mConversion = (Conversion) intent.getSerializableExtra(CONVERSION_EXTRA);

        initConvertSpinner(spinnerTo);
        initConvertSpinner(spinnerFrom);

        textWatcher = getTextWatcher();

    }

    @OnFocusChange({R.id.convert_from_et, R.id.convert_to_et})
    public void onFocusChange(View v, boolean hasFocus) {
        switch(v.getId()){
            case R.id.convert_from_et: {
                if (hasFocus){
                    convertToEditText.removeTextChangedListener(textWatcher);
                    convertFromEditText.addTextChangedListener(textWatcher);
                }
                break;
            }
            case R.id.convert_to_et: {
                if (hasFocus) {
                    convertFromEditText.removeTextChangedListener(textWatcher);
                    convertToEditText.addTextChangedListener(textWatcher);
                }
                break;
            }
        }
    }

    private TextWatcher getTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                executeConvert();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }

    private void initConvertSpinner(Spinner spinner) {
        spinner.setAdapter(new UnitSpinnerAdapter(mConversion.getUnits()));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (spinner.getId()){
                    case R.id.convert_from_spinner:
                        convertFromTextView.setText(mConversion.getUnits().get(position).getName());
                        break;
                    case R.id.convert_to_spinner:
                        convertToTextView.setText(mConversion.getUnits().get(position).getName());
                        break;
                }
                executeConvert();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void executeConvert() {
        Unit currentUnitFrom = mConversion.getUnits().get(spinnerFrom.getSelectedItemPosition());
        Unit currentUnitTo = mConversion.getUnits().get(spinnerTo.getSelectedItemPosition());
        if (convertFromEditText.hasFocus()) {
            convertToEditText.setText(convertFromEditText.getText().length() == 0 ? "" : String.format(getString(R.string.format), (Double.parseDouble(convertFromEditText.getText().toString()) * currentUnitFrom.getProportion())
                    / currentUnitTo.getProportion()));
        } else if (convertToEditText.hasFocus()){
            convertFromEditText.setText(convertToEditText.getText().length() == 0 ? "" : String.format(getString(R.string.format), (Double.parseDouble(convertToEditText.getText().toString()) * currentUnitTo.getProportion())
                    / currentUnitFrom.getProportion()));
        }
    }
}
