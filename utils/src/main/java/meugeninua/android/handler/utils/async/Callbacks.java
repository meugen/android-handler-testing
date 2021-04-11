package meugeninua.android.handler.utils.async;

import androidx.annotation.NonNull;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import meugeninua.android.handler.utils.functions.Action;
import meugeninua.android.handler.utils.functions.Consumer;
import meugeninua.android.handler.utils.functions.Functions;

public class Callbacks<T> implements Clearable {

    private final AtomicReference<Consumer<T>> onComplete;
    private final AtomicReference<Consumer<Throwable>> onError;
    private final AtomicReference<Action> onStart;
    private final AtomicReference<Action> onFinish;

    private Callbacks(
        @NonNull Consumer<T> onComplete,
        @NonNull Consumer<Throwable> onError,
        @NonNull Action onStart,
        @NonNull Action onFinish
    ) {
        this.onComplete = new AtomicReference<>(onComplete);
        this.onError = new AtomicReference<>(onError);
        this.onStart = new AtomicReference<>(onStart);
        this.onFinish = new AtomicReference<>(onFinish);
    }

    public void onComplete(T data) {
        onComplete.get().invoke(data);
    }

    public void onError(Throwable error) {
        onError.get().invoke(error);
    }

    public void onStart() {
        onStart.get().invoke();
    }

    public void onFinish() {
        onFinish.get().invoke();
    }

    @Override
    public void clear() {
        onComplete.set(Functions.emptyConsumer());
        onError.set(Functions.emptyConsumer());
        onStart.set(Functions.emptyAction());
        onFinish.set(Functions.emptyAction());
    }

    public static class Builder<T> {

        private Consumer<T> onComplete = Functions.emptyConsumer();
        private Consumer<Throwable> onError = Functions.emptyConsumer();
        private Action onStart = Functions.emptyAction();
        private Action onFinish = Functions.emptyAction();

        public Builder<T> withOnComplete(@NonNull Consumer<T> onComplete) {
            this.onComplete = Objects.requireNonNull(onComplete);
            return this;
        }

        public Builder<T> withOnError(@NonNull Consumer<Throwable> onError) {
            this.onError = Objects.requireNonNull(onError);
            return this;
        }

        public Builder<T> withOnStart(@NonNull Action onStart) {
            this.onStart = Objects.requireNonNull(onStart);
            return this;
        }

        public Builder<T> withOnFinish(@NonNull Action onFinish) {
            this.onFinish = Objects.requireNonNull(onFinish);
            return this;
        }

        public Callbacks<T> build() {
            return new Callbacks<>(
                onComplete, onError, onStart, onFinish
            );
        }
    }
}
