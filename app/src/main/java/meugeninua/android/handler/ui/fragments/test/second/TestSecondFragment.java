package meugeninua.android.handler.ui.fragments.test.second;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import javax.inject.Inject;

import meugeninua.android.handler.R;
import meugeninua.android.handler.ui.fragments.common.BaseFragment;
import meugeninua.android.handler.ui.fragments.common.vm.IViewModel;
import meugeninua.android.handler.ui.fragments.test.second.binding.TestSecondBinding;

public class TestSecondFragment extends BaseFragment {

    @Inject
    public ITestSecondViewModel viewModel;

    public TestSecondFragment() {
        super(R.layout.fragment_test_second);
    }

    @NonNull
    @Override
    protected IViewModel viewModel() {
        return viewModel;
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        TestSecondBinding.setupListeners(binding, viewModel);
    }
}
