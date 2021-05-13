package meugeninua.android.handler.ui.fragments.test.first.binding;

import androidx.annotation.NonNull;

import meugeninua.android.handler.R;
import meugeninua.android.handler.ui.fragments.common.binding.Binding;

public class TestFirstBinding {

    public static void setupListeners(@NonNull Binding binding, @NonNull Listener listener) {
        Binding.Utils utils = new Binding.Utils(binding);
        utils.setOnClickListener(R.id.button_move, v -> listener.onMoveClick());
    }

    public interface Listener {
        void onMoveClick();
    }
}
