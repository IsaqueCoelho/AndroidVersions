package com.example.isaquecoelho.androidversions.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.isaquecoelho.androidversions.R;
import com.example.isaquecoelho.androidversions.databinding.ItemAndroidBinding;
import com.example.isaquecoelho.androidversions.modal.Android;

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
        return (mAndroidList == null) ? 0 : mAndroidList.size();
    }

    public void setAndroidList(List<Android> androidList){
        this.mAndroidList = androidList;
        notifyDataSetChanged();
    }

    static class AndroidViewHolder extends RecyclerView.ViewHolder{

        private ItemAndroidBinding androidBinding;

        AndroidViewHolder(@NonNull ItemAndroidBinding itemView) {
            super(itemView.getRoot());
            androidBinding = itemView;
        }
    }
}
