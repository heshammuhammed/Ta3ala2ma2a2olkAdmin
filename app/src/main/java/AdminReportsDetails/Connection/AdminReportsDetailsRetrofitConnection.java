package AdminReportsDetails.Connection;

import POJO.Answers;
import POJO.Report;
import POJO.User;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by HeshamMuhammed on 5/26/2018.
 */

public interface AdminReportsDetailsRetrofitConnection {

    @GET("Report/{id}")
    Call<Report> getReport(@Header("Authorization") String token , @Path("id") int id);

    @PUT("Report")
    Call<Report> changeReport(@Body Report report ,@Header("Authorization") String token  );

    @GET("Answers/{id}")
    Call<Answers> getAnswer(@Header("Authorization") String token , @Path("id") int id);
}