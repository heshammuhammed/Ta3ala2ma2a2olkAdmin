package AdminUsers.MVP;


import java.util.List;

import POJO.AllUsers;

/**
 * Created by HeshamMuhammed on 5/21/2018.
 */

public interface MyInterface {

    interface View{
        void sendData(List<AllUsers> list);
    }

    interface Presenter{
        void getUserData();
        void getCustomerData();
        void deletePerson(int id);
    }
}