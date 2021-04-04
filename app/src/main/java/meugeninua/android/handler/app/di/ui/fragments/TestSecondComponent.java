package meugeninua.android.handler.app.di.ui.fragments;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
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
        AsyncHandler asyncHandler
    ) {
        ViewModelProvider.Factory factory = new TestSecondViewModelFactory(asyncHandler);
        return new ViewModelProvider(fragment, factory).get(TestSecondViewModel.class);
    }
}

class TestSecondViewModelFactory implements ViewModelProvider.Factory {

    private final AsyncHandler asyncHandler;

    public TestSecondViewModelFactory(AsyncHandler asyncHandler) {
        this.asyncHandler = asyncHandler;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new TestSecondViewModel(asyncHandler);
    }
}