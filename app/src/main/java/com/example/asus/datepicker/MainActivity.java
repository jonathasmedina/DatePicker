package com.example.asus.datepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btn;

    private Calendar calendar;

    int ano, mes, dia;
    static final int DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        calendar = Calendar.getInstance();
        ano = calendar.get(Calendar.YEAR);
        mes = calendar.get(Calendar.MONTH);
        dia = calendar.get(Calendar.DAY_OF_MONTH);



        showDialogOnButtonClick();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
            @SuppressWarnings("deprecation")
            public void showDialogOnButtonClick(){
                btn = (Button) findViewById(R.id.button);

                btn.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                showDialog(DIALOG_ID);
                            }
                        }
                );
            }

            @Override
            @SuppressWarnings("deprecation")
            protected Dialog onCreateDialog (int id){
                if (id == DIALOG_ID){
                    //com spinner
                    DatePickerDialog dp = new DatePickerDialog(this, android.R.style.Theme_Holo_Dialog, dpickerListener, ano, mes, dia);
                    dp.getDatePicker().setCalendarViewShown(false);
                    dp.getDatePicker().setSpinnersShown(true);
                    //sem spinner
                        //DatePickerDialog dp = new DatePickerDialog(this, dpickerListener, ano, mes, dia);
                        //dp.getDatePicker().setCalendarViewShown(false);
                        //dp.getDatePicker().setSpinnersShown(true);
                    return dp;
                }
                else
                    return null; //else
            }

            private DatePickerDialog.OnDateSetListener dpickerListener =
                    new DatePickerDialog.OnDateSetListener() { //new ON...
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            ano = year;
                            mes = monthOfYear + 1;
                            dia = dayOfMonth;
                            //exibir..
                            Toast.makeText(MainActivity.this, dia+"/"+mes+"/"+ano, Toast.LENGTH_LONG).show();
                        }
                    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
