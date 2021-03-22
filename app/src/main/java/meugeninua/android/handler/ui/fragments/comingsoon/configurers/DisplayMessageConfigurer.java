package meugeninua.android.handler.ui.fragments.comingsoon.configurers;

import meugeninua.android.handler.R;
import meugeninua.android.handler.ui.fragments.common.actions.BindingAction;
import meugeninua.android.handler.ui.fragments.common.binding.Binding;
import meugeninua.android.handler.ui.fragments.common.startstop.BaseStartStopConfigurer;
import meugeninua.android.handler.ui.fragments.common.startstop.StartStopConfigurer;
import meugeninua.android.handler.ui.fragments.common.vm.SingleLiveEvent;

public class DisplayMessageConfigurer extends BaseStartStopConfigurer {

    private final String message;

    public DisplayMessageConfigurer(StartStopConfigurer baseConfigurer, String message) {
        super(baseConfigurer);
        this.message = message;
    }

    @Override
    public void onAttachLiveEvent(SingleLiveEvent<Object> liveEvent) {
        super.onAttachLiveEvent(liveEvent);
        liveEvent.setValue(new DisplayMessageAction(message));
    }
}

class DisplayMessageAction implements BindingAction {

    private final String message;

    public DisplayMessageAction(String message) {
        this.message = message;
    }

    @Override
    public void onAction(Binding binding) {
        binding.setText(R.id.message, message);
    }
}
