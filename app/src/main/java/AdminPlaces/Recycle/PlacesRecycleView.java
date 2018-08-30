package AdminPlaces.Recycle;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.heshammuhammed.ta3ala2ma2a2olkadmin.MainActivity;
import com.example.heshammuhammed.ta3ala2ma2a2olkadmin.R;

import java.util.List;

import AdminCustomerServiceDetails.MVP.AdminCustomerServiceFragment;
import AdminPlaces.MVP.PlacesFragment;
import AdminPlacesDetails.MVP.AdminPlacesDetailsFragment;
import POJO.SubCategory;


/**
 * Created by HeshamMuhammed on 5/21/2018.
 */

public class PlacesRecycleView extends RecyclerView.Adapter<MyViewHolder> {

    LayoutInflater layoutInflater;
    Context context;
    List<SubCategory> subCatCollection;
    PlacesFragment placesFragment;

    public PlacesRecycleView(Context context, List<SubCategory> subCatCollection , PlacesFragment placesFragment) {
        layoutInflater = LayoutInflater.from(context);
        this.subCatCollection = subCatCollection;
        this.context = context;
        this.placesFragment = placesFragment;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.single_row, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final int number = position;
        holder.textView.setText(subCatCollection.get(position).getSubCatName());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) context;
                AdminPlacesDetailsFragment adminPlacesDetailsFragment = new AdminPlacesDetailsFragment();
                Bundle bundle = new Bundle();
                bundle.putString("String",subCatCollection.get(position).getSubCatName());
                adminPlacesDetailsFragment.setArguments(bundle);
                FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                 FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentswitcher, adminPlacesDetailsFragment, null).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                SubCategory subCategory = new SubCategory();
                subCategory.setSubCatId(subCatCollection.get(position).getSubCatId());
                placesFragment.Delete(subCategory);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return subCatCollection.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public MyViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.mytext);
    }

}