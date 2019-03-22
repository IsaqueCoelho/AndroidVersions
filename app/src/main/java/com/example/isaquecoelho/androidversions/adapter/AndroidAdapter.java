package com.example.isaquecoelho.androidversions.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.isaquecoelho.androidversions.modal.Android;
import com.example.isaquecoelho.androidversions.R;
import com.example.isaquecoelho.androidversions.databinding.ItemAndroidBinding;

import java.util.List;

public class AndroidAdapter extends RecyclerView.Adapter<AndroidAdapter.AndroidViewHolder>{

    private List<Android> mAndroidList;

    public AndroidAdapter(List<Android> mAndroidList) {
        this.mAndroidList = mAndroidList;
    }

    @NonNull
    @Override
    public AndroidViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        ItemAndroidBinding itemAndroidBinding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()), R.layout.item_android, viewGroup, false);

        return new AndroidViewHolder(itemAndroidBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AndroidViewHolder androidViewHolder, int position) {
        Android android = mAndroidList.get(position);
        androidViewHolder.androidBinding.setAndroidItem(android);
    }

    @Override
    public int getItemCount() {
        return mAndroidList.size();
    }

    static class AndroidViewHolder extends RecyclerView.ViewHolder{

        private ItemAndroidBinding androidBinding;

        AndroidViewHolder(@NonNull ItemAndroidBinding itemView) {
            super(itemView.getRoot());
            androidBinding = itemView;
        }
    }
}
