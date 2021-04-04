package meugeninua.android.handler.ui.fragments.test.second;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import meugeninua.android.handler.ui.fragments.common.vm.IViewModel;
import meugeninua.android.handler.ui.fragments.common.vm.SingleLiveEvent;
import meugeninua.android.handler.ui.fragments.test.second.binding.TestSecondBinding;
import meugeninua.android.handler.utils.async.AsyncHandler;

public class TestSecondViewModel extends ViewModel implements IViewModel, TestSecondBinding.Listener {

    private final AsyncHandler asyncHandler;
    private final SingleLiveEvent<Object> liveEvent;

    public TestSecondViewModel(AsyncHandler asyncHandler) {
        this.asyncHandler = asyncHandler;
        this.liveEvent = new SingleLiveEvent<>();
    }

    @NonNull
    @Override
    public LiveData<Object> getLiveEvent() {
        return liveEvent;
    }

    @Override
    public void onRequestApiClick() {

    }
}
