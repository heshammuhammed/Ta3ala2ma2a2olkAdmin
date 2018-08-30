package AdminUsers.Recycle;

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
import java.util.Collections;
import java.util.List;

import AdminUsers.MVP.UsersFragment;
import AdminUsersDetails.MVP.UserDetailsFragment;
import CustomerServiceData.MVP.CustomerDetailsFragment;
import POJO.AllUsers;

/**
 * Created by HeshamMuhammed on 5/21/2018.
 */

public class UserRecycleView extends RecyclerView.Adapter<MyViewHolder> {

    LayoutInflater layoutInflater;
    List<AllUsers> list = Collections.emptyList();
    Context context;
    UsersFragment usersFragment;

    public UserRecycleView(Context context , List<AllUsers> list , UsersFragment usersFragment) {
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.list = list;
        this.usersFragment = usersFragment;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.single_row, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
         final int number = position;
        holder.textView.setText(list.get(position).getUsername());
        holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                usersFragment.deletePerson(list.get(position).getId());
                return true;
            }
        });
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (usersFragment.message.equals("1")){
                    AllUsers person = list.get(position);
                    MainActivity mainActivity = (MainActivity) context;
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager() ;
                    Bundle bundle = new Bundle();
                    bundle.putInt("ID",person.getId());
                    UserDetailsFragment userDetailsFragment = new UserDetailsFragment();
                    userDetailsFragment.setArguments(bundle);
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction() ;
                    fragmentTransaction.replace(R.id.fragmentswitcher,userDetailsFragment,null).addToBackStack(null);
                    fragmentTransaction.commit();
                }else if (usersFragment.message.equals("2")){
                    MainActivity mainActivity = (MainActivity) context;
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager() ;
                    Bundle bundle = new Bundle();
                    bundle.putInt("ID",list.get(position).getId());
                    CustomerDetailsFragment customerDetailsFragment = new CustomerDetailsFragment();
                    customerDetailsFragment.setArguments(bundle);
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction() ;
                    fragmentTransaction.replace(R.id.fragmentswitcher,customerDetailsFragment,null).addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });
    }

    @Override
    public int getItemCount(){
        return list.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView textView;
    public MyViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.mytext);
    }

}