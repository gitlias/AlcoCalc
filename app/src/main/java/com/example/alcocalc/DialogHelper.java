package com.example.alcocalc;



import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.provider.Settings;
import android.widget.EditText;

public class DialogHelper {


    public static void ocDialog(Context context, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public static void resetDialog(Context context, String title, String message, EditText text1, EditText text2, EditText text3) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Reset", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                reset3Fields(text1, text2, text3);


            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public static void reset3Fields(EditText text1, EditText text2, EditText text3){
        text1.setText("");
        text2.setText("");
        text3.setText("");
    }

}
