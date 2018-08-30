package AllQuestions.Recycle;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.heshammuhammed.ta3ala2ma2a2olkadmin.MainActivity;
import com.example.heshammuhammed.ta3ala2ma2a2olkadmin.R;
import java.util.List;

import AllAnswers.MVP.AllAnswersFragment;
import AllQuestions.MVP.QuestionListFragment;
import POJO.Question;

/**
 * Created by HeshamMuhammed on 6/9/2018.
 */

public class QuestionRecycleView extends RecyclerView.Adapter<MyViewHolder>{

    LayoutInflater layoutInflater;
    Context context;
    List<Question> questions;
    QuestionListFragment questionListFragment;

    public QuestionRecycleView(Context context  ,List<Question> questions , QuestionListFragment questionListFragment ) {
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.questions = questions;
        this.questionListFragment = questionListFragment;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.allquestiondetails, parent, false);
       MyViewHolder myViewHolder = new MyViewHolder(view);
         return myViewHolder;
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, final int position) {
        try {
            holder.questionTitle.setText((questions.get(position).getTitle().toString()) + " ");
            holder.questionDate.setText((questions.get(position).getQuestionDate().toString()) + " ");
            holder.getQuestionCount.setText((questions.get(position).getNumOfAns().toString()) + " ");
        }
        catch ( Exception e){

        }
        holder.questionTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                MainActivity mainActivity = (MainActivity) context;
                AllAnswersFragment allAnswersFragment = new AllAnswersFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("id",questions.get(position).getQuestionId());
                allAnswersFragment.setArguments(bundle);
                FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentswitcher, allAnswersFragment, null).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        holder.questionTitle.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                questionListFragment.deleteQuestion(questions.get(position).getQuestionId());
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

}

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView questionDate;
    TextView questionTitle;
    TextView getQuestionCount;

    public MyViewHolder(View itemView) {
        super(itemView);
        questionDate = itemView.findViewById(R.id.questiondate);
        questionTitle = itemView.findViewById(R.id.questiontitle);
        getQuestionCount = itemView.findViewById(R.id.questioncount);
    }
}
