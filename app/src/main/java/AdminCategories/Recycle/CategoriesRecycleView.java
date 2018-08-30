package AdminCategories.Recycle;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.heshammuhammed.ta3ala2ma2a2olkadmin.MainActivity;
import com.example.heshammuhammed.ta3ala2ma2a2olkadmin.R;
import java.util.List;
import AdminCategories.MVP.CategoriesFragment;
import AdminCategoriesDetails.MVP.AdminCategoriesDetailsFragment;
import POJO.SubCategory;


/**
 * Created by HeshamMuhammed on 5/21/2018.
 */

public class CategoriesRecycleView extends RecyclerView.Adapter<MyViewHolder> {

    LayoutInflater layoutInflater;
    Context context;
    List<SubCategory> subCatCollection;
    CategoriesFragment categoriesFragment;

    public CategoriesRecycleView(Context context, List<SubCategory> subCatCollection , CategoriesFragment categoriesFragment) {
        layoutInflater = LayoutInflater.from(context);
        this.subCatCollection = subCatCollection;
        this.context = context;
        this.categoriesFragment = categoriesFragment;
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
                AdminCategoriesDetailsFragment adminCategoriesDetailsFragment = new AdminCategoriesDetailsFragment();
                Bundle bundle = new Bundle();
                FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                bundle.putString("String",subCatCollection.get(position).getSubCatName());
                adminCategoriesDetailsFragment.setArguments(bundle);
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentswitcher, adminCategoriesDetailsFragment, null).addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                SubCategory subCategory = new SubCategory();
                subCategory.setSubCatId(subCatCollection.get(position).getSubCatId());
                categoriesFragment.Delete(subCategory);
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