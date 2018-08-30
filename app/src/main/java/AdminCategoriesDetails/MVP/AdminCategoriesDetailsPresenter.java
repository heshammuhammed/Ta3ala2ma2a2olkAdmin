package AdminCategoriesDetails.MVP;


import java.util.List;

import AdminCategories.Connection.AdminCategoriesRetrofitConnection;
import AdminCategoriesDetails.Connection.AdminCategoriesDetailsRetrofitInterface;
import AdminCustomerServiceDetails.MVP.AdminCustomerServiceDetailsInterface;
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

public class AdminCategoriesDetailsPresenter implements AdminCustomerServiceDetailsInterface.Presenter {

    AdminCategoriesDetailsInterface.View view;
    AdminCategoriesDetailsRetrofitInterface adminCategoriesDetailsRetrofitInterface;
    Call<List<SubCategory>> getAllCategories;
    List<SubCategory> getCategories;
    Call<AddCategory> addMyCategory;
    String name;
    Call<SubCategory> deleteMyCategory;

    public AdminCategoriesDetailsPresenter(AdminCategoriesDetailsInterface.View view) {
        this.view = view;
    }

    @Override
    public void setData(String name) {
        adminCategoriesDetailsRetrofitInterface = Connection.getConnection().create(AdminCategoriesDetailsRetrofitInterface.class);
        getAllCategories = adminCategoriesDetailsRetrofitInterface.getAllCategories(Connection.token, name);
        this.name = name;
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
        adminCategoriesDetailsRetrofitInterface = Connection.getConnection().create(AdminCategoriesDetailsRetrofitInterface.class);
        deleteMyCategory = adminCategoriesDetailsRetrofitInterface.deleteCategory(Connection.token, subCategory.getSubCatId());
        deleteMyCategory.enqueue(new Callback<SubCategory>() {
            @Override
            public void onResponse(Call<SubCategory> call, Response<SubCategory> response) {

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
        adminCategoriesDetailsRetrofitInterface = Connection.getConnection().create(AdminCategoriesDetailsRetrofitInterface.class);
        addMyCategory = adminCategoriesDetailsRetrofitInterface.addCategory(Connection.token, addCategory);
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
        setData(name);

    }

}