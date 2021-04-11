package meugeninua.android.handler.ui.fragments.test.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import meugeninua.android.handler.R;
import meugeninua.android.handler.ui.fragments.common.actions.FragmentAction;
import meugeninua.android.handler.ui.fragments.common.startstop.OnStartStopListener;
import meugeninua.android.handler.ui.fragments.common.startstop.StartStopConfigurer;
import meugeninua.android.handler.ui.fragments.common.vm.IViewModel;
import meugeninua.android.handler.ui.fragments.common.vm.SingleLiveEvent;
import meugeninua.android.handler.ui.fragments.test.main.binding.TestMainBinding;
import meugeninua.android.handler.ui.fragments.test.main.configurers.DisplayFirstConfigurer;
import meugeninua.android.handler.ui.fragments.test.second.TestSecondFragment;

public class TestMainViewModel extends ViewModel implements IViewModel,
    TestMainBinding.Listener, OnStartStopListener {

    private final SingleLiveEvent<Object> liveEvent = new SingleLiveEvent<>();
    private final StartStopConfigurer configurer;

    public TestMainViewModel() {
        StartStopConfigurer configurer = StartStopConfigurer.EMPTY;
        configurer = new DisplayFirstConfigurer(configurer);
        this.configurer = configurer;
    }

    @NonNull
    @Override
    public LiveData<Object> getLiveEvent() {
        return liveEvent;
    }

    public void onMoveForward() {
        liveEvent.setValue(new NavigateForwardAction());
    }

    @Override
    public void onBackClick() {
        liveEvent.setValue(new TestNavigateBackAction());
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

class TestNavigateBackAction implements FragmentAction {

    @Override
    public void onAction(Fragment fragment) {
        FragmentManager fragmentManager = fragment.getChildFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
        }
    }
}

class NavigateForwardAction implements FragmentAction {

    @Override
    public void onAction(Fragment fragment) {
        FragmentManager manager = fragment.getChildFragmentManager();
        manager.beginTransaction()
            .replace(R.id.fragment_container, new TestSecondFragment())
            .addToBackStack(null)
            .commit();
    }
}
