package meugeninua.android.handler.ui.fragments.test.second.binding;

import androidx.annotation.NonNull;

import meugeninua.android.handler.R;
import meugeninua.android.handler.ui.fragments.common.binding.Binding;

public class TestSecondBinding {

    public static void setupListeners(@NonNull Binding binding, @NonNull Listener listener) {
        binding.setOnClickListener(R.id.request_api, v -> listener.onRequestApiClick());
    }

    public interface Listener {
        void onRequestApiClick();
    }
}
