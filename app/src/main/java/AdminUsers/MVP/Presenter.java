package AdminUsers.MVP;

import android.util.Log;
import java.util.List;

import AdminUsers.Connection.RetrofitInterface;
import Connection.Connection;
import POJO.AllUsers;
import POJO.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by HeshamMuhammed on 5/21/2018.
 */

public class Presenter implements MyInterface.Presenter {
    MyInterface.View view;
    private RetrofitInterface retrofitInterface;
    Call<List<AllUsers>> users;
    int id;

    public Presenter(MyInterface.View view) {
        this.view = view;
    }

    @Override
    public void getUserData() {
        id = 1;
        retrofitInterface = Connection.getConnection().create(RetrofitInterface.class);
        users = retrofitInterface.getAllUsers(Connection.token);
        users.enqueue(new Callback<List<AllUsers>>() {
            @Override
            public void onResponse(Call<List<AllUsers>> call, Response<List<AllUsers>> response) {
                  if (response != null) {
                    view.sendData(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<AllUsers>> call, Throwable t) {
             }
        });
    }

    @Override
    public void getCustomerData() {
        id =2;
        retrofitInterface = Connection.getConnection().create(RetrofitInterface.class);
        users = retrofitInterface.getAllCustomer(Connection.token);
        users.enqueue(new Callback<List<AllUsers>>() {
            @Override
            public void onResponse(Call<List<AllUsers>> call, Response<List<AllUsers>> response) {
                if (response != null) {
                    view.sendData(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<AllUsers>> call, Throwable t) {
            }
        });
    }

    @Override
    public void deletePerson(int id) {
        retrofitInterface = Connection.getConnection().create(RetrofitInterface.class);
        Call<AllUsers> deletePerson = retrofitInterface.deletePerson(Connection.token,id);
        deletePerson.enqueue(new Callback<AllUsers>() {
            @Override
            public void onResponse(Call<AllUsers> call, Response<AllUsers> response) {

            }

            @Override
            public void onFailure(Call<AllUsers> call, Throwable t) {

            }
        });
        if (id == 1){
            getUserData();
        } else if (id == 2){
            getCustomerData();
        }

    }
}