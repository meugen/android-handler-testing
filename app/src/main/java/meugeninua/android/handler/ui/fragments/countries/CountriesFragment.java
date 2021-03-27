package meugeninua.android.handler.ui.fragments.countries;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import javax.inject.Inject;

import meugeninua.android.handler.R;
import meugeninua.android.handler.ui.fragments.common.BaseFragment;
import meugeninua.android.handler.ui.fragments.common.vm.IViewModel;

public class CountriesFragment extends BaseFragment {

    @Inject
    public CountriesViewModel viewModel;

    public CountriesFragment() {
        super(R.layout.fragment_countries);
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
