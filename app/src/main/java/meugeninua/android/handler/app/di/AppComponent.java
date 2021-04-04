package meugeninua.android.handler.app.di;

import android.app.Application;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;
import meugeninua.android.handler.app.HandlerApp;
import meugeninua.android.handler.app.di.ui.UiComponent;

@Component(modules = {
    AndroidSupportInjectionModule.class,
    UiComponent.class,
    AsyncComponent.class
})
public interface AppComponent {

    void inject(HandlerApp app);

    @Component.Factory
    interface Factory {
        AppComponent create(@BindsInstance Application app);
    }
}
