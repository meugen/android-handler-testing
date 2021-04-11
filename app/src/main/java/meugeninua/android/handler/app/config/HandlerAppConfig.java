package meugeninua.android.handler.app.config;

import meugeninua.android.handler.BuildConfig;
import meugeninua.android.handler.utils.config.AppConfig;

public class HandlerAppConfig implements AppConfig {

    @Override
    public String getBaseUrl() {
        return BuildConfig.BASE_URL;
    }
}
