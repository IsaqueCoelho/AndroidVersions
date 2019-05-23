package com.example.isaquecoelho.androidversions.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.isaquecoelho.androidversions.R;
import com.example.isaquecoelho.androidversions.modal.Android;

import java.util.List;

public class AndroidRepository {

    private AndroidDao mAndroidDao;
    private LiveData<List<Android>> AndroidList;

    public AndroidRepository(Application application) {
        AndroidDatabase database = AndroidDatabase.getInstance(application);
        mAndroidDao = database.androidDao();
        AndroidList = mAndroidDao.getAllAndroid();
    }

    public void insertTest(){
        new InsertAndroidListTestAsyncTask(mAndroidDao).execute();
    }

    public void deleteAll(){
        new DeleteAndroidListAsyncTask(mAndroidDao).execute();
    }

    public LiveData<List<Android>> getAndroidList() {
        return AndroidList;
    }

    private static class InsertAndroidListTestAsyncTask extends AsyncTask<Void, Void, Void>{
        private AndroidDao androidDao;

        InsertAndroidListTestAsyncTask(AndroidDao androidDao) {
            this.androidDao = androidDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            androidDao.insert(new Android("Cupcake", "V1.5", R.drawable.ic_1));
            androidDao.insert(new Android("Eclair", "V2.0", R.drawable.ic_2));
            androidDao.insert(new Android("Honeycomb", "V3.0", R.drawable.ic_3));
            androidDao.insert(new Android("KitKat", "V4.4", R.drawable.ic_4));
            androidDao.insert(new Android("Lollipop", "V5.0", R.drawable.ic_5));
            androidDao.insert(new Android("Marshmallow", "V6.0", R.drawable.ic_6));
            androidDao.insert(new Android("Nougat", "V7.0", R.drawable.ic_7));
            androidDao.insert(new Android("Oreo", "V8.0", R.drawable.ic_8));
            androidDao.insert(new Android("Pie", "V9.0", R.drawable.ic_9));

            return null;
        }
    }

    private static class DeleteAndroidListAsyncTask extends AsyncTask<Void, Void, Void>{

        private AndroidDao androidDao;

        DeleteAndroidListAsyncTask(AndroidDao androidDao) {
            this.androidDao = androidDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            androidDao.deleteAll();
            return null;
        }
    }
}
