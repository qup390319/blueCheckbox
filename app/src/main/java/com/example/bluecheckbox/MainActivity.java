package com.example.bluecheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox chk1, chk2;
    TextView tx1;
    RadioButton rad1,rad2,rad3;
    RadioGroup rg1;
    private Spinner spin1;
String[] names=new String[]{"大明","傑哥","阿偉"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx1 = (TextView) findViewById(R.id.textView);
        chk1 = (CheckBox) findViewById(R.id.checkBox1);
        chk2 = (CheckBox) findViewById(R.id.checkBox1);

        rg1 = (RadioGroup) findViewById(R.id.rg1);
        rad1 = (RadioButton) findViewById(R.id.rad1);
        rad2 = (RadioButton) findViewById(R.id.rad2);
        rad3 = (RadioButton) findViewById(R.id.rad3);

        chk1.setOnCheckedChangeListener(myList);
        chk2.setOnCheckedChangeListener(myList);

        rg1.setOnCheckedChangeListener(myRadio);

    }

    private CheckBox.OnCheckedChangeListener myList = new CheckBox.OnCheckedChangeListener()
    {
        //建立ArrayAdapter
        ArrayAdapter<String> adapterNames=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,names);

        //設定Spinner顯示格式
        adapterNames.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String result = "";
            if (chk1.isChecked()) {
                result = "看電影";
            }

            if (chk2.isChecked()) {
                result = "跑步";
            }
            tx1.setText(result);
        }
    };

    private RadioGroup.OnCheckedChangeListener myRadio = new RadioGroup.OnCheckedChangeListener()
    {
        public void onCheckedChanged(RadioGroup Group, int checkedid) {
            String result = "";
            if (rad1.isChecked()){
                result+="台南";
            }
            if (rad2.isChecked()){
                result+="高雄";
            }
            if (rad3.isChecked()){
                result+="雲林";
            }
            tx1.setText(result);

        }
    };
}