package CustomerServiceData.Connection;

import POJO.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by HeshamMuhammed on 6/12/2018.
 */

public interface GettingCustomers {

    @GET("Person/{id}")
    Call<User> getCustomer(@Header("Authorization") String token , @Path("id") int id );
}
