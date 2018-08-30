package AdminCategoriesDetails.Connection;

import java.util.List;

import POJO.AddCategory;
import POJO.AllUsers;
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
 * Created by HeshamMuhammed on 5/21/2018.
 */

public interface AdminCategoriesDetailsRetrofitInterface {

    @Headers("Content-Type: application/json")
    @GET("CategoriesByName/{name}")
    Call<List<SubCategory>> getAllCategories(@Header("Authorization") String token , @Path("name") String name);

    @POST("SubCat")
    Call<AddCategory> addCategory(@Header("Authorization") String token ,@Body AddCategory addCategory);

    @DELETE("SubCat/{id}")
    Call<SubCategory> deleteCategory(@Header("Authorization") String token  , @Path("id") int id);
}