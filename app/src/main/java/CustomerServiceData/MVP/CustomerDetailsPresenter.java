package CustomerServiceData.MVP;

import android.content.Context;

import Connection.Connection;
import CustomerServiceData.Connection.GettingCustomers;
import POJO.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by HeshamMuhammed on 6/12/2018.
 */

public class CustomerDetailsPresenter implements CustomerDetailsInterface.Presenter {

    CustomerDetailsInterface.View view;
    GettingCustomers gettingCustomers;

    public CustomerDetailsPresenter(CustomerDetailsInterface.View view){
        this. view = view;
    }

    @Override
    public void getData(int id) {
        gettingCustomers = Connection.getConnection().create(GettingCustomers.class);
        Call<User> getCustomer = gettingCustomers.getCustomer(Connection.token,id);
        getCustomer.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
               if (response != null){
                   view.setData(response.body());
               }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

    }
}
