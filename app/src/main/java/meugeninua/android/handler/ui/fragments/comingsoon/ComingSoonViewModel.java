package meugeninua.android.handler.ui.fragments.comingsoon;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import meugeninua.android.handler.ui.fragments.comingsoon.configurers.DisplayMessageConfigurer;
import meugeninua.android.handler.ui.fragments.common.startstop.OnStartStopListener;
import meugeninua.android.handler.ui.fragments.common.startstop.StartStopConfigurer;
import meugeninua.android.handler.ui.fragments.common.vm.IViewModel;
import meugeninua.android.handler.ui.fragments.common.vm.SingleLiveEvent;

public class ComingSoonViewModel extends ViewModel implements IViewModel, OnStartStopListener {

    private final SingleLiveEvent<Object> liveEvent = new SingleLiveEvent<>();
    private final StartStopConfigurer configurer;

    public ComingSoonViewModel(@NonNull Bundle arguments) {
        ComingSoonFragmentArgs args = ComingSoonFragmentArgs.fromBundle(arguments);

        StartStopConfigurer configurer = StartStopConfigurer.EMPTY;
        configurer = new DisplayMessageConfigurer(
                configurer, args.getMessage()
        );
        this.configurer = configurer;
    }

    @Override
    public LiveData<Object> getLiveData() {
        return liveEvent;
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
