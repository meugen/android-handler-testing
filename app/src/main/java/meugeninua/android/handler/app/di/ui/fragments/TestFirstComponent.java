package meugeninua.android.handler.app.di.ui.fragments;

import androidx.lifecycle.ViewModelProvider;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import meugeninua.android.handler.ui.fragments.test.first.ITestFirstViewModel;
import meugeninua.android.handler.ui.fragments.test.first.TestFirstFragment;
import meugeninua.android.handler.ui.fragments.test.first.TestFirstViewModel;

@Module
public interface TestFirstComponent {

    @ContributesAndroidInjector(modules = TestFirstModule.class)
    TestFirstFragment bindFragment();
}

@Module
class TestFirstModule {

    @Provides
    public static ITestFirstViewModel viewModule(
        TestFirstFragment fragment
    ) {
        ViewModelProvider.Factory factory = new ViewModelProvider.NewInstanceFactory();
        return new ViewModelProvider(fragment, factory).get(TestFirstViewModel.class);
    }
}