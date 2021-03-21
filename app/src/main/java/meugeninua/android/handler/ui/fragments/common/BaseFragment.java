package meugeninua.android.handler.ui.fragments.common;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import meugeninua.android.handler.ui.fragments.common.binding.Binding;

public class BaseFragment extends Fragment {

    private final Binding binding = new Binding();

    public BaseFragment(@LayoutRes int contentLayoutId) {
        super(contentLayoutId);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.onAttachView(getViewLifecycleOwner(), view);
    }
}
