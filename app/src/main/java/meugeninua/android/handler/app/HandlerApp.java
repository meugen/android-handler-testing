package meugeninua.android.handler.app;

import android.app.Application;
import android.content.Context;

import androidx.fragment.app.Fragment;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import meugeninua.android.handler.BuildConfig;
import meugeninua.android.handler.app.di.DaggerAppComponent;
import timber.log.Timber;

public class HandlerApp extends Application implements HasAndroidInjector {

    public static void inject(Fragment fragment, Object component) {
        inject(fragment.requireContext(), component);
    }

    public static void inject(Context context, Object component) {
        HandlerApp app = (HandlerApp) context.getApplicationContext();
        app.androidInjector().inject(component);
    }

    @Inject
    public DispatchingAndroidInjector<Object> androidInjector;

    @Override
    public AndroidInjector<Object> androidInjector() {
        return androidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        DaggerAppComponent.factory()
                .create(this).inject(this);
    }
}
