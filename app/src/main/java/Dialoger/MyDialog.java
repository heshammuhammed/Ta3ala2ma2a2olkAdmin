package Dialoger;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.EditText;

/**
 * Created by HeshamMuhammed on 5/31/2018.
 */

public class MyDialog {

    private EditText editText;
    private String name;
    private boolean mResult;


    public boolean getYesNoWithExecutionStop(Context context) {
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message mesg) {
                throw new RuntimeException();
            }
        };
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("Enter Your Category");
        alert.setMessage("Category Name");
        editText = new EditText(context);
        alert.setView(editText);
        alert.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                mResult = true;
                name = editText.getText().toString();
                handler.sendMessage(handler.obtainMessage());
            }
        });
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                mResult = false;
                handler.sendMessage(handler.obtainMessage());
            }
        });
        alert.show();
        try {
            Looper.loop();
        } catch (RuntimeException e2) {
        }
        return mResult;
    }

    public String getName(){
        return name;
    }

}
