package com.example.datetimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TimePicker timePicker;
    TextView timetextview;
    DatePicker datePicker;
    TextView datetextview;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = findViewById(R.id.timrpicker);
        timetextview = findViewById(R.id.timetext);
        datePicker = findViewById(R.id.datepicker);
        button = findViewById(R.id.submit);
        datetextview = findViewById(R.id.datetext);


        timePicker.setIs24HourView(false);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(getApplicationContext(),"Time :: "+hourOfDay+":"+minute,Toast.LENGTH_SHORT).show();
                timetextview.setText("Time ::" +hourOfDay+":"+minute);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day=datePicker.getDayOfMonth();
                int month=datePicker.getMonth();
                int year=datePicker.getYear();

                datetextview.setText("Date ::"+day +"-"+month+"-"+year);

            }
        });

    }
}
