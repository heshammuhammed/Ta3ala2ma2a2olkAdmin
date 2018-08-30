package AllQuestions.Connection;

import java.util.List;

import POJO.AllQuestion;
import POJO.Question;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by HeshamMuhammed on 6/9/2018.
 */

public interface GetAllQuestions {

    @Headers("Content-Type: application/json")

    @GET("QuestionWithSubCat/{id}")
    Call<AllQuestion> getAllQuestions(@Header("Authorization") String token , @Path("id") int id);

    @DELETE("Question/{id}")
    Call<Question> deleteQuestion(@Header("Authorization") String token , @Path("id") int id);
}