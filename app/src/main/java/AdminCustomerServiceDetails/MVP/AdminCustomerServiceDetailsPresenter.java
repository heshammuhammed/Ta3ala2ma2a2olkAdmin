package AdminCustomerServiceDetails.MVP;


import java.util.List;

import AdminCategories.Connection.AdminCategoriesRetrofitConnection;
import AdminCustomerServiceDetails.Connection.AdminCustomerServiceDetailsRetrofitInterface;
import Connection.Connection;
import POJO.AddCategory;
import POJO.MainCategory;
import POJO.SubCategory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by HeshamMuhammed on 5/29/2018.
 */

public class AdminCustomerServiceDetailsPresenter implements AdminCustomerServiceDetailsInterface.Presenter {

    AdminCustomerServiceDetailsInterface.View view;
    AdminCustomerServiceDetailsRetrofitInterface adminCustomerServiceDetailsRetrofitInterface;
    Call<List<SubCategory>> getAllCategories;
    List<SubCategory> getCategories;
    String name;
    Call<AddCategory> addMyCategory;
    Call<SubCategory> deleteCategory;


    public AdminCustomerServiceDetailsPresenter(AdminCustomerServiceDetailsInterface.View view) {
        this.view = view;
    }


    @Override
    public void setData(String name) {
        adminCustomerServiceDetailsRetrofitInterface = Connection.getConnection().create(AdminCustomerServiceDetailsRetrofitInterface.class);
        getAllCategories = adminCustomerServiceDetailsRetrofitInterface.getAllCategories(Connection.token, name);
        this.name= name;
        getAllCategories.enqueue(new Callback<List<SubCategory>>() {
            @Override
            public void onResponse(Call<List<SubCategory>> call, Response<List<SubCategory>> response) {
                getCategories = response.body();
                view.ShowSubCategories(getCategories);

            }

            @Override
            public void onFailure(Call<List<SubCategory>> call, Throwable t) {

            }
        });
    }

    @Override
    public void deleteMainCategory(SubCategory subCategory) {
        adminCustomerServiceDetailsRetrofitInterface = Connection.getConnection().create(AdminCustomerServiceDetailsRetrofitInterface.class);
        deleteCategory = adminCustomerServiceDetailsRetrofitInterface.deleteCategory(Connection.token,subCategory.getSubCatId());
        deleteCategory.enqueue(new Callback<SubCategory>() {
            @Override
            public void onResponse(Call<SubCategory> call, Response<SubCategory> response) {
                if (response != null){

                }
            }

            @Override
            public void onFailure(Call<SubCategory> call, Throwable t) {

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        setData(name);
    }

    @Override
    public void addMainCategory(AddCategory addCategory) {
        adminCustomerServiceDetailsRetrofitInterface = Connection.getConnection().create(AdminCustomerServiceDetailsRetrofitInterface.class);
        addMyCategory = adminCustomerServiceDetailsRetrofitInterface.addCategory(Connection.token, addCategory);
        addMyCategory.enqueue(new Callback<AddCategory>() {
            @Override
            public void onResponse(Call<AddCategory> call, Response<AddCategory> response) {
                if (response != null) {

                }
            }

            @Override
            public void onFailure(Call<AddCategory> call, Throwable t) {

            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        setData(name);

    }
}