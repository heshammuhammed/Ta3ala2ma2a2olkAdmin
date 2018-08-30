package AllQuestions.MVP;

import AllQuestions.Connection.GetAllQuestions;
import Connection.Connection;
import POJO.AllQuestion;
import POJO.Question;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by HeshamMuhammed on 6/9/2018.
 */

public class QuestionsPresenter implements SelectAllQuestions.presenter {

    SelectAllQuestions.view view;
    GetAllQuestions getAllQuestion;
    Call<AllQuestion> allQuestionCall;
    Call<Question> removeQuestion;
    int tempMyId;
     QuestionsPresenter(SelectAllQuestions.view view){
        this.view=view;
    }

    @Override
    public void getData(int id) {
        getAllQuestion = Connection.getConnection().create(GetAllQuestions.class);
        allQuestionCall = getAllQuestion.getAllQuestions(Connection.token,id);
        this.tempMyId = id;
         allQuestionCall.enqueue(new Callback<AllQuestion>() {
            @Override
            public void onResponse(Call<AllQuestion> call, Response<AllQuestion> response) {
                if (response != null){
                    view.getQuestions(response.body(),tempMyId);
                }
            }

            @Override
            public void onFailure(Call<AllQuestion> call, Throwable t) {

            }
        });
    }

    @Override
    public void deleteQuestion(int id) {
        getAllQuestion = Connection.getConnection().create(GetAllQuestions.class);
        removeQuestion = getAllQuestion.deleteQuestion(Connection.token,id);
        removeQuestion.enqueue(new Callback<Question>() {
            @Override
            public void onResponse(Call<Question> call, Response<Question> response) {

            }

            @Override
            public void onFailure(Call<Question> call, Throwable t) {

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        getData(tempMyId);
    }
}