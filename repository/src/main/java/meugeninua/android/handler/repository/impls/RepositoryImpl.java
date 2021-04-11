package meugeninua.android.handler.repository.impls;

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
    public Callable<String> slowRest() {
        return new SlowRestCallable(api);
    }
}

class SlowRestCallable implements Callable<String> {

    private final Api api;

    public SlowRestCallable(Api api) {
        this.api = api;
    }

    @Override
    public String call() throws Exception {
        return Objects.requireNonNull(api.slowRest().execute().body());
    }
}