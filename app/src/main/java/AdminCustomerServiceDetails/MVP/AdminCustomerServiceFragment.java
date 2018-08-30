package AdminCustomerServiceDetails.MVP;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.heshammuhammed.ta3ala2ma2a2olkadmin.R;

import java.util.List;

import AdminCustomerServiceDetails.Recycle.AdminCustomerServiceRecycleView;
import Dialoger.DeleteDialog;
import Dialoger.ProgressingDialog;
import POJO.AddCategory;
import POJO.SubCategory;
import Dialoger.MyDialog;

public class AdminCustomerServiceFragment extends Fragment implements AdminCustomerServiceDetailsInterface.View {

    RecyclerView recyclerView;
    AdminCustomerServiceDetailsPresenter adminCustomerServiceDetailsPresenter;
    AdminCustomerServiceRecycleView adminCustomerServiceRecycleView;
    Button button;
    String name;
    DeleteDialog deleteDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_customer2, container, false);
        adminCustomerServiceDetailsPresenter = new AdminCustomerServiceDetailsPresenter(this);
        recyclerView = view.findViewById(R.id.my_recycler_view);
        Bundle bundle = getArguments();
        name = bundle.getString("String");
        adminCustomerServiceDetailsPresenter.setData(name);
        button = view.findViewById(R.id.adminaddcustomer);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Add();
            }
        });
         return view;
    }

    @Override
    public void ShowSubCategories(List<SubCategory> subCatCollection) {
        adminCustomerServiceRecycleView = new AdminCustomerServiceRecycleView(getContext(), subCatCollection, this);
        recyclerView.setAdapter(adminCustomerServiceRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    public void Delete(SubCategory subCategory) {
        deleteDialog = new DeleteDialog();
        boolean check = deleteDialog.delete(getContext());
        if (check == true) {
             adminCustomerServiceDetailsPresenter.deleteMainCategory(subCategory);
        }
    }

    private void Add() {
        MyDialog myDialog = new MyDialog();
        if (myDialog.getYesNoWithExecutionStop(getContext())) {
            AddCategory addCategory = new AddCategory();
            addCategory.setMainCategoriesId(3);
            addCategory.setSubCatName(name);
            addCategory.setDescription(myDialog.getName());
            adminCustomerServiceDetailsPresenter.addMainCategory(addCategory);
        }
    }
}