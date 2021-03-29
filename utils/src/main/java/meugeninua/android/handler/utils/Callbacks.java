package meugeninua.android.handler.utils;

import androidx.annotation.NonNull;

import java.util.Objects;

import meugeninua.android.handler.utils.functions.Action;
import meugeninua.android.handler.utils.functions.Consumer;

public class Callbacks<T> {

    private final Consumer<T> onComplete;
    private final Consumer<Throwable> onError;
    private final Action onStart;
    private final Action onFinish;

    private Callbacks(
            @NonNull Consumer<T> onComplete,
            @NonNull Consumer<Throwable> onError,
            @NonNull Action onStart,
            @NonNull Action onFinish
    ) {
        this.onComplete = onComplete;
        this.onError = onError;
        this.onStart = onStart;
        this.onFinish = onFinish;
    }

    public void onComplete(T data) {
        onComplete.invoke(data);
    }

    public void onError(Throwable error) {
        onError.invoke(error);
    }

    public void onStart() {
        onStart.invoke();
    }

    public void onFinish() {
        onFinish.invoke();
    }

    public static class Builder<T> {

        private Consumer<T> onComplete = null;
        private Consumer<Throwable> onError = null;
        private Action onStart = null;
        private Action onFinish = null;

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
                    onComplete == null ? v -> { } : onComplete,
                    onError == null ? t -> { } : onError,
                    onStart == null ? () -> { } : onStart,
                    onFinish == null ? () -> { } : onFinish
            );
        }
    }
}
