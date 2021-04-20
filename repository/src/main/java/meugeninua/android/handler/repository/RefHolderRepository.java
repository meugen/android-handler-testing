package meugeninua.android.handler.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface RefHolderRepository {

    @Nullable
    Object getRef();

    void setRef(@NonNull Object ref);
}
