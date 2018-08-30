package CustomerServiceData.MVP;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.heshammuhammed.ta3ala2ma2a2olkadmin.R;
import com.squareup.picasso.Picasso;

import Dialoger.ProgressingDialog;
import POJO.User;

public class CustomerDetailsFragment extends Fragment implements CustomerDetailsInterface.View {

    CustomerDetailsPresenter customerDetailsPresenter;
    TextView username , firstname , lastname;
    TextView email , gender , service , joindate , expireddate;
    ProgressingDialog progressingDialog;
    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        customerDetailsPresenter = new CustomerDetailsPresenter(this);
        Bundle bundle = getArguments();
        int id = bundle.getInt("ID");
        progressingDialog = new ProgressingDialog();
        progressingDialog.show(getContext());
        customerDetailsPresenter.getData(id);
        View view = inflater.inflate(R.layout.fragment_customer_details, container, false);
        username = view.findViewById(R.id.customerusernametext);
        firstname = view.findViewById(R.id.customerfirstnametext);
        lastname = view.findViewById(R.id.customerlastnametext);
        email = view.findViewById(R.id.customeremailtext);
        gender = view.findViewById(R.id.customergendertext);
        service = view.findViewById(R.id.customerservicetext);
        joindate = view.findViewById(R.id.customerjoindatetext);
        expireddate = view.findViewById(R.id.customerexpireddatetext);
        imageView = view.findViewById(R.id.myimage);
        return view;
    }

    @Override
    public void setData(User user) {
        progressingDialog.dismiss();
        username.setText(user.getUsername().toString());
        firstname.setText(user.getFirst().toString());
        lastname.setText(user.getLast().toString());
        email.setText(user.getEmail().toString());
        gender.setText(user.getGender().toString());
        service.setText(user.getCustomerService().getService());
        joindate.setText(user.getCustomerService().getJoinDate());
        expireddate.setText(user.getCustomerService().getExpDate());
        Picasso.with(getActivity()).load(user.getImage()).placeholder(R.drawable.user).into(imageView);
        TextViewCompat.setAutoSizeTextTypeWithDefaults(email, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);

    }
}