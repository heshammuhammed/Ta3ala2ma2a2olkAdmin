package AllAnswers.MVP;

import java.util.List;
import java.util.Queue;

import AllAnswers.Connection.GetAllAnswers;
import Connection.Connection;
import POJO.Answers;
import POJO.Question;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by HeshamMuhammed on 6/10/2018.
 */

public class AllAnswersPresenter implements SelectAllAnswers.Presenter {

    SelectAllAnswers.View view;
    GetAllAnswers getAllAnswers;
    Call<Question> questionCall;
    List<Answers> answersList;
    int questionid;

    AllAnswersPresenter(SelectAllAnswers.View view){
        this.view=view;
    }

    @Override
    public void getAnswers(int id) {
        this.questionid=id;
        getAllAnswers = Connection.getConnection().create(GetAllAnswers.class);
        questionCall = getAllAnswers.getAllAnswers(Connection.token,id);
        questionCall.enqueue(new Callback<Question>() {
            @Override
            public void onResponse(Call<Question> call, Response<Question> response) {
                if (response != null) {
                    answersList = response.body().getAnswersCollection();
                    view.ViewAnswers(answersList);
                }
            }

            @Override
            public void onFailure(Call<Question> call, Throwable t) {

            }
        });

    }

    @Override
    public void deleteAnswers(int id) {
        getAllAnswers = Connection.getConnection().create(GetAllAnswers.class);
        Call<Question> deleteAnswer = getAllAnswers.deleteAnswer(Connection.token,id);
        deleteAnswer.enqueue(new Callback<Question>() {
            @Override
            public void onResponse(Call<Question> call, Response<Question> response) {
                if (response != null) {
                }
            }

            @Override
            public void onFailure(Call<Question> call, Throwable t) {

            }
        });
        getAnswers(questionid);
    }
}