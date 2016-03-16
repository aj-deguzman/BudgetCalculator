package com.deguzman.budgetcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DisplayResults extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener, View.OnClickListener {

    //LogCat
    private static final String TAG = "LogCat";

    //declare variables
    private TextView results;
    //private Button saveButton;
    //private Spinner spinnerData;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_results);

        //widget references
        results = (TextView) findViewById(R.id.results);
        //spinnerData = (Spinner) findViewById(R.id.spinnerData);

        //listeners
        //saveButton.setOnClickListener(this);
        //spinnerData.setOnItemSelectedListener(this);

        //set array adapter for spinner
        /*ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_data,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerData.setAdapter(adapter);*/

        //call to printDB method to show exiting data in spinner
        //printDB();

        //db handler object
        dbHandler = new MyDBHandler(null, null, null, 1);

        //retrieve string results
        Intent intent = getIntent();
        String mySummary = intent.getExtras().getString("Summary");

        //set results to TextView
        results.setText(mySummary);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.editButton:
                //return to previous activity
                onBackPressed();

                break;
            case R.id.saveButton:
                //triggers to save summary string to DB on button click
                addToDB();
        }
    }

    public void addToDB() {
        Intent intent = getIntent();
        String mySummary = intent.getExtras().getString("Summary");
        Budget budget = new Budget(mySummary);
        dbHandler.addBudgetData(budget);
        printDB();
    }

    public void printDB() {
        //call to dbToString method
        String budgetSummary = dbHandler.dbToString();

        //Array Adapter for spinner
       /* ArrayAdapter<String> adapter;

        //create list for spinner
        List<String> spinnerList = new ArrayList<String>();

        //begin adding to spinner
        spinnerList.add(budgetSummary);
        adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, spinnerList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerData.setAdapter(adapter);*/

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
