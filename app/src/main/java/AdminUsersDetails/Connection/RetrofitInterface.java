package AdminUsersDetails.Connection;

import android.util.Log;

import java.util.List;

import AdminUsers.Connection.*;
import POJO.AllUsers;
import POJO.TaaUser;
import POJO.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by HeshamMuhammed on 5/21/2018.
 */

public interface RetrofitInterface {

    @GET("TaaUser/{id}")
    Call<TaaUser> getUser(@Header("Authorization") String token , @Path("id") int id );

    @PUT("Person")
    Call<TaaUser> changeState(@Body User user , @Header("Authorization") String token );
}