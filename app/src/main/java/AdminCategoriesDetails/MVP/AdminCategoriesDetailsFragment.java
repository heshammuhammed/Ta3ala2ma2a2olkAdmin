package AdminCategoriesDetails.MVP;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.heshammuhammed.ta3ala2ma2a2olkadmin.R;

import org.w3c.dom.Text;

import java.util.List;

import AdminCategoriesDetails.Recycle.AdminCategoriesDetailsRecycleView;
import AdminCustomerServiceDetails.MVP.AdminCustomerServiceDetailsInterface;
import Dialoger.DeleteDialog;
import Dialoger.ProgressingDialog;
import POJO.AddCategory;
import POJO.SubCategory;
import Dialoger.MyDialog;

public class AdminCategoriesDetailsFragment extends Fragment implements AdminCategoriesDetailsInterface.View {

    RecyclerView recyclerView;
    AdminCategoriesDetailsPresenter adminCategoriesDetailsPresenter;
    AdminCategoriesDetailsRecycleView adminCategoriesDetailsRecycleView;
    Button button;
    TextView title;
    String name;
    ProgressingDialog progressingDialog;
    DeleteDialog deleteDialog;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_categories_details, container, false);
        title = view.findViewById(R.id.categoriedetails);
        adminCategoriesDetailsPresenter = new AdminCategoriesDetailsPresenter(this);
        recyclerView = view.findViewById(R.id.my_recycler_view);
        Bundle bundle = getArguments();
        name = bundle.getString("String");
        title.setText(name.toString());
        progressingDialog = new ProgressingDialog();
        progressingDialog.show(getContext());
        adminCategoriesDetailsPresenter.setData(name);
        button = view.findViewById(R.id.adminaddcategory);
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
        progressingDialog.dismiss();
        adminCategoriesDetailsRecycleView = new AdminCategoriesDetailsRecycleView(getContext(), subCatCollection, this);
        recyclerView.setAdapter(adminCategoriesDetailsRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    public void Delete(SubCategory subCategory) {
        deleteDialog = new DeleteDialog();
        boolean check = deleteDialog.delete(getContext());
        if (check == true) {
            progressingDialog.show(getContext());
            adminCategoriesDetailsPresenter.deleteMainCategory(subCategory);
        }
    }

    private void Add() {
        MyDialog myDialog = new MyDialog();
        if (myDialog.getYesNoWithExecutionStop(getContext())) {
            AddCategory addCategory = new AddCategory();
            addCategory.setMainCategoriesId(1);
            addCategory.setSubCatName(name);
            addCategory.setDescription(myDialog.getName());
            adminCategoriesDetailsPresenter.addMainCategory(addCategory);
            progressingDialog = new ProgressingDialog();
            progressingDialog.show(getContext());
        }
    }
}