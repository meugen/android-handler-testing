package meugeninua.android.handler.ui.fragments.test.main;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import javax.inject.Inject;

import meugeninua.android.handler.R;
import meugeninua.android.handler.ui.fragments.common.BaseFragment;
import meugeninua.android.handler.ui.fragments.common.vm.IViewModel;

public class TestMainFragment extends BaseFragment {

    @Inject
    public TestMainViewModel viewModel;

    public TestMainFragment() {
        super(R.layout.fragment_test_main);
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

    public void moveForward() {
        viewModel.onMoveForward();
    }
}
