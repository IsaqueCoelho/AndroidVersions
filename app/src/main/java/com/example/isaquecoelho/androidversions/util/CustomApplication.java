package com.example.isaquecoelho.androidversions.util;

import android.app.Application;
import android.content.Context;

public class CustomApplication extends Application {

    private static Context context;

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        CustomApplication.context = context;
    }
}
