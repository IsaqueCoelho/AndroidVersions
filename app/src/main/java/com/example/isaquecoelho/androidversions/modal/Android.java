package com.example.isaquecoelho.androidversions.modal;

import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import de.hdodenhof.circleimageview.CircleImageView;

@Entity(tableName = "android")
public class Android {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private final String name;
    private final String version;
    private final int image;

    public Android(String name, String version, int image) {
        this.name = name;
        this.version = version;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public int getImage() {
        return image;
    }

    @BindingAdapter("android:getImage")
    public static void setImageView(View view, int image) {
        CircleImageView circleImageView = (CircleImageView) view;
        circleImageView.setImageDrawable(ContextCompat.getDrawable(view.getContext(), image));
    }
}
