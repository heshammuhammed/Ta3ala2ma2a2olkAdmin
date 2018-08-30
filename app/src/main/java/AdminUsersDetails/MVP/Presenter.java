package AdminUsersDetails.MVP;


import AdminUsersDetails.Connection.*;
import AdminUsersDetails.Connection.RetrofitInterface;
import Connection.Connection;
import POJO.TaaUser;
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
    Call<TaaUser> user;
    Call<TaaUser> changeState;
    public Presenter(MyInterface.View view) {
        this.view = view;
    }

    @Override
    public void getData(int id) {
        retrofitInterface =  Connection.getConnection().create(RetrofitInterface.class);
        user = retrofitInterface.getUser(Connection.token,id);
        user.enqueue(new Callback<TaaUser>() {
            @Override
            public void onResponse(Call<TaaUser> call, Response<TaaUser> response) {
                if (response != null){
                    view.sendData(response.body());
                }
            }
            @Override
            public void onFailure(Call<TaaUser> call, Throwable t) {
            }
        });
    }

    @Override
    public void changeState(User user) {
        user.setEnabled(!user.getEnabled());
        retrofitInterface =  Connection.getConnection().create(RetrofitInterface.class);
        changeState = retrofitInterface.changeState(user,Connection.token);
        changeState.enqueue(new Callback<TaaUser>() {
            @Override
            public void onResponse(Call<TaaUser> call, Response<TaaUser> response) {
         //       view.Show(response.body().toString());
                if (response != null){
                    view.sendData(response.body());
                }

            }

            @Override
            public void onFailure(Call<TaaUser> call, Throwable t) {
            //     view.Show(t.getMessage().toString());
            }
        });
    }
}