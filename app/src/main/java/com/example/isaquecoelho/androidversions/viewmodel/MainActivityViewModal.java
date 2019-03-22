package com.example.isaquecoelho.androidversions.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.isaquecoelho.androidversions.modal.Android;
import com.example.isaquecoelho.androidversions.repositories.AndroidRepository;

import java.util.List;

public class MainActivityViewModal extends ViewModel {

    private MutableLiveData<List<Android>> mAndroidList;
    private AndroidRepository mAndroidRepository;

    public void init(){

        if (mAndroidList != null){
            return;
        }

        mAndroidRepository = AndroidRepository.getInstance();
        mAndroidList = mAndroidRepository.getAndroidList();
    }

    public LiveData<List<Android>> getAndroidList(){
        return mAndroidList;
    }
}
