package meugeninua.android.handler.ui.fragments.test.first;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import meugeninua.android.handler.ui.fragments.common.vm.IViewModel;
import meugeninua.android.handler.ui.fragments.common.vm.SingleLiveEvent;
import meugeninua.android.handler.ui.fragments.test.first.binding.TestFirstBinding;

public class TestFirstViewModel extends ViewModel implements IViewModel, TestFirstBinding.Listener {

    private final SingleLiveEvent<Object> liveEvent = new SingleLiveEvent<>();

    @NonNull
    @Override
    public LiveData<Object> getLiveEvent() {
        return liveEvent;
    }

    @Override
    public void onMoveClick() {

    }
}
