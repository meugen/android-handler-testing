package meugeninua.android.handler.ui.fragments.countries;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import meugeninua.android.handler.ui.fragments.common.vm.SingleLiveEvent;

public class CountriesViewModel extends ViewModel implements ICountriesViewModel {

    private final SingleLiveEvent<Object> liveEvent = new SingleLiveEvent<>();

    @NonNull
    @Override
    public LiveData<Object> getLiveEvent() {
        return liveEvent;
    }
}
