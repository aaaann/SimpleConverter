package com.example.simpleconverter.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simpleconverter.R;
import com.example.simpleconverter.adapters.ConversionTypeAdapter;
import com.example.simpleconverter.listeners.IMainItemClickListener;
import com.example.simpleconverter.models.Conversion;

import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConversionListFragment extends Fragment {


    public ConversionListFragment() {
        super(R.layout.fragment_conversion_list);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView root = (RecyclerView) super.onCreateView(inflater, container, savedInstanceState);
        ConversionTypeAdapter adapter = new ConversionTypeAdapter(Arrays.asList(Conversion.values()), (IMainItemClickListener) getActivity());
        root.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        root.setAdapter(adapter);
        return root;

    }

}
