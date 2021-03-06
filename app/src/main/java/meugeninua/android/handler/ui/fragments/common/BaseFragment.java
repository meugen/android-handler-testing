package meugeninua.android.handler.ui.fragments.common;

import android.os.Bundle;
import android.view.View;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

import meugeninua.android.handler.app.HandlerApp;
import meugeninua.android.handler.ui.fragments.common.actions.ActivityAction;
import meugeninua.android.handler.ui.fragments.common.actions.BindingAction;
import meugeninua.android.handler.ui.fragments.common.actions.ContextAction;
import meugeninua.android.handler.ui.fragments.common.actions.FragmentAction;
import meugeninua.android.handler.ui.fragments.common.actions.ViewModelAction;
import meugeninua.android.handler.ui.fragments.common.binding.Binding;
import meugeninua.android.handler.ui.fragments.common.binding.OnBackClickListener;
import meugeninua.android.handler.ui.fragments.common.startstop.OnStartStopListener;
import meugeninua.android.handler.ui.fragments.common.vm.IViewModel;

public abstract class BaseFragment extends Fragment {

    protected final Binding binding = new Binding();

    public BaseFragment(@LayoutRes int contentLayoutId) {
        super(contentLayoutId);
    }

    @NonNull
    protected abstract IViewModel viewModel();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HandlerApp.inject(this, this);
    }

    private void onEvent(@Nullable Object event) {
        if (event instanceof BindingAction) {
            ((BindingAction) event).onAction(binding);
        } else if (event instanceof ContextAction) {
            ((ContextAction) event).onAction(requireContext());
        } else if (event instanceof FragmentAction) {
            ((FragmentAction) event).onAction(this);
        } else if (event instanceof ActivityAction) {
            ((ActivityAction) event).onAction(requireActivity());
        } else if (event instanceof ViewModelAction) {
            onViewModelEvent((ViewModelAction<?>) event);
        }
    }

    protected void onViewModelEvent(ViewModelAction<?> event) { }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.onAttachView(getViewLifecycleOwner(), view);

        IViewModel viewModel = viewModel();
        setupStartStopListener(viewModel);
        setupBackClickListener(viewModel);
        viewModel.getLiveEvent().observe(getViewLifecycleOwner(), this::onEvent);
    }

    private void setupStartStopListener(Object listener) {
        if (listener instanceof OnStartStopListener) {
            getViewLifecycleOwner().getLifecycle().addObserver(
                new StartStopObserver((OnStartStopListener) listener)
            );
        }
    }

    private void setupBackClickListener(Object listener) {
        if (listener instanceof OnBackClickListener) {
            requireActivity().getOnBackPressedDispatcher().addCallback(
                getViewLifecycleOwner(), new BackPressedCallback((OnBackClickListener) listener)
            );
        }
    }
}

class StartStopObserver implements LifecycleEventObserver {

    private final OnStartStopListener listener;

    public StartStopObserver(@NonNull OnStartStopListener listener) {
        this.listener = listener;
    }

    @Override
    public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_START) {
            listener.onStart();
        } else if (event == Lifecycle.Event.ON_STOP) {
            listener.onStop();
        }
    }
}

class BackPressedCallback extends OnBackPressedCallback {

    private final OnBackClickListener listener;

    public BackPressedCallback(OnBackClickListener listener) {
        super(true);
        this.listener = listener;
    }

    @Override
    public void handleOnBackPressed() {
        listener.onBackClick();
    }
}