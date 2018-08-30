package AdminCustomerService.MVP;

import java.util.List;

import AdminCustomerService.Connection.AdminServicesRetrofitConnection;
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

public class AdminServicesPresenter implements AdminServicesMVPInterface.Presenter{

    AdminServicesMVPInterface.View view;
     AdminServicesRetrofitConnection adminServicesRetrofitConnection;

    Call<List<SubCategory>> getAllCategories;
    List<SubCategory> myCategories;

    Call<AddCategory> addMyCategory, deleteMyCategory;



    public AdminServicesPresenter(AdminServicesMVPInterface.View view){
        this.view = view;
    }

    @Override
    public void setData() {
        adminServicesRetrofitConnection = Connection.getConnection().create(AdminServicesRetrofitConnection.class);
        getAllCategories = adminServicesRetrofitConnection.getAllCategories(Connection.token);
        getAllCategories.enqueue(new Callback<List<SubCategory>>() {
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
        adminServicesRetrofitConnection = Connection.getConnection().create(AdminServicesRetrofitConnection.class);
        Call<SubCategory> deleteCategory = adminServicesRetrofitConnection.deleteCategory(Connection.token,subCategory.getSubCatId());
        deleteCategory.enqueue(new Callback<SubCategory>() {
            @Override
            public void onResponse(Call<SubCategory> call, Response<SubCategory> response) {

            }

            @Override
            public void onFailure(Call<SubCategory> call, Throwable t) {

            }
        });
        setData();
    }

    @Override
    public void addMainCategory(AddCategory addCategory) {
        adminServicesRetrofitConnection = Connection.getConnection().create(AdminServicesRetrofitConnection.class);
        addMyCategory = adminServicesRetrofitConnection.addCategory(Connection.token, addCategory);
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