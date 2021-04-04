package meugeninua.android.handler.app.di.ui.fragments;

import androidx.lifecycle.ViewModelProvider;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import meugeninua.android.handler.ui.fragments.test.main.TestMainFragment;
import meugeninua.android.handler.ui.fragments.test.main.TestMainViewModel;

@Module
public interface TestMainComponent {

    @ContributesAndroidInjector(modules = TestMainModule.class)
    TestMainFragment bindFragment();
}

@Module
class TestMainModule {

    @Provides
    public static TestMainViewModel viewModel(
        TestMainFragment fragment
    ) {
        ViewModelProvider.Factory factory = new ViewModelProvider.NewInstanceFactory();
        return new ViewModelProvider(fragment, factory).get(TestMainViewModel.class);
    }
}
