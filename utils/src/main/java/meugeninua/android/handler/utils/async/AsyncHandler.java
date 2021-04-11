package meugeninua.android.handler.utils.async;

import androidx.annotation.NonNull;

import java.util.concurrent.Callable;

public interface AsyncHandler extends Clearable {

    <T> void runAsync(@NonNull Callable<T> callable, @NonNull Callbacks<T> callbacks);
}