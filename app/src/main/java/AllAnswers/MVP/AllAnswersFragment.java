package AllAnswers.MVP;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.heshammuhammed.ta3ala2ma2a2olkadmin.R;

import java.util.List;
import java.util.Timer;

import AllAnswers.Recycle.AnswerRecycleView;
import AllQuestions.Recycle.QuestionRecycleView;
import Dialoger.DeleteDialog;
import Dialoger.ProgressingDialog;
import POJO.Answers;

public class AllAnswersFragment extends Fragment implements SelectAllAnswers.View {

    AllAnswersPresenter allAnswersPresenter;
    AnswerRecycleView answerRecycleView;
    RecyclerView recyclerView;
    ProgressingDialog progressingDialog;
    DeleteDialog deleteDialog;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        allAnswersPresenter = new AllAnswersPresenter(this);
        Bundle bundle = getArguments();
        int id = bundle.getInt("id");
        progressingDialog = new ProgressingDialog();
        progressingDialog.show(getContext());
        allAnswersPresenter.getAnswers(id);
        View view = inflater.inflate(R.layout.fragment_all_answers, container, false);
        recyclerView = view.findViewById(R.id.answersrecycleview);
        return view;
    }

    @Override
    public void ViewAnswers(List<Answers> answers) {
        progressingDialog.dismiss();
        answerRecycleView = new AnswerRecycleView(getContext(), answers , this);
        recyclerView.setAdapter(answerRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    public void deleteQuestion(int id){
        deleteDialog = new DeleteDialog();
        boolean check = deleteDialog.delete(getContext());
        if (check == true) {
            progressingDialog.show(getContext());
            allAnswersPresenter.deleteAnswers(id);
        }
    }
}