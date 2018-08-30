package AdminUsersDetails.MVP;


import java.util.List;

import POJO.AllUsers;
import POJO.TaaUser;
import POJO.User;


/**
 * Created by HeshamMuhammed on 5/21/2018.
 */

public interface MyInterface {

    interface View{
        void sendData(TaaUser user);
     }

    interface Presenter{
        void getData(int id);
        void changeState(User user);
     }
}