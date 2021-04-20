package meugeninua.android.handler.ui.fragments.test.second;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import java.time.Duration;

import meugeninua.android.handler.repository.RefHolderRepository;
import meugeninua.android.handler.repository.Repository;
import meugeninua.android.handler.ui.fragments.common.startstop.OnStartStopListener;
import meugeninua.android.handler.ui.fragments.common.startstop.StartStopConfigurer;
import meugeninua.android.handler.ui.fragments.common.vm.IViewModel;
import meugeninua.android.handler.ui.fragments.common.vm.SingleLiveEvent;
import meugeninua.android.handler.ui.fragments.test.second.binding.TestSecondBinding;
import meugeninua.android.handler.ui.fragments.test.second.configurers.DisplayResultConfigurer;
import meugeninua.android.handler.utils.async.AsyncHandler;
import meugeninua.android.handler.utils.async.Callbacks;
import timber.log.Timber;

public class TestSecondViewModel extends ViewModel implements IViewModel, TestSecondBinding.Listener, OnStartStopListener {

    private static final String KEY_RESULT = "result";

    private final AsyncHandler asyncHandler;
    private final Repository repository;
    private final SavedStateHandle handle;

    private final SingleLiveEvent<Object> liveEvent;
    private final StartStopConfigurer configurer;

    private static StartStopConfigurer buildConfigurer(
        SavedStateHandle handle
    ) {
        StartStopConfigurer configurer = StartStopConfigurer.EMPTY;
        configurer = new DisplayResultConfigurer(
            configurer, handle.getLiveData(KEY_RESULT)
        );
        return configurer;
    }

    public TestSecondViewModel(
        AsyncHandler asyncHandler,
        Repository repository,
        RefHolderRepository refHolderRepository,
        SavedStateHandle handle
    ) {
        refHolderRepository.setRef(this);

        this.asyncHandler = asyncHandler;
        this.repository = repository;
        this.handle = handle;

        this.liveEvent = new SingleLiveEvent<>();
        this.configurer = buildConfigurer(handle);
    }

    @NonNull
    @Override
    public LiveData<Object> getLiveEvent() {
        return liveEvent;
    }

    @Override
    public void onRequestApiClick() {
        Callbacks<String> callbacks = new Callbacks.Builder<String>()
            .withOnComplete(v -> handle.set(KEY_RESULT, v))
            .withOnError(Timber::e)
            .build();
        asyncHandler.runAsync(repository.slowRest(Duration.ofSeconds(5)), callbacks);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Timber.d("onCleared() method called");
        asyncHandler.clear();
    }

    @Override
    public void onStart() {
        configurer.onAttachLiveEvent(liveEvent);
    }

    @Override
    public void onStop() {
        configurer.onDetachLiveEvent(liveEvent);
    }
}
