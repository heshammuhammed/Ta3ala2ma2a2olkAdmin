package AdminReportsDetails.MVP;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.heshammuhammed.ta3ala2ma2a2olkadmin.MainActivity;
import com.example.heshammuhammed.ta3ala2ma2a2olkadmin.R;

import AdminUsersDetails.MVP.UserDetailsFragment;
import AllAnswers.MVP.AllAnswersFragment;
import POJO.AllReports;
import POJO.AllUsers;
import POJO.Answers;
import POJO.Report;

public class ReportDetailsFragment extends Fragment implements ReportDetailsInterface.View{
    ReportDetailsPresenter reportDetailsPresenter;
    TextView id , message , type  , date , title;
    Button  showUser , showQuestion;
    Report report;
    Answers answers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report_details, container, false);
        reportDetailsPresenter = new ReportDetailsPresenter(this);
        Bundle bundle = getArguments();
        AllReports reporttemp = (AllReports) bundle.getSerializable("REPORT");

        reportDetailsPresenter.getReport(reporttemp.getId());
        id = view.findViewById(R.id.reportId);
        message = view.findViewById(R.id.reportMessage);
        type = view.findViewById(R.id.reportType);
        date = view.findViewById(R.id.reportDate);
        showUser = view.findViewById(R.id.reportuser);
        title = view.findViewById(R.id.textView5);
        showQuestion = view.findViewById(R.id.reportquestion);
        showUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = answers.getPersonId().getPersonId();
                MainActivity mainActivity = (MainActivity) getActivity();
                FragmentManager fragmentManager = mainActivity.getSupportFragmentManager() ;
                Bundle bundle = new Bundle();
                bundle.putInt("ID",id);
                UserDetailsFragment userDetailsFragment = new UserDetailsFragment();
                userDetailsFragment.setArguments(bundle);
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction() ;
                fragmentTransaction.replace(R.id.fragmentswitcher,userDetailsFragment,null).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        showQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = answers.getQuestionId().getQuestionId();
                MainActivity mainActivity = (MainActivity) getActivity();
                AllAnswersFragment allAnswersFragment = new AllAnswersFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("id",id);
                allAnswersFragment.setArguments(bundle);
                FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentswitcher, allAnswersFragment, null).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return  view;
    }

    @Override
    public void setReport(Report report) {
        this.report = report;
        id.setText(report.getReportId()+"");
        message.setText(report.getTitle());
        type.setText(report.getType());
        date.setText(report.getReportDate()+"");
        title.setText(report.getMsg());
        reportDetailsPresenter.getAnswer(report.getChecked());
    }

    @Override
    public void setAnswers(Answers answers) {
        this.answers = answers;
    }
}