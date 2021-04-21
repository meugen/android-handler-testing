package meugeninua.android.handler.repository;

import java.time.Duration;
import java.util.concurrent.Callable;

public interface Repository {

    Callable<String> slowRest(Duration duration);
}