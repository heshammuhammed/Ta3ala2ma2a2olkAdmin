package AddCustomer.Connection;

import java.util.List;

import POJO.AddCategory;
import POJO.CustomerService;
import POJO.SubCategory;
import POJO.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by HeshamMuhammed on 6/11/2018.
 */

public interface AddingCustomer {

    @Headers("Content-Type: application/json")

    @POST("Person")
    Call<User> addUser(@Header("Authorization") String token , @Body User user);

    @POST("CustomerService")
    Call<CustomerService> addCustomer(@Header("Authorization") String token , @Body CustomerService customerService);
}
