package AdminCustomerService.MVP;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import AdminCategories.Recycle.CategoriesRecycleView;
import AdminCustomerService.Recycle.CustomerServiceRecycleView;
import Dialoger.DeleteDialog;
import Dialoger.ProgressingDialog;
import POJO.AddCategory;
import POJO.SubCategory;
import Dialoger.MyDialog;

public class CustomerServiceFragment extends Fragment implements AdminServicesMVPInterface.View {

    AdminServicesPresenter adminServicesPresenter;
    private RecyclerView recyclerView;
    CustomerServiceRecycleView customerServiceRecycleView;
    Button button;
    ProgressingDialog progressingDialog;
    DeleteDialog deleteDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        adminServicesPresenter = new AdminServicesPresenter(this);
        progressingDialog = new ProgressingDialog();
        progressingDialog.show(getContext());
        adminServicesPresenter.setData();
        View view = inflater.inflate(R.layout.fragment_admin_customer, container, false);
        recyclerView = view.findViewById(R.id.my_recycler_view);
        button = view.findViewById(R.id.customeradder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Add();
            }
        });
        return view;
    }

    @Override
    public void ShowCategories(List<SubCategory> subCatCollection) {
        progressingDialog.dismiss();
        customerServiceRecycleView = new CustomerServiceRecycleView(getContext(), subCatCollection, this);
        recyclerView.setAdapter(customerServiceRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


    public void Delete(SubCategory subCategory) {
        deleteDialog = new DeleteDialog();
        boolean check = deleteDialog.delete(getContext());
        if (check == true) {
            progressingDialog.show(getContext());
            adminServicesPresenter.deleteMainCategory(subCategory);
        }
    }

    private void Add() {
        MyDialog myDialog = new MyDialog();
        if (myDialog.getYesNoWithExecutionStop(getContext())) {
            AddCategory addCategory = new AddCategory();
            addCategory.setMainCategoriesId(3);
            addCategory.setSubCatName(myDialog.getName());
            addCategory.setDescription("General");
            adminServicesPresenter.addMainCategory(addCategory);
            progressingDialog = new ProgressingDialog();
            progressingDialog.show(getContext());
        }
    }
}