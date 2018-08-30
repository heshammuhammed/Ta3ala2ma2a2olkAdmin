package AdminReports.MVP;

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
import AdminReports.Recycle.ReportsRecycleView;
import Dialoger.ProgressingDialog;
import POJO.AllReports;

/**
 * Created by HeshamMuhammed on 5/21/2018.
 */


public class ReportsFragment extends Fragment implements AdminReportsInterface.View {

    AdminReportsPresenter adminReportsPresenter;
    ReportsRecycleView reportsRecycleView ;
    RecyclerView recyclerView;
    List<AllReports> getReports;
    ProgressingDialog progressingDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        adminReportsPresenter = new AdminReportsPresenter(this);
        progressingDialog = new ProgressingDialog();
        progressingDialog.show(getContext());
        adminReportsPresenter.getData();

        View view = inflater.inflate(R.layout.fragment_admin_reports, container, false);
        recyclerView = view.findViewById(R.id.my_recycler_view);
        return view;
    }

    @Override
    public void sendData(List<AllReports> getReports) {
        progressingDialog.dismiss();
        this.getReports=getReports;
        reportsRecycleView = new ReportsRecycleView(getContext(),getReports);
        recyclerView.setAdapter(reportsRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}