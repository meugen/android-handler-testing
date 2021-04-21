package meugeninua.android.handler.ui.fragments.common.actions;

import meugeninua.android.handler.ui.fragments.common.vm.IViewModel;

public interface ViewModelAction<T extends IViewModel> {

    void onAction(T viewModel);
}
