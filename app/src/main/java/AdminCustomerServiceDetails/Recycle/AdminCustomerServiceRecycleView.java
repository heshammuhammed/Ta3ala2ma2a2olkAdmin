package AdminCustomerServiceDetails.Recycle;

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
import android.widget.Toast;

import com.example.heshammuhammed.ta3ala2ma2a2olkadmin.MainActivity;
import com.example.heshammuhammed.ta3ala2ma2a2olkadmin.R;
import java.util.List;
import AdminCustomerServiceDetails.MVP.AdminCustomerServiceFragment;
import AllQuestions.MVP.QuestionListFragment;
import POJO.SubCategory;

/**
 * Created by HeshamMuhammed on 5/21/2018.
 */

public class AdminCustomerServiceRecycleView extends RecyclerView.Adapter<MyViewHolder> {

    LayoutInflater layoutInflater;
    Context context;
    List<SubCategory> subCatCollection;
    AdminCustomerServiceFragment adminCustomerServiceFragment;

    public AdminCustomerServiceRecycleView(Context context, List<SubCategory> subCatCollection , AdminCustomerServiceFragment adminCustomerServiceFragment ) {
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.adminCustomerServiceFragment = adminCustomerServiceFragment;
        this.subCatCollection = subCatCollection;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.single_row, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        Log.e("Check", "1");
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final int number = position;
        holder.textView.setText(subCatCollection.get(position).getDescription());
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
                adminCustomerServiceFragment.Delete(subCategory);
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