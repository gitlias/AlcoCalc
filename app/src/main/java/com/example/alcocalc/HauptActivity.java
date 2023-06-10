package com.example.alcocalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.w3c.dom.NamedNodeMap;

public class HauptActivity extends AppCompatActivity {

    double bw, bac, perc, erg, sel;
    EditText input_bw;
    EditText input_bac;
    EditText input_perc;
    Button button_calc;
    RadioGroup radioGroup;
    RadioButton radioButton;

    String radioTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haupt);

        radioGroup = findViewById(R.id.radioGroup);

        input_bw = (EditText) findViewById(R.id.tf_bodyw);
        input_bac = (EditText) findViewById(R.id.tf_bac);
        input_perc = (EditText) findViewById(R.id.tf_perc);

        button_calc = (Button) findViewById(R.id.bt_calc);
        button_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean error = false;
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                radioTag = radioButton.getTag().toString();
                if(radioTag.equals("beer")){
                    sel = 0.05;
                }if(radioTag.equals("liquor")){
                    sel = 0.25;
                }if(radioTag.equals("spirit")){
                    sel = 0.4;
                }



                try{
                    bw = Double.parseDouble(input_bw.getText().toString());
                    bac = Double.parseDouble(input_bac.getText().toString());
                    if(radioTag.equals("other")){
                        perc = Double.parseDouble(input_perc.getText().toString())/100;
                        sel = bac;
                    }
                }catch (Exception e){
                    error = true;
                    DialogHelper.ocDialog(HauptActivity.this, getString(R.string.no_input_title), getString(R.string.no_input_body));
                }
                if (!error) {
                    //erg = hier berechnung
                    erg = (0.008*bw*bac)/(1000*sel)*1000;








                    DialogHelper.resetDialog(HauptActivity.this, "Benötigte menge Getränk", "Es werden " + erg + "ml Ihres Getränkes benötigt", input_bac, input_bw, input_perc);
                    DialogHelper.resetDialog(HauptActivity.this, "Debug msg", "sel "+sel+" bw "+ bw + " perc " + perc + " bac "+ bac +" radioTag " + radioTag, input_bac, input_bw, input_perc);
                }



            }
        });

    }




    private void showToast(Double num){
        Toast.makeText(HauptActivity.this, Double.toString(num), Toast.LENGTH_SHORT).show();
    }

}