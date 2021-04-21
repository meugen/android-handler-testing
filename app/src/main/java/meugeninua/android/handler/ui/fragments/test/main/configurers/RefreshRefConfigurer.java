package meugeninua.android.handler.ui.fragments.test.main.configurers;

import androidx.annotation.NonNull;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import meugeninua.android.handler.repository.RefHolderRepository;
import meugeninua.android.handler.ui.fragments.common.startstop.BaseStartStopConfigurer;
import meugeninua.android.handler.ui.fragments.common.startstop.StartStopConfigurer;
import meugeninua.android.handler.ui.fragments.common.vm.SingleLiveEvent;
import meugeninua.android.handler.ui.fragments.test.main.ITestMainViewModel;
import meugeninua.android.handler.ui.fragments.test.main.actions.TestMainViewModelAction;

public class RefreshRefConfigurer extends BaseStartStopConfigurer {

    private static final Object SYNC = new Object();
    private static ExecutorService EXECUTOR;

    private static ExecutorService getExecutor() {
        if (EXECUTOR == null) {
            synchronized (SYNC) {
                if (EXECUTOR == null) {
                    EXECUTOR = Executors.newSingleThreadExecutor();
                }
            }
        }
        return EXECUTOR;
    }

    private final RefHolderRepository refHolderRepository;
    private Future<?> future;

    public RefreshRefConfigurer(
        @NonNull StartStopConfigurer baseConfigurer,
        RefHolderRepository refHolderRepository
    ) {
        super(baseConfigurer);
        this.refHolderRepository = refHolderRepository;
    }

    @Override
    public void onAttachLiveEvent(SingleLiveEvent<Object> liveEvent) {
        super.onAttachLiveEvent(liveEvent);
        future = getExecutor().submit(new RefreshRefRunnable(liveEvent, refHolderRepository));
    }

    @Override
    public void onDetachLiveEvent(SingleLiveEvent<Object> liveEvent) {
        super.onDetachLiveEvent(liveEvent);
        future.cancel(true);
        future = null;
    }
}

class RefreshRefRunnable implements Runnable {

    private final SingleLiveEvent<Object> liveEvent;
    private final RefHolderRepository refHolderRepository;

    public RefreshRefRunnable(
        SingleLiveEvent<Object> liveEvent,
        RefHolderRepository refHolderRepository
    ) {
        this.liveEvent = liveEvent;
        this.refHolderRepository = refHolderRepository;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(100L);
                liveEvent.postValue(new RefreshRefAction(
                    Objects.toString(refHolderRepository.getRef())
                ));
            }
        } catch (InterruptedException e) {}
    }
}

class RefreshRefAction implements TestMainViewModelAction {

    private final String ref;

    public RefreshRefAction(String ref) {
        this.ref = ref;
    }

    @Override
    public void onAction(ITestMainViewModel viewModel) {
        viewModel.onRefreshRef(ref);
    }
}

