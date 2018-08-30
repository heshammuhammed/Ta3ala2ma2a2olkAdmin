package AdminUsers.MVP;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.heshammuhammed.ta3ala2ma2a2olkadmin.R;

import java.util.List;

import AdminUsers.Recycle.UserRecycleView;
import Dialoger.DeleteDialog;
import Dialoger.ProgressingDialog;
import POJO.AllUsers;


public class UsersFragment extends Fragment implements MyInterface.View {
    UserRecycleView userRecycleView;
    RecyclerView recyclerView;
    Presenter presenter;
    List<AllUsers> list;
    public String message;
    TextView listofNames;
    ProgressingDialog progressingDialog;
    DeleteDialog deleteDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_users, container, false);
        listofNames = view.findViewById(R.id.showinfo);
        presenter = new Presenter(this);
        progressingDialog = new ProgressingDialog();
        progressingDialog.show(getContext());
        Bundle bundle = getArguments();
        message = bundle.getString("KEY");
        if (message.equals("1")) {
            presenter.getUserData();
            listofNames.setText("Users");

        } else if (message.equals("2")){
            presenter.getCustomerData();
            listofNames.setText("Customer Services");
        }
        recyclerView = view.findViewById(R.id.my_recycler_view);
        return view;
    }

    @Override
    public void sendData(List<AllUsers> list) {
        progressingDialog.dismiss();
        this.list = list;
        userRecycleView = new UserRecycleView(getActivity(), list , this);
        recyclerView.setAdapter(userRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    public void deletePerson(int id){
        deleteDialog = new DeleteDialog();
        boolean check = deleteDialog.delete(getContext());
        if (check == true) {
            presenter.deletePerson(id);
        }

    }
}