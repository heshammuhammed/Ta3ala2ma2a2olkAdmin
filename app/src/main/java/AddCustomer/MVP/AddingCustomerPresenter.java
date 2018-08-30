package AddCustomer.MVP;

import AddCustomer.Connection.AddingCustomer;
import Connection.Connection;
import POJO.CustomerService;
import POJO.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by HeshamMuhammed on 6/11/2018.
 */

public class AddingCustomerPresenter implements AddingCustomerInterface.Presenter {

    AddingCustomerInterface.View view;
    AddingCustomer addingCustomer;
    User tempUser;
    CustomerService customerService;

    AddingCustomerPresenter(AddingCustomerInterface.View view){
        this.view = view;
    }

    @Override
    public void registerPerson(User user) {

        addingCustomer = Connection.getConnection().create(AddingCustomer.class);
        Call<User> addUser = addingCustomer.addUser(Connection.token,user);
        addUser.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response != null){
                    tempUser = response.body();
                    customerService.setPersonId(tempUser.getPersonId());
                    AddingCustomerPresenter.this.registerCustomer(customerService);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    @Override
    public void registerCustomer(CustomerService customerService) {
        addingCustomer = Connection.getConnection().create(AddingCustomer.class);
        Call<CustomerService> addCustomer = addingCustomer.addCustomer(Connection.token,customerService);
        addCustomer.enqueue(new Callback<CustomerService>() {
            @Override
            public void onResponse(Call<CustomerService> call, Response<CustomerService> response) {
                if (response != null){
                    view.setData("Adding Customer Completed");
                }
            }

            @Override
            public void onFailure(Call<CustomerService> call, Throwable t) {

            }
        });
    }

    @Override
    public void addCustomer(CustomerService customerService) {
        this.customerService = customerService;
    }
}