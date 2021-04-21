package meugeninua.android.handler.ui.fragments.test.first;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import javax.inject.Inject;

import meugeninua.android.handler.R;
import meugeninua.android.handler.ui.fragments.common.BaseFragment;
import meugeninua.android.handler.ui.fragments.common.vm.IViewModel;
import meugeninua.android.handler.ui.fragments.test.first.binding.TestFirstBinding;

public class TestFirstFragment extends BaseFragment {

    @Inject
    public ITestFirstViewModel viewModel;

    public TestFirstFragment() {
        super(R.layout.fragment_test_first);
    }

    @NonNull
    @Override
    protected IViewModel viewModel() {
        return viewModel;
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        TestFirstBinding.setupListeners(binding, viewModel);
    }
}
