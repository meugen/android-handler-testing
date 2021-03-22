package meugeninua.android.handler.app.di.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import meugeninua.android.handler.ui.fragments.comingsoon.ComingSoonFragment;
import meugeninua.android.handler.ui.fragments.comingsoon.ComingSoonViewModel;

@Module
public interface ComingSoonComponent {

    @ContributesAndroidInjector(modules = ComingSoonModule.class)
    ComingSoonFragment bindFragment();
}

@Module
class ComingSoonModule {

    @Provides
    public static ComingSoonViewModel viewModel(ComingSoonFragment fragment) {
        ViewModelProvider.Factory factory = new ComingSoonViewModelFactory(fragment.getArguments());
        return new ViewModelProvider(fragment, factory).get(ComingSoonViewModel.class);
    }
}

class ComingSoonViewModelFactory implements ViewModelProvider.Factory {

    private final Bundle arguments;

    public ComingSoonViewModelFactory(@Nullable Bundle arguments) {
        this.arguments = arguments == null ? arguments : Bundle.EMPTY;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ComingSoonViewModel(arguments);
    }
}
