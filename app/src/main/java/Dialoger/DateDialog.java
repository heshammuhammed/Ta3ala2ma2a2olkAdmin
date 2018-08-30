package Dialoger;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.DatePicker;
import java.util.Calendar;
import AddCustomer.MVP.Communicator;

/**
 * Created by HeshamMuhammed on 6/12/2018.
 */

public class DateDialog implements DatePickerDialog.OnDateSetListener {

    Context context;
    Communicator.Receiver receiver;
    int value;

    public DateDialog(Context context , Communicator.Receiver receiver){
        this.context = context;
        this.receiver = receiver;
    }

    public void createDialog(int value){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        this.value = value;
        DatePickerDialog datePickerDialog = new DatePickerDialog(context,android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                this,year,month,day);
        datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        month = month+1;

        String yearString = year+"";
        String monthString;
        String dayString;

        if (day<10){
            dayString = "0"+day;
        }else{
            dayString = day+"";
        }

        if (month<10){
            monthString="0"+month;
        }else{
            monthString=month+"";
        }

        if (value == 0){
            receiver.getJoinDate(yearString+"-"+monthString+"-"+dayString);
        }else if (value == 1){
            receiver.getExpiredDate(yearString+"-"+monthString+"-"+dayString);
        }
    }
}