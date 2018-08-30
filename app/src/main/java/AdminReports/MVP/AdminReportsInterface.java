package AdminReports.MVP;


import java.util.List;

import POJO.AllReports;

/**
 * Created by HeshamMuhammed on 5/21/2018.
 */

public interface AdminReportsInterface {

    interface View{
        void sendData(List<AllReports> getReports);
    }

    interface Presenter{
        void getData();
    }
}