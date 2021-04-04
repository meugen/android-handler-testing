package meugeninua.android.handler.ui.fragments.common.startstop;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;

import meugeninua.android.handler.ui.fragments.common.vm.SingleLiveEvent;

public abstract class BaseStartStopConfigurer implements StartStopConfigurer {

    private final StartStopConfigurer baseConfigurer;

    public BaseStartStopConfigurer(@NonNull StartStopConfigurer baseConfigurer) {
        this.baseConfigurer = baseConfigurer;
    }

    @CallSuper
    @Override
    public void onAttachLiveEvent(SingleLiveEvent<Object> liveEvent) {
        baseConfigurer.onAttachLiveEvent(liveEvent);
    }

    @CallSuper
    @Override
    public void onDetachLiveEvent(SingleLiveEvent<Object> liveEvent) {
        baseConfigurer.onDetachLiveEvent(liveEvent);
    }
}
