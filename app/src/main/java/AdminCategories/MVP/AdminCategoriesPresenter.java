package AdminCategories.MVP;

import java.util.List;

import AdminCategories.Connection.AdminCategoriesRetrofitConnection;
import AdminPlaces.MVP.PlacesFragment;
import Connection.Connection;
import Dialoger.ProgressingDialog;
import POJO.AddCategory;
import POJO.MainCategory;
import POJO.SubCategory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by HeshamMuhammed on 5/24/2018.
 */

public class AdminCategoriesPresenter implements AdminCategoriesMVPInterface.Presenter {


    AdminCategoriesMVPInterface.View view;
    AdminCategoriesRetrofitConnection adminCategoriesRetrofitConnection;

    Call<List<SubCategory>> getAllCategories;
    List<SubCategory> myList;

    Call<AddCategory> addMyCategory;

    Call<SubCategory> deleteMyCategory;

    public AdminCategoriesPresenter(AdminCategoriesMVPInterface.View view) {
        this.view = view;
    }

    @Override
    public void setData() {
        adminCategoriesRetrofitConnection = Connection.getConnection().create(AdminCategoriesRetrofitConnection.class);
        getAllCategories = adminCategoriesRetrofitConnection.getAllCategories(Connection.token);
        getAllCategories.enqueue(new Callback<List<SubCategory>>() {
            @Override
            public void onResponse(Call<List<SubCategory>> call, Response<List<SubCategory>> response) {


                if (response.isSuccessful()) {
                    myList = response.body();
                    view.ShowCategories(myList, "!!!!");
                }
            }

            @Override
            public void onFailure(Call<List<SubCategory>> call, Throwable t) {

            }
        });

    }


    @Override
    public void addMainCategory(AddCategory addCategory) {
        adminCategoriesRetrofitConnection = Connection.getConnection().create(AdminCategoriesRetrofitConnection.class);
        addMyCategory = adminCategoriesRetrofitConnection.addCategory(Connection.token, addCategory);
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
            setData();

    }

    @Override
    public void deleteMainCategory(SubCategory subCategory) {
        adminCategoriesRetrofitConnection = Connection.getConnection().create(AdminCategoriesRetrofitConnection.class);
        deleteMyCategory = adminCategoriesRetrofitConnection.deleteCategory(Connection.token,subCategory.getSubCatId());
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
        setData();
    }
}