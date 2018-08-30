package AdminPlaces.MVP;

import java.util.List;

import AdminCategories.Connection.AdminCategoriesRetrofitConnection;
import AdminPlaces.Connection.AdminPlacesRetrofitInterface;
import Connection.Connection;
import POJO.AddCategory;
import POJO.MainCategory;
import POJO.SubCategory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by HeshamMuhammed on 5/24/2018.
 */

public class AdminPlacesPresenter implements AdminPlacesMVPInterface.Presenter {

    AdminPlacesMVPInterface.View view;
    AdminPlacesRetrofitInterface adminPlacesRetrofitInterface;

    Call<List<SubCategory>> getPlaces;
    List<SubCategory> myCategories;

    Call<AddCategory> addMyCategory;

    Call<SubCategory> deleteMyCategory;

    public AdminPlacesPresenter(AdminPlacesMVPInterface.View view){
        this.view = view;
    }

    @Override
    public void setData() {
        adminPlacesRetrofitInterface = Connection.getConnection().create(AdminPlacesRetrofitInterface.class);
        getPlaces = adminPlacesRetrofitInterface.getAllCategories(Connection.token);
        getPlaces.enqueue(new Callback<List<SubCategory>>() {
            @Override
            public void onResponse(Call<List<SubCategory>> call, Response<List<SubCategory>> response) {
                myCategories = response.body();
                view.ShowCategories(myCategories);
            }
            @Override
            public void onFailure(Call<List<SubCategory>> call, Throwable t) {

            }
        });
    }

    @Override
    public void deleteMainCategory(SubCategory subCategory) {
        adminPlacesRetrofitInterface = Connection.getConnection().create(AdminPlacesRetrofitInterface.class);
        deleteMyCategory = adminPlacesRetrofitInterface.deleteCategory(Connection.token,subCategory.getSubCatId());
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

    @Override
    public void addMainCategory(AddCategory addCategory) {
        adminPlacesRetrofitInterface = Connection.getConnection().create(AdminPlacesRetrofitInterface.class);
        addMyCategory = adminPlacesRetrofitInterface.addCategory(Connection.token, addCategory);
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
}