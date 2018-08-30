package AdminUsers.Connection;

import java.util.List;

import POJO.AllUsers;
import POJO.Question;
import POJO.User;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by HeshamMuhammed on 5/21/2018.
 */

public interface RetrofitInterface {

    @Headers("Content-Type: application/json")

    @GET("TaaUserProfile?size=1000")
    Call<List<AllUsers>> getAllUsers(@Header("Authorization") String token);

    @GET("CustomerServiceProfile?size=1000")
    Call<List<AllUsers>> getAllCustomer(@Header("Authorization") String token);

    @DELETE("Person/{id}")
    Call<AllUsers> deletePerson(@Header("Authorization") String token, @Path("id") int id);
}