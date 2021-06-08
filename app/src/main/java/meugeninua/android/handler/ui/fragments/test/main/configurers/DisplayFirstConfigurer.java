package meugeninua.android.handler.ui.fragments.test.main.configurers;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import meugeninua.android.handler.R;
import meugeninua.android.handler.ui.fragments.common.actions.FragmentAction;
import meugeninua.android.handler.ui.fragments.common.startstop.BaseStartStopConfigurer;
import meugeninua.android.handler.ui.fragments.common.startstop.StartStopConfigurer;
import meugeninua.android.handler.ui.fragments.common.vm.SingleLiveEvent;
import meugeninua.android.handler.ui.fragments.test.first.TestFirstFragment;

public class DisplayFirstConfigurer extends BaseStartStopConfigurer {

    public DisplayFirstConfigurer(@NonNull StartStopConfigurer baseConfigurer) {
        super(baseConfigurer);
    }

    @Override
    public void onAttachLiveEvent(SingleLiveEvent<Object> liveEvent) {
        super.onAttachLiveEvent(liveEvent);
        liveEvent.setValue(new DisplayFirstAction());
    }
}

class DisplayFirstAction implements FragmentAction {

    @Override
    public void onAction(Fragment fragment) {
        FragmentManager fragmentManager = fragment.getChildFragmentManager();
        if (fragmentManager.findFragmentById(R.id.fragment_container) == null) {
            fragmentManager.beginTransaction()
                .add(R.id.fragment_container, new TestFirstFragment())
                .commit();
        }
    }
}