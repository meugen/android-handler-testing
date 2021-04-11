package meugeninua.android.handler.app.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import meugeninua.android.handler.async.coroutines.CoroutinesAsyncHandler;
import meugeninua.android.handler.utils.async.AsyncHandler;

@Module
public class AsyncComponent {

    @Provides
    public static AsyncHandler provideAsyncHandler() {
        return new CoroutinesAsyncHandler();
    }
}
