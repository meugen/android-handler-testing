package meugeninua.android.handler.app.di;

import android.app.Application;

import dagger.BindsInstance;
import dagger.Component;
import meugeninua.android.handler.app.HandlerApp;

@Component
public interface AppComponent {

    void inject(HandlerApp app);

    @Component.Factory
    interface Factory {
        AppComponent create(@BindsInstance Application app);
    }
}
