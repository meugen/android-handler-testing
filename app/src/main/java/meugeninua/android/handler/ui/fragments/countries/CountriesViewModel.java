package meugeninua.android.handler.ui.fragments.countries;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import meugeninua.android.handler.ui.fragments.common.vm.IViewModel;
import meugeninua.android.handler.ui.fragments.common.vm.SingleLiveEvent;

public class CountriesViewModel extends ViewModel implements IViewModel {

    private final SingleLiveEvent<Object> liveEvent = new SingleLiveEvent<>();

    @Override
    public LiveData<Object> getLiveEvent() {
        return liveEvent;
    }
}
