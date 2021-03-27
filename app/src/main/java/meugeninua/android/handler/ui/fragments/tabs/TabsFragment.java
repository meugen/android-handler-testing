package meugeninua.android.handler.ui.fragments.tabs;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import meugeninua.android.handler.R;
import meugeninua.android.handler.ui.fragments.common.binding.Binding;

public class TabsFragment extends Fragment {

    private final Binding binding = new Binding();

    public TabsFragment() {
        super(R.layout.fragment_tabs);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.onAttachView(getViewLifecycleOwner(), view);

        BottomNavigationView bottomView = binding.get(R.id.bottom_view);
        Fragment fragment = getChildFragmentManager().findFragmentById(R.id.tabs);
        NavigationUI.setupWithNavController(bottomView,
                NavHostFragment.findNavController(fragment));
    }
}
