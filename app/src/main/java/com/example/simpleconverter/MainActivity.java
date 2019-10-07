package com.example.simpleconverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.simpleconverter.adapters.ConversionTypeAdapter;
import com.example.simpleconverter.listeners.IMainItemClickListener;
import com.example.simpleconverter.models.Conversion;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements IMainItemClickListener {

    public static final String CONVERSION_EXTRA = "CONVERSION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.values_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ConversionTypeAdapter adapter = new ConversionTypeAdapter(Arrays.asList(Conversion.values()),this);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onMainItemClick(@NonNull Conversion conversion) {
        Intent intent = new Intent(this, ConverterActivity.class);
        intent.putExtra(CONVERSION_EXTRA, conversion);
        startActivity(intent);
    }
}
