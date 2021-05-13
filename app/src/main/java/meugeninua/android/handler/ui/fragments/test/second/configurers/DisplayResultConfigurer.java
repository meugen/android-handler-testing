package meugeninua.android.handler.ui.fragments.test.second.configurers;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import meugeninua.android.handler.R;
import meugeninua.android.handler.ui.fragments.common.actions.BindingAction;
import meugeninua.android.handler.ui.fragments.common.binding.Binding;
import meugeninua.android.handler.ui.fragments.common.startstop.BaseStartStopConfigurer;
import meugeninua.android.handler.ui.fragments.common.startstop.StartStopConfigurer;
import meugeninua.android.handler.ui.fragments.common.vm.SingleLiveEvent;

public class DisplayResultConfigurer extends BaseStartStopConfigurer {

    private final LiveData<String> resultData;

    public DisplayResultConfigurer(
        @NonNull StartStopConfigurer baseConfigurer,
        @NonNull LiveData<String> resultData
    ) {
        super(baseConfigurer);
        this.resultData = resultData;
    }

    @Override
    public void onAttachLiveEvent(SingleLiveEvent<Object> liveEvent) {
        super.onAttachLiveEvent(liveEvent);
        liveEvent.addSource(resultData, v -> {
            liveEvent.setValue(new DisplayResultAction(v));
        });
    }

    @Override
    public void onDetachLiveEvent(SingleLiveEvent<Object> liveEvent) {
        super.onDetachLiveEvent(liveEvent);
        liveEvent.removeSource(resultData);
    }
}

class DisplayResultAction implements BindingAction {

    private final CharSequence result;

    public DisplayResultAction(CharSequence result) {
        this.result = result;
    }

    @Override
    public void onAction(Binding binding) {
        binding.setText(R.id.text_result, result);
    }
}
