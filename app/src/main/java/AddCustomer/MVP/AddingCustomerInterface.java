package AddCustomer.MVP;

import POJO.CustomerService;
import POJO.User;

/**
 * Created by HeshamMuhammed on 6/11/2018.
 */

public interface AddingCustomerInterface {

    interface View {
         void setData(String name);
    }

    interface Presenter{
        void registerPerson(User user);
        void registerCustomer (CustomerService customerService);
        void addCustomer(CustomerService customerService);
    }
}
