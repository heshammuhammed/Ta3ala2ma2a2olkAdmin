package AdminCategories.MVP;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.heshammuhammed.ta3ala2ma2a2olkadmin.R;

import java.util.List;

import AdminCategories.Recycle.CategoriesRecycleView;
import Dialoger.DeleteDialog;
import Dialoger.MyDialog;
import Dialoger.ProgressingDialog;
import POJO.AddCategory;
import POJO.SubCategory;


public class CategoriesFragment extends Fragment implements AdminCategoriesMVPInterface.View {

    AdminCategoriesPresenter adminCategoriesPresenter;
    CategoriesRecycleView categoriesRecyclerView;
    RecyclerView recyclerView;
    Button button;
    ProgressingDialog progressingDialog;
    DeleteDialog deleteDialog;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        adminCategoriesPresenter = new AdminCategoriesPresenter(this);
        progressingDialog = new ProgressingDialog();
        progressingDialog.show(getContext());
        adminCategoriesPresenter.setData();
        View view = inflater.inflate(R.layout.fragment_admin_categories, container, false);
        recyclerView = view.findViewById(R.id.my_recycler_view);
        button = view.findViewById(R.id.categoriesadder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Add();
            }
        });
        return view;
    }

    @Override
    public void ShowCategories(List<SubCategory> subCatCollection, String a) {
        progressingDialog.dismiss();
        categoriesRecyclerView = new CategoriesRecycleView(getContext(), subCatCollection, this);
        recyclerView.setAdapter(categoriesRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    public void Delete(SubCategory subCategory) {
        deleteDialog = new DeleteDialog();
        boolean check = deleteDialog.delete(getContext());
        if (check == true) {
            progressingDialog.show(getContext());
            adminCategoriesPresenter.deleteMainCategory(subCategory);

        }
    }

    private void Add() {
        MyDialog myDialog = new MyDialog();
        if (myDialog.getYesNoWithExecutionStop(getContext())) {
            AddCategory addCategory = new AddCategory();
            addCategory.setMainCategoriesId(1);
            addCategory.setDescription("General");
            addCategory.setSubCatName(myDialog.getName());
            progressingDialog = new ProgressingDialog();
            progressingDialog.show(getContext());
            adminCategoriesPresenter.addMainCategory(addCategory);
        }
    }
}