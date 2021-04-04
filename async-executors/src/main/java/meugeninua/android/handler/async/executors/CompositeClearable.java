package meugeninua.android.handler.async.executors;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import meugeninua.android.handler.utils.async.Clearable;

public class CompositeClearable implements Clearable {

    private final AtomicReference<List<Clearable>> clearables = new AtomicReference<>(
        new ArrayList<>()
    );

    public void add(@NonNull Clearable clearable) {
        clearables.get().add(Objects.requireNonNull(clearable));
    }

    @Override
    public void clear() {
        List<Clearable> items = clearables.getAndSet(Collections.emptyList());
        for (Clearable item : items) {
            item.clear();
        }
    }
}
