package AllQuestions.MVP;

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

import AdminCategories.Recycle.CategoriesRecycleView;
import AllQuestions.Recycle.QuestionRecycleView;
import Dialoger.DeleteDialog;
import Dialoger.ProgressingDialog;
import POJO.AllQuestion;
import POJO.Question;


public class QuestionListFragment extends Fragment implements SelectAllQuestions.view {
    QuestionsPresenter questionsPresenter;
    QuestionRecycleView questionRecycleView;
    RecyclerView recyclerView;
    ProgressingDialog progressingDialog;
    DeleteDialog deleteDialog;
    public int categoryId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        questionsPresenter = new QuestionsPresenter(this);
        View view = inflater.inflate(R.layout.fragment_question_list, container, false);
        Bundle bundle = getArguments();
        int id = bundle.getInt("id");
        this.categoryId = id;
        questionsPresenter.getData(id);
        deleteDialog = new DeleteDialog();
        progressingDialog = new ProgressingDialog();
        progressingDialog.show(getContext());
        recyclerView = view.findViewById(R.id.questionRecycleView);
        return view;
    }

    @Override
    public void getQuestions(AllQuestion allQuestions  , int idd) {
         progressingDialog.dismiss();
        List<Question> questions = allQuestions.getQuestions();
        questionRecycleView = new QuestionRecycleView(getContext(), questions , this);
        recyclerView.setAdapter(questionRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    public void deleteQuestion(int id) {
        boolean check = deleteDialog.delete(getContext());
        if (check == true) {
            progressingDialog.show(getContext());
            questionsPresenter.deleteQuestion(id);
        }
    }
}
