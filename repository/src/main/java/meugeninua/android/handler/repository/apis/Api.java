package meugeninua.android.handler.repository.apis;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    /**
     * Have a look at https://github.com/meugen/aws-lambdas/blob/main/src/main/java/meugeninua/awslambdas/SlowRestHandler.java for implementation details
     * @return Call response
     */
    @GET("/slow-rest")
    Call<String> slowRest(@Query("delay") String delay);
}
