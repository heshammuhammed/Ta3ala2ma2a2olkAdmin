package AddCustomer.MVP;

/**
 * Created by HeshamMuhammed on 6/12/2018.
 */

public interface Communicator {

     interface Receiver {
         void getJoinDate(String date);
         void getExpiredDate(String date);
     }
}