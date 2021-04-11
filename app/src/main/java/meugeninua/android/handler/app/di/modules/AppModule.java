package meugeninua.android.handler.app.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import meugeninua.android.handler.app.config.HandlerAppConfig;
import meugeninua.android.handler.repository.di.RepositoryModule;
import meugeninua.android.handler.utils.config.AppConfig;

@Module(includes = RepositoryModule.class)
public class AppModule {

    @Singleton
    @Provides
    public static AppConfig provideAppConfig() {
        return new HandlerAppConfig();
    }
}
