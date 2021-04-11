package meugeninua.android.handler.app.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;
import meugeninua.android.handler.app.HandlerApp;
import meugeninua.android.handler.app.di.modules.AppModule;
import meugeninua.android.handler.app.di.ui.UiComponent;

@Singleton
@Component(modules = {
    AndroidSupportInjectionModule.class,
    UiComponent.class,
    AsyncComponent.class,
    AppModule.class
})
public interface AppComponent {

    void inject(HandlerApp app);

    @Component.Factory
    interface Factory {
        AppComponent create(@BindsInstance Application app);
    }
}
