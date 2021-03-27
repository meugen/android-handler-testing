package meugeninua.android.handler.ui.fragments.cities;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import javax.inject.Inject;

import meugeninua.android.handler.R;
import meugeninua.android.handler.ui.fragments.common.BaseFragment;
import meugeninua.android.handler.ui.fragments.common.vm.IViewModel;

public class CitiesFragment extends BaseFragment {

    @Inject
    public CitiesViewModel viewModel;

    public CitiesFragment() {
        super(R.layout.fragment_cities);
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
