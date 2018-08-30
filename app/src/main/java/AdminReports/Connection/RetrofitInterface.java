package AdminReports.Connection;

import java.util.List;

import POJO.AllReports;
 import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

/**
 * Created by HeshamMuhammed on 5/21/2018.
 */

public interface RetrofitInterface {

   @Headers("Content-Type: application/json")
   @GET("ReportProfile")
   Call<List<AllReports>> getAllReports(@Header("Authorization") String token);
}