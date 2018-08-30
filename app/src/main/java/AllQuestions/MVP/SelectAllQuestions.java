package AllQuestions.MVP;

import POJO.AllQuestion;

/**
 * Created by HeshamMuhammed on 6/9/2018.
 */

public interface SelectAllQuestions {

    interface view{
        public void getQuestions(AllQuestion allQuestions , int id);
    }

    interface presenter{
        public void getData(int id);
        public void deleteQuestion(int id);

    }
}
