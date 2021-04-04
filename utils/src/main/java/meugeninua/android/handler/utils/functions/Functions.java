package meugeninua.android.handler.utils.functions;

public class Functions {

    private static final Consumer EMPTY_CONSUMER = v -> { };
    private static final Action EMPTY_ACTION = () -> { };

    public static <T> Consumer<T> emptyConsumer() {
        return EMPTY_CONSUMER;
    }

    public static Action emptyAction() {
        return EMPTY_ACTION;
    }
}
