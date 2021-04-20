package meugeninua.android.handler.app.di.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.savedstate.SavedStateRegistryOwner;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import meugeninua.android.handler.repository.RefHolderRepository;
import meugeninua.android.handler.repository.Repository;
import meugeninua.android.handler.ui.fragments.test.second.TestSecondFragment;
import meugeninua.android.handler.ui.fragments.test.second.TestSecondViewModel;
import meugeninua.android.handler.utils.async.AsyncHandler;

@Module
public interface TestSecondComponent {

    @ContributesAndroidInjector(modules = TestSecondModule.class)
    TestSecondFragment bindFragment();
}

@Module
class TestSecondModule {

    @Provides
    public static TestSecondViewModel viewModel(
        TestSecondFragment fragment,
        Repository repository,
        RefHolderRepository refHolderRepository,
        AsyncHandler asyncHandler
    ) {
        ViewModelProvider.Factory factory = new TestSecondViewModelFactory(
            fragment, repository, refHolderRepository, asyncHandler
        );
        return new ViewModelProvider(fragment, factory).get(TestSecondViewModel.class);
    }
}

class TestSecondViewModelFactory extends AbstractSavedStateViewModelFactory {

    private final Repository repository;
    private final RefHolderRepository refHolderRepository;
    private final AsyncHandler asyncHandler;

    public TestSecondViewModelFactory(
        SavedStateRegistryOwner registryOwner,
        Repository repository,
        RefHolderRepository refHolderRepository,
        AsyncHandler asyncHandler
    ) {
        super(registryOwner, Bundle.EMPTY);
        this.repository = repository;
        this.refHolderRepository = refHolderRepository;
        this.asyncHandler = asyncHandler;
    }

    @NonNull
    @Override
    protected <T extends ViewModel> T create(
        @NonNull String key,
        @NonNull Class<T> modelClass,
        @NonNull SavedStateHandle handle
    ) {
        return (T) new TestSecondViewModel(asyncHandler, repository, refHolderRepository, handle);
    }
}