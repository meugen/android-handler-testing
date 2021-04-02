package meugeninua.android.handler.app.di;

import android.app.Application;

import androidx.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import meugeninua.android.handler.async.executors.ExecutorAsyncHandler;
import meugeninua.android.handler.utils.AsyncHandler;

@Module
public class AsyncComponent {

    @Provides
    @Singleton
    public static AsyncHandler provideAsyncHandler(@NonNull Application app) {
        return new ExecutorAsyncHandler(app);
    }
}
