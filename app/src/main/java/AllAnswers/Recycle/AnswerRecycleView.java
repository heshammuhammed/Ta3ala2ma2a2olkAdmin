package AllAnswers.Recycle;

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

import AdminUsersDetails.MVP.UserDetailsFragment;
import AllAnswers.MVP.AllAnswersFragment;
import POJO.AllUsers;
import POJO.Answers;

/**
 * Created by HeshamMuhammed on 6/9/2018.
 */

public class AnswerRecycleView extends RecyclerView.Adapter<MyViewHolder> {

    LayoutInflater layoutInflater;
    Context context;
    List<Answers> answers;
    AllAnswersFragment allAnswersFragment;

    public AnswerRecycleView(Context context, List<Answers> answers, AllAnswersFragment allAnswersFragment) {
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.answers = answers;
        this.allAnswersFragment = allAnswersFragment;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.allanswersdetails, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.theAnswer.setText(answers.get(position).getAnswer()+" ");
        holder.theAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) context;
                FragmentManager fragmentManager = mainActivity.getSupportFragmentManager() ;
                Bundle bundle = new Bundle();
                bundle.putInt("ID",answers.get(position).getPersonId().getPersonId());
                UserDetailsFragment userDetailsFragment = new UserDetailsFragment();
                userDetailsFragment.setArguments(bundle);
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction() ;
                fragmentTransaction.replace(R.id.fragmentswitcher,userDetailsFragment,null).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        holder.theAnswer.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                allAnswersFragment.deleteQuestion(answers.get(position).getAnswersId());
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return answers.size();
    }

}

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView theAnswer;

    public MyViewHolder(View itemView) {
        super(itemView);
        theAnswer = itemView.findViewById(R.id.theanswer);
    }
}