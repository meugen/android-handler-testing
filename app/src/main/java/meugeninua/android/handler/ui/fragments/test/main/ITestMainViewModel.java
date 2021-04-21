package meugeninua.android.handler.ui.fragments.test.main;

import androidx.annotation.NonNull;

import meugeninua.android.handler.ui.fragments.common.startstop.OnStartStopListener;
import meugeninua.android.handler.ui.fragments.common.vm.IViewModel;
import meugeninua.android.handler.ui.fragments.test.main.binding.TestMainBinding;

public interface ITestMainViewModel extends IViewModel,
    TestMainBinding.Listener, OnStartStopListener {

    void onRefreshRef(@NonNull String ref);
    void onMoveForward();
}
