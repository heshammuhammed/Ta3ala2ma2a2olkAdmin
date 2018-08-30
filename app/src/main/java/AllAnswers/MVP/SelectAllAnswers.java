package AllAnswers.MVP;

import java.util.List;

import POJO.Answers;

/**
 * Created by HeshamMuhammed on 6/10/2018.
 */

public interface SelectAllAnswers {

    interface View{
        void ViewAnswers(List<Answers> answers);
    }

    interface Presenter{
        void getAnswers(int id);
        void deleteAnswers(int id);
    }
}
