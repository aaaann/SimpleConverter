package com.example.simpleconverter.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simpleconverter.MainActivity;
import com.example.simpleconverter.R;
import com.example.simpleconverter.listeners.IMainItemClickListener;
import com.example.simpleconverter.models.Conversion;

import java.util.ArrayList;
import java.util.List;

public class ConversionTypeAdapter extends RecyclerView.Adapter<ConversionTypeAdapter.ConversionTypeHolder>{

private List<Conversion> mConversions;
private IMainItemClickListener mMainItemClickListener;

    public ConversionTypeAdapter(List<Conversion> conversions, IMainItemClickListener mainItemClickListener) {
        mConversions = new ArrayList<>(conversions);
        mMainItemClickListener = mainItemClickListener;
    }

    @NonNull
    @Override
    public ConversionTypeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_conversion_type, parent, false);
        return new ConversionTypeHolder(view, mMainItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ConversionTypeHolder holder, int position) {
        Conversion conversion = mConversions.get(position);
        holder.bindView(conversion);
    }

    @Override
    public int getItemCount() {
        return mConversions.size();
    }

//    public void setConversions(List<Conversion> convserions) {
//        mConversions = new ArrayList<>(convserions);
//    }


    static class ConversionTypeHolder extends RecyclerView.ViewHolder {
        private final TextView mType;
        private final IMainItemClickListener mMainItemClickListener;


        private ConversionTypeHolder(View view, IMainItemClickListener iMainItemClickListener) {
            super(view);
            mType = view.findViewById(R.id.conversion_type);
            mMainItemClickListener = iMainItemClickListener;
        }

        private void bindView(final Conversion conversion) {
            mType.setText(conversion.getLabel());
            itemView.setOnClickListener(v -> mMainItemClickListener.onMainItemClick(conversion));
        }
}

}
