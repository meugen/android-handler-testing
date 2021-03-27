package meugeninua.android.handler.app.di.ui;

import dagger.Module;
import meugeninua.android.handler.app.di.ui.fragments.CitiesComponent;
import meugeninua.android.handler.app.di.ui.fragments.ComingSoonComponent;
import meugeninua.android.handler.app.di.ui.fragments.CountriesComponent;

@Module(includes = {
        ComingSoonComponent.class,
        CitiesComponent.class,
        CountriesComponent.class
})
public interface UiComponent {
}
