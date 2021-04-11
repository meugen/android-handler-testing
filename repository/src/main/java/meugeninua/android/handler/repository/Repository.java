package meugeninua.android.handler.repository;

import java.util.concurrent.Callable;

public interface Repository {

    Callable<String> slowRest();
}