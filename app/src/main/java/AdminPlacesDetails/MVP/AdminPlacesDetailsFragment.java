package AdminPlacesDetails.MVP;

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

import AdminPlacesDetails.Recycle.AdminPlacesDetailsRecycleView;
import Dialoger.DeleteDialog;
import Dialoger.ProgressingDialog;
import POJO.AddCategory;
import POJO.SubCategory;
import Dialoger.MyDialog;

public class AdminPlacesDetailsFragment extends Fragment implements AdminPlacesDetailsInterface.View {

    RecyclerView recyclerView;
    AdminPlacesDetailsPresenter adminPlacesDetailsPresenter;
    AdminPlacesDetailsRecycleView adminPlacesDetailsRecycleView;
    Button button;
    TextView title;
    String name;
    ProgressingDialog progressingDialog;
    DeleteDialog deleteDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_admin_places_details, container, false);
        title = view.findViewById(R.id.placedetails);
        recyclerView = view.findViewById(R.id.my_recycler_view);
        adminPlacesDetailsPresenter = new AdminPlacesDetailsPresenter(this);
        Bundle bundle = getArguments();
        name = bundle.getString("String");
        title.setText(name);
        progressingDialog = new ProgressingDialog();
        progressingDialog.show(getContext());
        adminPlacesDetailsPresenter.setData(name);
        button = view.findViewById(R.id.adminaddplace);
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
        adminPlacesDetailsRecycleView = new AdminPlacesDetailsRecycleView(getContext(), subCatCollection, this);
        recyclerView.setAdapter(adminPlacesDetailsRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    public void Delete(SubCategory subCategory) {
        deleteDialog = new DeleteDialog();
        boolean check = deleteDialog.delete(getContext());
        if (check == true) {
            progressingDialog.show(getContext());
            adminPlacesDetailsPresenter.deleteMainCategory(subCategory);
        }
    }

    private void Add() {
        MyDialog myDialog = new MyDialog();
        if (myDialog.getYesNoWithExecutionStop(getContext())) {
            AddCategory addCategory = new AddCategory();
            addCategory.setMainCategoriesId(2);
            addCategory.setSubCatName(name);
            addCategory.setDescription(myDialog.getName());
            adminPlacesDetailsPresenter.addMainCategory(addCategory);
            progressingDialog = new ProgressingDialog();
            progressingDialog.show(getContext());
        }
    }
}