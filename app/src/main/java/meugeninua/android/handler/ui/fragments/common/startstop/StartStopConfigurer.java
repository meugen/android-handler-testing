package meugeninua.android.handler.ui.fragments.common.startstop;

import meugeninua.android.handler.ui.fragments.common.vm.SingleLiveEvent;

public interface StartStopConfigurer {

    StartStopConfigurer EMPTY = new StartStopConfigurer() {
        @Override
        public void onAttachLiveEvent(SingleLiveEvent<Object> liveEvent) { }

        @Override
        public void onDetachLiveEvent(SingleLiveEvent<Object> liveEvent) { }
    };

    void onAttachLiveEvent(SingleLiveEvent<Object> liveEvent);
    void onDetachLiveEvent(SingleLiveEvent<Object> liveEvent);
}
