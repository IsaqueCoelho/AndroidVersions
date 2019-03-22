package com.example.isaquecoelho.androidversions.repositories;

import android.arch.lifecycle.MutableLiveData;

import com.example.isaquecoelho.androidversions.R;
import com.example.isaquecoelho.androidversions.modal.Android;
import com.example.isaquecoelho.androidversions.util.CustomApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AndroidRepository {

    private static AndroidRepository instance;
    private List<Android> androidList = new ArrayList<>();

    public static AndroidRepository getInstance(){
        if(instance == null){
            instance = new AndroidRepository();
        }
        return instance;
    }

    //Pretend to get data from webservice or firebase
    public MutableLiveData<List<Android>> getAndroidList(){
        setAndroidList();
        MutableLiveData<List<Android>> androidDataList = new MutableLiveData<>();
        androidDataList.setValue(androidList);
        return androidDataList;
    }

    private void setAndroidList(){
        List<String> androidNameList =
                Arrays.asList(CustomApplication.getContext().getResources().getStringArray(R.array.names));
        List<String> androidVersionList =
                Arrays.asList(CustomApplication.getContext().getResources().getStringArray(R.array.versions));
        int[] imageId = {R.drawable.ic_1,
                R.drawable.ic_2,
                R.drawable.ic_3,
                R.drawable.ic_4,
                R.drawable.ic_5,
                R.drawable.ic_6,
                R.drawable.ic_7,
                R.drawable.ic_8,
                R.drawable.ic_9};

        for (int indexItem = 0; indexItem < androidNameList.size(); indexItem++) {
            androidList.add(new Android(androidNameList.get(indexItem), androidVersionList.get(indexItem), imageId[indexItem]));
        }
    }
}
