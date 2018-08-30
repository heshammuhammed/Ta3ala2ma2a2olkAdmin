package AdminReports.MVP;


import java.util.List;

import AdminReports.Connection.RetrofitInterface;
import Connection.Connection;
import POJO.AllReports;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by HeshamMuhammed on 5/21/2018.
 */

public class AdminReportsPresenter implements AdminReportsInterface.Presenter {

    Call<List<AllReports>> getAllReports;
    RetrofitInterface retrofitInterface;
    AdminReportsInterface.View view;

    public AdminReportsPresenter(AdminReportsInterface.View view) {
        this.view = view;
    }

    @Override
    public void getData() {
        retrofitInterface = Connection.getConnection().create(RetrofitInterface.class);
        getAllReports = retrofitInterface.getAllReports(Connection.token);
        getAllReports.enqueue(new Callback<List<AllReports>>() {
            @Override
            public void onResponse(Call<List<AllReports>> call, Response<List<AllReports>> response) {
                List<AllReports> tempReports = response.body();
                if (response != null){
                    view.sendData(tempReports);
                }
            }

            @Override
            public void onFailure(Call<List<AllReports>> call, Throwable t) {

            }
        });
    }
}
