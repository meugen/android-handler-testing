package meugeninua.android.handler.ui.fragments.test.main.configurers;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import meugeninua.android.handler.R;
import meugeninua.android.handler.ui.fragments.common.actions.BindingAction;
import meugeninua.android.handler.ui.fragments.common.binding.Binding;
import meugeninua.android.handler.ui.fragments.common.startstop.BaseStartStopConfigurer;
import meugeninua.android.handler.ui.fragments.common.startstop.StartStopConfigurer;
import meugeninua.android.handler.ui.fragments.common.vm.SingleLiveEvent;

public class DisplayRefConfigurer extends BaseStartStopConfigurer {

    private final LiveData<String> refData;

    public DisplayRefConfigurer(
        @NonNull StartStopConfigurer baseConfigurer,
        LiveData<String> refData
    ) {
        super(baseConfigurer);
        this.refData = refData;
    }

    @Override
    public void onAttachLiveEvent(SingleLiveEvent<Object> liveEvent) {
        super.onAttachLiveEvent(liveEvent);
        liveEvent.addSource(refData, ref -> {
            liveEvent.setValue(new DisplayRefAction(ref));
        });
    }

    @Override
    public void onDetachLiveEvent(SingleLiveEvent<Object> liveEvent) {
        super.onDetachLiveEvent(liveEvent);
        liveEvent.removeSource(refData);
    }
}

class DisplayRefAction implements BindingAction {

    private final String ref;

    public DisplayRefAction(String ref) {
        this.ref = ref;
    }

    @Override
    public void onAction(Binding binding) {
        Binding.Utils.setText(binding, R.id.view_model_label, ref);
    }
}