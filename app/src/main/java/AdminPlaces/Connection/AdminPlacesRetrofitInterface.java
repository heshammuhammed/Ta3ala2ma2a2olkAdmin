package AdminPlaces.Connection;

import java.util.List;

import POJO.AddCategory;
import POJO.MainCategory;
import POJO.SubCategory;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by HeshamMuhammed on 5/24/2018.
 */

public interface AdminPlacesRetrofitInterface {

    @Headers("Content-Type: application/json")
    @GET("Categories/2?size=1000")
    Call<List<SubCategory>> getAllCategories(@Header("Authorization") String token);

    @POST("SubCat")
    Call<AddCategory> addCategory(@Header("Authorization") String token ,@Body AddCategory addCategory);

    @DELETE("SubCat/{id}")
    Call<SubCategory> deleteCategory(@Header("Authorization") String token  , @Path("id") int id);
}
