package meugeninua.android.handler.repository.apis;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("/slow-rest")
    Call<String> slowRest();
}
