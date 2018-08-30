package CustomerServiceData.MVP;

import POJO.User;

/**
 * Created by HeshamMuhammed on 6/12/2018.
 */

public interface CustomerDetailsInterface {

    interface View{
         void setData(User user);
    }
    interface Presenter{
         void getData(int id);
    }
}
