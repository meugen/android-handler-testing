package meugeninua.android.handler.repository.impls;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.ref.WeakReference;

import meugeninua.android.handler.repository.RefHolderRepository;

public class RefHolderRepositoryImpl implements RefHolderRepository {

    private WeakReference<Object> weakRef;

    @Nullable
    @Override
    public Object getRef() {
        return weakRef == null ? null : weakRef.get();
    }

    @Override
    public void setRef(@NonNull Object ref) {
        weakRef = new WeakReference<>(ref);
    }
}
