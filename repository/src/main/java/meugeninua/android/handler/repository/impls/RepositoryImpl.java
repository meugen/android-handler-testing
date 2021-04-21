package meugeninua.android.handler.repository.impls;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.Callable;

import meugeninua.android.handler.repository.Repository;
import meugeninua.android.handler.repository.apis.Api;

public class RepositoryImpl implements Repository {

    private final Api api;

    public RepositoryImpl(Api api) {
        this.api = api;
    }

    @Override
    public Callable<String> slowRest(Duration duration) {
        return new SlowRestCallable(api, duration);
    }
}

class SlowRestCallable implements Callable<String> {

    private final Api api;
    private final Duration duration;

    public SlowRestCallable(Api api, Duration duration) {
        this.api = api;
        this.duration = duration;
    }

    @Override
    public String call() throws Exception {
        return Objects.requireNonNull(api.slowRest(duration.toString()).execute().body());
    }
}