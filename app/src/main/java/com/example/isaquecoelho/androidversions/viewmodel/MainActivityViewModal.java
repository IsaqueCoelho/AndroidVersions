package com.example.isaquecoelho.androidversions.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.isaquecoelho.androidversions.modal.Android;
import com.example.isaquecoelho.androidversions.repositories.AndroidRepository;

import java.util.List;

public class MainActivityViewModal extends AndroidViewModel{

    private LiveData<List<Android>> androidList;

    public MainActivityViewModal(@NonNull Application application) {
        super(application);
        AndroidRepository repository2 = new AndroidRepository(application);

        repository2.deleteAll();
        repository2.insertTest();

        androidList = repository2.getAndroidList();
    }

    public LiveData<List<Android>> getAndroidList(){
        return androidList;
    }
}
