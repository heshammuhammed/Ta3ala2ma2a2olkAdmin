package AdminPlacesDetails.MVP;

import java.util.List;

import AdminCategories.Connection.AdminCategoriesRetrofitConnection;
import AdminPlacesDetails.Connection.AdminPlacesDetailsRetrofitInterface;
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

public class AdminPlacesDetailsPresenter implements AdminPlacesDetailsInterface.Presenter {

    AdminPlacesDetailsInterface.View view;
    AdminPlacesDetailsRetrofitInterface adminPlacesDetailsRetrofitInterface;

    Call<List<SubCategory>> getAllCategories;
    List<SubCategory> getCategories;

    String name;

    Call<AddCategory> addMyCategory;

    Call<SubCategory> deleteMyCategory;

    public AdminPlacesDetailsPresenter(AdminPlacesDetailsInterface.View view) {
        this.view = view;
    }

    @Override
    public void setData(String name) {
        adminPlacesDetailsRetrofitInterface = Connection.getConnection().create(AdminPlacesDetailsRetrofitInterface.class);
        getAllCategories = adminPlacesDetailsRetrofitInterface.getAllCategories(Connection.token,name);
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
        adminPlacesDetailsRetrofitInterface = Connection.getConnection().create(AdminPlacesDetailsRetrofitInterface.class);
        deleteMyCategory = adminPlacesDetailsRetrofitInterface.deleteCategory(Connection.token,subCategory.getSubCatId());
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
        adminPlacesDetailsRetrofitInterface = Connection.getConnection().create(AdminPlacesDetailsRetrofitInterface.class);
        addMyCategory = adminPlacesDetailsRetrofitInterface.addCategory(Connection.token, addCategory);
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