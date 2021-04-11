package meugeninua.android.handler.async.executors;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class HandlerExecutors {

    private static final Object LOCK = new Object();

    private static Executor EXECUTOR;

    @NonNull
    public static Executor getExecutor() {
        if (EXECUTOR == null) {
            synchronized (LOCK) {
                if (EXECUTOR == null) {
                    EXECUTOR = Executors.newCachedThreadPool();
                }
            }
        }
        return EXECUTOR;
    }

    @VisibleForTesting
    static void setExecutor(Executor executor) {
        synchronized (LOCK) {
            assert EXECUTOR == null;
            EXECUTOR = executor;
        }
    }
}
