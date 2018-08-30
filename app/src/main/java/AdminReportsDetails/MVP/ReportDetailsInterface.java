package AdminReportsDetails.MVP;

import POJO.Answers;
import POJO.Report;

/**
 * Created by HeshamMuhammed on 5/26/2018.
 */

public interface ReportDetailsInterface {
    interface View{
        void setReport(Report report);
        void setAnswers(Answers answers);
    }

    interface Presenter{
      void getReport(int id);
      void changeReport(Report report);
      void getAnswer(int id);
    }
}
