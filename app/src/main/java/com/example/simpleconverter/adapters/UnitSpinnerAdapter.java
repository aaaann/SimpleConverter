package com.example.simpleconverter.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.simpleconverter.models.Conversion;
import com.example.simpleconverter.models.Unit;

import java.util.List;

public class UnitSpinnerAdapter extends BaseAdapter {
    private final List<Unit> mUnits;

    public UnitSpinnerAdapter(@NonNull List<Unit> units) {
        mUnits = units;
    }

    @Override
    public int getCount() {
        return mUnits.size();
    }

    @Override
    public Unit getItem(int position) {
        return mUnits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(android.R.layout.simple_list_item_1, parent, false);
            ViewHolder viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.mUnitName.setText(getItem(position).getName());
        return convertView;
    }


    private class ViewHolder {
        private final TextView mUnitName;

        private ViewHolder(View view) {
            mUnitName = view.findViewById(android.R.id.text1);
        }
    }
}
