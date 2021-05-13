package meugeninua.android.handler.ui.fragments.common.binding;

import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
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

    @NonNull
    public View getView() {
        return Objects.requireNonNull(rootView);
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

    public static class Utils {

        private final Binding binding;

        public Utils(@NonNull Binding binding) {
            this.binding = binding;
        }

        public void setOnClickListener(
            @IdRes int viewId,
            View.OnClickListener listener
        ) {
            View view = binding.get(viewId);
            view.setOnClickListener(listener);
        }

        public void setText(
            @IdRes int viewId,
            @StringRes int textId
        ) {
            CharSequence text = binding.getView().getContext().getText(textId);
            setText(viewId, text);
        }

        public void setText(
            @IdRes int viewId,
            @Nullable CharSequence text
        ) {
            TextView textView = binding.get(viewId);
            textView.setText(text);
        }
    }
}
