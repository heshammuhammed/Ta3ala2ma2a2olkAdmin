package AdminPlaces.MVP;

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
import AdminPlaces.Recycle.PlacesRecycleView;
import Dialoger.DeleteDialog;
import Dialoger.ProgressingDialog;
import POJO.AddCategory;
import POJO.SubCategory;
import Dialoger.MyDialog;

public class PlacesFragment extends Fragment implements AdminPlacesMVPInterface.View {

    AdminPlacesPresenter adminPlacesPresenter;
    private RecyclerView recyclerView;
    PlacesRecycleView placesRecycleView;
    Button button;
    ProgressingDialog progressingDialog ;
    DeleteDialog deleteDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_places, container, false);
        adminPlacesPresenter = new AdminPlacesPresenter(this);
        progressingDialog = new ProgressingDialog();
        progressingDialog.show(getContext());
        adminPlacesPresenter.setData();
        button = view.findViewById(R.id.placesadder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Add();
            }
        });
        recyclerView = view.findViewById(R.id.my_recycler_view);
        return view;
    }

    @Override
    public void ShowCategories(List<SubCategory> subCatCollection) {
        progressingDialog.dismiss();
        placesRecycleView = new PlacesRecycleView(getContext(), subCatCollection, this);
        recyclerView.setAdapter(placesRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    public void Delete(SubCategory subCategory) {
        deleteDialog = new DeleteDialog();
        boolean check = deleteDialog.delete(getContext());
        if (check == true){
            progressingDialog.show(getContext());
            adminPlacesPresenter.deleteMainCategory(subCategory);
        }
    }

    private void Add() {
        MyDialog myDialog = new MyDialog();
        if (myDialog.getYesNoWithExecutionStop(getContext())){
            AddCategory addCategory = new AddCategory();
            addCategory.setMainCategoriesId(2);
            addCategory.setDescription("General");
            addCategory.setSubCatName(myDialog.getName());
            adminPlacesPresenter.addMainCategory(addCategory);
            progressingDialog = new ProgressingDialog();
            progressingDialog.show(getContext());
        }
    }
}