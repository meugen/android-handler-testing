package meugeninua.android.handler.ui.fragments.common.vm;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

public interface IViewModel {

    @NonNull
    LiveData<Object> getLiveEvent();
}
