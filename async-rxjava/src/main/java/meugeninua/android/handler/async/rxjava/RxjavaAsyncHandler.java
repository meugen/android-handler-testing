package meugeninua.android.handler.async.rxjava;

import androidx.annotation.NonNull;

import java.util.concurrent.Callable;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import meugeninua.android.handler.utils.async.AsyncHandler;
import meugeninua.android.handler.utils.async.Callbacks;

public class RxjavaAsyncHandler implements AsyncHandler {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public <T> void runAsync(
        @NonNull Callable<T> callable,
        @NonNull Callbacks<T> callbacks
    ) {
        Disposable disposable = Single.fromCallable(callable)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe(d -> callbacks.onStart())
            .doFinally(callbacks::onFinish)
            .subscribe(callbacks::onComplete, callbacks::onError);
        compositeDisposable.add(disposable);
    }

    @Override
    public void clear() {
        compositeDisposable.dispose();
    }
}
