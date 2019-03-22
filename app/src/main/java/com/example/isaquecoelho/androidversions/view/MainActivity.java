package com.example.isaquecoelho.androidversions.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.LinearLayout;

import com.example.isaquecoelho.androidversions.R;
import com.example.isaquecoelho.androidversions.adapter.AndroidAdapter;
import com.example.isaquecoelho.androidversions.databinding.ActivityMainBinding;
import com.example.isaquecoelho.androidversions.modal.Android;
import com.example.isaquecoelho.androidversions.util.CustomApplication;
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

        CustomApplication.setContext(this);

        listeningView();
        populateAdapter();
    }

    private void listeningView() {

        mMainActivityViewModal = ViewModelProviders.of(this).get(MainActivityViewModal.class);
        mMainActivityViewModal.init();
        mMainActivityViewModal.getAndroidList().observe(this, new Observer<List<Android>>() {
            @Override
            public void onChanged(@Nullable List<Android> androids) {
                mAndroidAdapter.notifyDataSetChanged();
            }
        });
    }

    private void populateAdapter() {
        //mAndroidAdapter = new AndroidAdapter(getAndroidList());
        mAndroidAdapter = new AndroidAdapter(mMainActivityViewModal.getAndroidList().getValue());

        androidBinding.recyclerviewAndroidlist.setLayoutManager(
                new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        androidBinding.recyclerviewAndroidlist.setHasFixedSize(true);

        androidBinding.recyclerviewAndroidlist.setAdapter(mAndroidAdapter);
    }
}
