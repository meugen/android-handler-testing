package meugeninua.android.handler.app.di.ui.fragments;

import androidx.lifecycle.ViewModelProvider;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import meugeninua.android.handler.ui.fragments.cities.CitiesFragment;
import meugeninua.android.handler.ui.fragments.cities.CitiesViewModel;
import meugeninua.android.handler.ui.fragments.cities.ICitiesViewModel;

@Module
public interface CitiesComponent {

    @ContributesAndroidInjector(modules = CitiesModule.class)
    CitiesFragment bindFragment();
}

@Module
class CitiesModule {

    @Provides
    public static ICitiesViewModel viewModel(CitiesFragment fragment) {
        ViewModelProvider.Factory factory = new ViewModelProvider.NewInstanceFactory();
        return new ViewModelProvider(fragment, factory).get(CitiesViewModel.class);
    }
}