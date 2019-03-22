package com.example.isaquecoelho.androidversions.modal;

import android.databinding.BindingAdapter;
import android.support.v4.content.ContextCompat;
import android.view.View;

import de.hdodenhof.circleimageview.CircleImageView;

public class Android {

    private final String name;
    private final String version;
    private final int image;

    public Android(String name, String version, int image) {
        this.name = name;
        this.version = version;
        this.image = image;
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
