package AdminCustomerService.Recycle;

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

import AdminCategoriesDetails.MVP.AdminCategoriesDetailsFragment;
import AdminCustomerService.MVP.CustomerServiceFragment;
import AdminCustomerServiceDetails.MVP.AdminCustomerServiceFragment;
import AllQuestions.MVP.QuestionListFragment;
import POJO.SubCategory;


/**
 * Created by HeshamMuhammed on 5/21/2018.
 */

public class CustomerServiceRecycleView extends RecyclerView.Adapter<MyViewHolder> {

    LayoutInflater layoutInflater;
    Context context;
    List<SubCategory> subCatCollection;
    CustomerServiceFragment customerServiceFragment ;
    public CustomerServiceRecycleView(Context context, List<SubCategory> subCatCollection , CustomerServiceFragment customerServiceFragment) {
        layoutInflater = LayoutInflater.from(context);
        this.subCatCollection = subCatCollection;
        this.customerServiceFragment = customerServiceFragment;
        this.context = context;
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
                //
                MainActivity mainActivity = (MainActivity) context;
                QuestionListFragment questionListFragment = new QuestionListFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("id",subCatCollection.get(position).getSubCatId());
                questionListFragment.setArguments(bundle);
                FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentswitcher, questionListFragment, null).addToBackStack(null);
                fragmentTransaction.commit();
                //
            }
        });

        holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                SubCategory subCategory = new SubCategory();
                subCategory.setSubCatId(subCatCollection.get(position).getSubCatId());
                customerServiceFragment.Delete(subCategory);
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