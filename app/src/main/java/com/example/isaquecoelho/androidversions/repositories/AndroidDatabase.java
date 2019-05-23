package com.example.isaquecoelho.androidversions.repositories;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.isaquecoelho.androidversions.modal.Android;

@Database(entities = {Android.class}, version = 1)
public abstract class AndroidDatabase extends RoomDatabase {

    private static AndroidDatabase instance;

    public abstract AndroidDao androidDao();

    static synchronized AndroidDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AndroidDatabase.class,
                    "android_database" )
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
