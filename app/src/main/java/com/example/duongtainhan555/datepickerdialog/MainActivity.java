package com.example.duongtainhan555.datepickerdialog;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText edDate;
    private int date,month,year;
    private Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        Init();
        GetTime();
        SelectDate();
    }

    private void Init()
    {
        edDate = findViewById(R.id.edDate);
    }
    private void GetTime()
    {
        calendar = Calendar.getInstance();
        date = calendar.get(Calendar.DATE);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);

    }
    private void SelectDate()
    {
        edDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        // i --> year, i1 --> month, i2 --> date
                        calendar.set(i,i1,i2);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        edDate.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                }, year, month, date);
                datePickerDialog.show();
            }
        });
    }
}
