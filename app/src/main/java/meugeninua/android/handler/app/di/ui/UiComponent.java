package meugeninua.android.handler.app.di.ui;

import dagger.Module;
import meugeninua.android.handler.app.di.ui.fragments.CitiesComponent;
import meugeninua.android.handler.app.di.ui.fragments.ComingSoonComponent;
import meugeninua.android.handler.app.di.ui.fragments.CountriesComponent;
import meugeninua.android.handler.app.di.ui.fragments.TestFirstComponent;
import meugeninua.android.handler.app.di.ui.fragments.TestMainComponent;
import meugeninua.android.handler.app.di.ui.fragments.TestSecondComponent;
import meugeninua.android.handler.ui.fragments.test.second.TestSecondViewModel;

@Module(includes = {
    ComingSoonComponent.class,
    CitiesComponent.class,
    CountriesComponent.class,
    TestMainComponent.class,
    TestFirstComponent.class,
    TestSecondComponent.class
})
public interface UiComponent {
}
