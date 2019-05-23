package com.example.isaquecoelho.androidversions.repositories;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.isaquecoelho.androidversions.modal.Android;

import java.util.List;

@Dao
public interface AndroidDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Android android);

    @Query("SELECT `id`, `name`, `version`, `image` FROM `android` ")
    LiveData<List<Android>> getAllAndroid();

    @Query("DELETE FROM `android`")
    void deleteAll();
}
