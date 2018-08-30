package AddCustomer.MVP;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.heshammuhammed.ta3ala2ma2a2olkadmin.R;
import Dialoger.DateDialog;
import Dialoger.ProgressingDialog;
import POJO.CustomerService;
import POJO.User;

public class AddCustomerFragment extends Fragment implements AddingCustomerInterface.View, Communicator.Receiver {

    EditText userName, firstName, lastName, password;
    EditText email, gender, service, joinDate, expiredDate;
    Button addCustomer;
    AddingCustomerPresenter addingCustomerPresenter;
    DateDialog dateDialog;
    ProgressingDialog progressingDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_customer, container, false);
        dateDialog = new DateDialog(getContext(), this);
        userName = view.findViewById(R.id.customerusername);
        firstName = view.findViewById(R.id.customerfirstname);
        lastName = view.findViewById(R.id.customerlastname);
        password = view.findViewById(R.id.customerpassword);
        email = view.findViewById(R.id.customeremail);
        gender = view.findViewById(R.id.customergender);
        service = view.findViewById(R.id.customerservice);
        joinDate = view.findViewById(R.id.customerjoindate);
        expiredDate = view.findViewById(R.id.customerexpireddate);
        addCustomer = view.findViewById(R.id.addingcustomer);
        joinDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateDialog.createDialog(0);
            }
        });

        expiredDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateDialog.createDialog(1);
            }
        });


        addingCustomerPresenter = new AddingCustomerPresenter(this);

        addCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setUsername(userName.getText().toString());
                user.setFirst(firstName.getText().toString());
                user.setLast(lastName.getText().toString());
                user.setPassword(password.getText().toString());
                user.setEmail(email.getText().toString());
                user.setGender(gender.getText().toString());
                user.setEnabled(true);
                user.setType("CustomerService");
                addingCustomerPresenter.registerPerson(user);
                CustomerService customerService = new CustomerService();
                customerService.setService(service.getText().toString());
                customerService.setJoinDate(joinDate.getText().toString());
                customerService.setExpDate(expiredDate.getText().toString());
                addingCustomerPresenter.addCustomer(customerService);
                progressingDialog = new ProgressingDialog();
                progressingDialog.show(getContext());
            }
        });
        return view;
    }

    @Override
    public void setData(String text) {
        progressingDialog.dismiss();
    }

    @Override
    public void getJoinDate(String date) {
        joinDate.setText(date.toString());
    }

    @Override
    public void getExpiredDate(String date) {
        expiredDate.setText(date.toString());
    }
}
