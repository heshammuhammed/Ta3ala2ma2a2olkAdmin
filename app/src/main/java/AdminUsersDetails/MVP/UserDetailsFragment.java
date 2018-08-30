package AdminUsersDetails.MVP;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.heshammuhammed.ta3ala2ma2a2olkadmin.R;
import com.squareup.picasso.Picasso;

import Dialoger.ProgressingDialog;
import POJO.AllUsers;
import POJO.TaaUser;
import POJO.User;


public class UserDetailsFragment extends Fragment implements MyInterface.View {
    TextView username, firstName, lastName, id, email, gender, enabled,
            rate, phone, city, district, country;
    Switch switchButton;
    Presenter presenter;
    TaaUser user;
    ImageView imageView;
    ProgressingDialog progressingDialog;

    int check = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_user_details, container, false);
        Bundle bundle = getArguments();
        presenter = new Presenter(this);
        int personID = bundle.getInt("ID");
        username = view.findViewById(R.id.namedetails);
        firstName = view.findViewById(R.id.firstnamedetails);
        lastName = view.findViewById(R.id.lastnamedetails);
        id = view.findViewById(R.id.iddetails);
        email = view.findViewById(R.id.emaildetails);
        gender = view.findViewById(R.id.genderdetails);
        enabled = view.findViewById(R.id.enableddetails);
        rate = view.findViewById(R.id.ratedetails);
        phone = view.findViewById(R.id.phonedetails);
        city = view.findViewById(R.id.citydetails);
        district = view.findViewById(R.id.districtdetails);
        country = view.findViewById(R.id.countrydetails);
        imageView = view.findViewById(R.id.userimage);
        switchButton = view.findViewById(R.id.switchdetails);
        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (check >= 1) {
                    presenter.changeState(user.getPerson());
                } else {

                }
            }
        });
        progressingDialog = new ProgressingDialog();
        progressingDialog.show(getContext());
        presenter.getData(personID);
        return view;
    }

    @Override
    public void sendData(TaaUser user) {
        progressingDialog.dismiss();
        check = 0;
        this.user = user;
        try {
            username.setText(user.getPerson().getUsername());
            firstName.setText(user.getPerson().getFirst());
            lastName.setText(user.getPerson().getLast());
            id.setText(user.getPersonId() + "");
            email.setText(user.getPerson().getEmail());
            gender.setText(user.getPerson().getGender());
            enabled.setText(user.getPerson().getEnabled().toString() + "");
            rate.setText(user.getRate() + "");
            phone.setText(user.getPhone() + "");
            city.setText(user.getCity());
            district.setText(user.getDistrict());
            country.setText(user.getCountry());
            Picasso.with(getActivity()).load(user.getPerson().getImage()).placeholder(R.drawable.user).into(imageView);


            if (user.getPerson().getEnabled() == true) {
                switchButton.setChecked(true);
            } else {
                switchButton.setChecked(false);
            }
            check++;

        } catch (Exception e) {

       }
    }
}