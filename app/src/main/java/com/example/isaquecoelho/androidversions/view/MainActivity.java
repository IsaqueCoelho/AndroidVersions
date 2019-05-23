package com.example.isaquecoelho.androidversions.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.isaquecoelho.androidversions.R;
import com.example.isaquecoelho.androidversions.adapter.AndroidAdapter;
import com.example.isaquecoelho.androidversions.databinding.ActivityMainBinding;
import com.example.isaquecoelho.androidversions.modal.Android;
import com.example.isaquecoelho.androidversions.viewmodel.MainActivityViewModal;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding androidBinding;
    private MainActivityViewModal mMainActivityViewModal;
    private AndroidAdapter mAndroidAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        androidBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        listeningView();
        populateAdapter();
    }

    private void listeningView() {

        mMainActivityViewModal = ViewModelProviders.of(this).get(MainActivityViewModal.class);

        mMainActivityViewModal.getAndroidList().observe(this, new Observer<List<Android>>() {
            @Override
            public void onChanged(@Nullable List<Android> androids) {
                mAndroidAdapter.setAndroidList(androids);
            }
        });
    }

    private void populateAdapter() {
        mAndroidAdapter = new AndroidAdapter(mMainActivityViewModal.getAndroidList().getValue());

        androidBinding.recyclerviewAndroidlist.setLayoutManager(
                new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        androidBinding.recyclerviewAndroidlist.setHasFixedSize(true);

        androidBinding.recyclerviewAndroidlist.setAdapter(mAndroidAdapter);
    }
}
