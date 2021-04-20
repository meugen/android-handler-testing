package meugeninua.android.handler.app.di.ui.fragments;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import meugeninua.android.handler.repository.RefHolderRepository;
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
        TestMainFragment fragment,
        RefHolderRepository refHolderRepository
    ) {
        ViewModelProvider.Factory factory = new TestMainViewModelFactory(refHolderRepository);
        return new ViewModelProvider(fragment, factory).get(TestMainViewModel.class);
    }
}

class TestMainViewModelFactory implements ViewModelProvider.Factory {

    private final RefHolderRepository refHolderRepository;

    public TestMainViewModelFactory(RefHolderRepository refHolderRepository) {
        this.refHolderRepository = refHolderRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new TestMainViewModel(refHolderRepository);
    }
}
