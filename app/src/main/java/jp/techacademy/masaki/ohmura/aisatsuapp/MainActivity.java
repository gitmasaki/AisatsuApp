package jp.techacademy.masaki.ohmura.aisatsuapp;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

    }
    int Hour = 1 ;
    int Minute =0 ;

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            TextView textView = (TextView) findViewById(R.id.textView);

            if (Hour >= 2 && Hour < 10) {
                textView.setText("おはよう");
            }
            else if (Hour >= 10 && Hour < 18) {
                textView.setText("こんにちは");
            }
            else {
                textView.setText("こんばんは");
            }
        } else if (v.getId() == R.id.button2) {
            showTimePickerDialog();
        }
    }

    public void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,  int minute) {
                        Hour = hourOfDay;
                        Minute = minute;
                    }
                },
                Hour,
                Minute,
                true);
        timePickerDialog.show();

    }
}