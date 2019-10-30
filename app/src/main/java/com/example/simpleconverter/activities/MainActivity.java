package com.example.simpleconverter.activities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.simpleconverter.R;
import com.example.simpleconverter.fragments.ConversionListFragment;
import com.example.simpleconverter.fragments.ConverterFragment;
import com.example.simpleconverter.listeners.IMainItemClickListener;
import com.example.simpleconverter.models.Conversion;

public class MainActivity extends AppCompatActivity implements IMainItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment, new ConversionListFragment())
                    .commit();
        }
    }

    @Override
    public void onMainItemClick(@NonNull Conversion conversion) {
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment,
                        ConverterFragment.newInstance(conversion))
                .commit();
    }
}
