package meugeninua.android.handler.async.executors;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

import meugeninua.android.handler.utils.async.AsyncHandler;
import meugeninua.android.handler.utils.async.Callbacks;

public class ExecutorAsyncHandler implements AsyncHandler {

    private final CompositeClearable compositeClearable = new CompositeClearable();
    private final Executor mainExecutor;

    public ExecutorAsyncHandler(@NonNull Context context) {
        this.mainExecutor = ContextCompat.getMainExecutor(context);
    }

    @Override
    public <T> void runAsync(
        @NonNull Callable<T> callable,
        @NonNull Callbacks<T> callbacks
    ) {
        compositeClearable.add(callbacks);
        HandlerExecutors.getExecutor().execute(
            new AsyncRunnable<>(mainExecutor, callbacks, callable)
        );
    }

    @Override
    public void clear() {
        compositeClearable.clear();
    }
}

class AsyncRunnable<T> implements Runnable {

    private final Executor mainExecutor;
    private final Callbacks<T> callbacks;
    private final Callable<T> callable;

    public AsyncRunnable(
        @NonNull Executor mainExecutor,
        @NonNull Callbacks<T> callbacks,
        @NonNull Callable<T> callable
    ) {
        this.mainExecutor = mainExecutor;
        this.callbacks = callbacks;
        this.callable = callable;
    }

    @Override
    public void run() {
        try {
            mainExecutor.execute(callbacks::onStart);
            T data = callable.call();
            mainExecutor.execute(() -> callbacks.onComplete(data));
        } catch (Throwable error) {
            mainExecutor.execute(() -> callbacks.onError(error));
        } finally {
            mainExecutor.execute(callbacks::onFinish);
        }
    }
}