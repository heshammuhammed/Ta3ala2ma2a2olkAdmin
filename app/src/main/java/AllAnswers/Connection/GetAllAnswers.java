package AllAnswers.Connection;

import POJO.AllQuestion;
import POJO.Question;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by HeshamMuhammed on 6/10/2018.
 */

public interface GetAllAnswers {

    @Headers("Content-Type: application/json")

    @GET("Question/{id}")
    Call<Question> getAllAnswers(@Header("Authorization") String token, @Path("id") int id);

    @DELETE("Answers/{id}")
    Call<Question> deleteAnswer(@Header("Authorization") String token, @Path("id") int id);
}
