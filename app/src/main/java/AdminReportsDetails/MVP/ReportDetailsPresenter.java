package AdminReportsDetails.MVP;

import AdminReportsDetails.Connection.AdminReportsDetailsRetrofitConnection;
import Connection.Connection;
import POJO.Answers;
import POJO.Report;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by HeshamMuhammed on 5/26/2018.
 */

public class ReportDetailsPresenter implements ReportDetailsInterface.Presenter{
    ReportDetailsInterface.View view;
    AdminReportsDetailsRetrofitConnection adminReportsDetailsRetrofitConnection;
    Call<Report> getReport;
    Call<Report> changeReport;
    Call<ResponseBody> deleteReport;
    Call<Answers> getAnswer;
    int id;

    public ReportDetailsPresenter(ReportDetailsInterface.View view){
        this.view=view;
    }
    @Override
    public void getReport(int id) {
        this.id=id;
        adminReportsDetailsRetrofitConnection = Connection.getConnection().create(AdminReportsDetailsRetrofitConnection.class);
        getReport = adminReportsDetailsRetrofitConnection.getReport(Connection.token,id);
        getReport.enqueue(new Callback<Report>() {
            @Override
            public void onResponse(Call<Report> call, Response<Report> response) {
                if (response != null){
                    view.setReport(response.body());
                }
            }

            @Override
            public void onFailure(Call<Report> call, Throwable t) {

            }
        });
    }

    @Override
    public void changeReport(Report report) {
        adminReportsDetailsRetrofitConnection = Connection.getConnection().create(AdminReportsDetailsRetrofitConnection.class);
        report.setAction(1);
        changeReport = adminReportsDetailsRetrofitConnection.changeReport(report,Connection.token);
        changeReport.enqueue(new Callback<Report>() {
            @Override
            public void onResponse(Call<Report> call, Response<Report> response) {
                if (response != null){
                 }
            }

            @Override
            public void onFailure(Call<Report> call, Throwable t) {

            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        getReport(id);
    }

    @Override
    public void getAnswer(int id) {
        adminReportsDetailsRetrofitConnection = Connection.getConnection().create(AdminReportsDetailsRetrofitConnection.class);
        getAnswer = adminReportsDetailsRetrofitConnection.getAnswer(Connection.token,5);
        getAnswer.enqueue(new Callback<Answers>() {
            @Override
            public void onResponse(Call<Answers> call, Response<Answers> response) {
                if (response!=null){
                    view.setAnswers(response.body());
                }
            }

            @Override
            public void onFailure(Call<Answers> call, Throwable t) {

            }
        });
    }
}