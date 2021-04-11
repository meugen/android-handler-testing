package meugeninua.android.handler.repository.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import meugeninua.android.handler.repository.Repository;
import meugeninua.android.handler.repository.apis.Api;
import meugeninua.android.handler.repository.impls.RepositoryImpl;
import meugeninua.android.handler.utils.config.AppConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    public static OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build();
    }

    @Singleton
    @Provides
    public static Retrofit provideRetrofit(
        OkHttpClient client,
        AppConfig config
    ) {
        return new Retrofit.Builder()
            .baseUrl(config.getBaseUrl())
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }

    @Singleton
    @Provides
    public static Api provideSlowRestApi(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }

    @Singleton
    @Provides
    public static Repository provideRepository(Api api) {
        return new RepositoryImpl(api);
    }
}
