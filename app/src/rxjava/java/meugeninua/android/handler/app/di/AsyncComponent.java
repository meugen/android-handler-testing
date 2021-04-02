package meugeninua.android.handler.app.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import meugeninua.android.handler.async.rxjava.RxjavaAsyncHandler;
import meugeninua.android.handler.utils.AsyncHandler;

@Module
public class AsyncComponent {

    @Provides
    @Singleton
    public static AsyncHandler provideAsyncHandler() {
        return new RxjavaAsyncHandler();
    }
}
