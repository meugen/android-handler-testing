package meugeninua.android.handler.app;

import android.app.Application;

import meugeninua.android.handler.app.di.DaggerAppComponent;

public class HandlerApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.factory()
                .create(this).inject(this);
    }
}
