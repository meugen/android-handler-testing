package meugeninua.android.handler.ui.fragments.comingsoon;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import javax.inject.Inject;

import meugeninua.android.handler.R;
import meugeninua.android.handler.ui.fragments.common.BaseFragment;
import meugeninua.android.handler.ui.fragments.common.vm.IViewModel;

public class ComingSoonFragment extends BaseFragment {

    @Inject
    public ComingSoonViewModel viewModel;

    public ComingSoonFragment() {
        super(R.layout.fragment_coming_soon);
    }

    @NonNull
    @Override
    protected IViewModel viewModel() {
        return viewModel;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.onAttachView(getViewLifecycleOwner(), view);
    }
}
