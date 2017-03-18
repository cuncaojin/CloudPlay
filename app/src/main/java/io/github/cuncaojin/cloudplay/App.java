package io.github.cuncaojin.cloudplay;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by cuncaojin on 2017/3/16.
 */

public class App extends Application {

     static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;
        initFreso();
    }

    private void initFreso() {
        Fresco.initialize(this);
    }

    public static Context getContext() {
        return context;
    }
}
