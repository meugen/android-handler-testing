package meugeninua.android.handler.app.di.ui.fragments;

import androidx.lifecycle.ViewModelProvider;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import meugeninua.android.handler.ui.fragments.countries.CountriesFragment;
import meugeninua.android.handler.ui.fragments.countries.CountriesViewModel;

@Module
public interface CountriesComponent {

    @ContributesAndroidInjector(modules = CountriesModule.class)
    CountriesFragment bindFragment();
}

@Module
class CountriesModule {

    @Provides
    public static CountriesViewModel viewModel(CountriesFragment fragment) {
        ViewModelProvider.Factory factory = new ViewModelProvider.NewInstanceFactory();
        return new ViewModelProvider(fragment, factory).get(CountriesViewModel.class);
    }
}