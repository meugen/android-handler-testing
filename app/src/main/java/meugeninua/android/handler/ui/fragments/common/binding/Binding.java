package meugeninua.android.handler.ui.fragments.common.binding;

import android.util.SparseArray;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

import java.util.Objects;

public class Binding implements LifecycleObserver {

    private View rootView;
    private final SparseArray<View> childrenViews;

    public Binding() { this(null); }

    public Binding(@Nullable View view) {
        this.rootView = view;
        this.childrenViews = new SparseArray<>();
    }

    public void onAttachView(@NonNull LifecycleOwner owner, @NonNull View view) {
        this.rootView = Objects.requireNonNull(view);
        owner.getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDetachView(@NonNull LifecycleOwner owner) {
        this.rootView = null;
        this.childrenViews.clear();

        owner.getLifecycle().removeObserver(this);
    }

    @Nullable
    private View find(@IdRes int viewId) {
        if (rootView == null) {
            return null;
        }
        View result = childrenViews.get(viewId);
        if (result != null) {
            return result;
        }
        result = rootView.findViewById(viewId);
        if (result != null) {
            childrenViews.put(viewId, result);
        }
        return result;
    }

    @NonNull
    public <V extends View> V get(@IdRes int viewId) {
        return (V) Objects.requireNonNull(find(viewId));
    }

    public boolean has(@IdRes int viewId) {
        return find(viewId) != null;
    }
}
