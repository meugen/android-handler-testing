package meugeninua.android.handler.utils;

import java.util.concurrent.Callable;

public interface AsyncHandler {

    <T> void runAsync(Callable<T> callable, Callbacks<T> callbacks);
}