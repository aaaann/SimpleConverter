package com.example.simpleconverter.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.simpleconverter.R;
import com.example.simpleconverter.adapters.UnitSpinnerAdapter;
import com.example.simpleconverter.models.Conversion;
import com.example.simpleconverter.models.Unit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnFocusChange;
import butterknife.Unbinder;


public class ConverterFragment extends Fragment {

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

    private static final String ARG_CONVERSION = "conversionType";
    private Unbinder unbinder;
    private Conversion mConversion;
    private TextWatcher textWatcher;

    public static ConverterFragment newInstance(@NonNull Conversion conversion) {

        Bundle args = new Bundle();
        args.putSerializable(ARG_CONVERSION, conversion);
        ConverterFragment fragment = new ConverterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public ConverterFragment() {
        super(R.layout.fragment_converter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mConversion = (Conversion) getArguments().getSerializable(ARG_CONVERSION);
        initConvertSpinner(spinnerTo);
        initConvertSpinner(spinnerFrom);

        textWatcher = getTextWatcher();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnFocusChange({R.id.convert_from_et, R.id.convert_to_et})
    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()) {
            case R.id.convert_from_et: {
                if (hasFocus) {
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

    private TextWatcher getTextWatcher() {
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
                switch (spinner.getId()) {
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
        } else if (convertToEditText.hasFocus()) {
            convertFromEditText.setText(convertToEditText.getText().length() == 0 ? "" : String.format(getString(R.string.format), (Double.parseDouble(convertToEditText.getText().toString()) * currentUnitTo.getProportion())
                    / currentUnitFrom.getProportion()));
        }
    }
}
