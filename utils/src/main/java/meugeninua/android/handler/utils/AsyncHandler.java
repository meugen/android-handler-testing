package meugeninua.android.handler.utils;

import androidx.annotation.NonNull;

import java.util.concurrent.Callable;

public interface AsyncHandler {

    <T> void runAsync(@NonNull Callable<T> callable, @NonNull Callbacks<T> callbacks);
}