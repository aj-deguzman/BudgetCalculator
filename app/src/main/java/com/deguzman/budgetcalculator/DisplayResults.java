package com.deguzman.budgetcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class DisplayResults extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    //LogCat
    private static final String TAG = "LogCat";

    //declare variables
    private TextView results;
    private EditText myTest;
    private TextView temp;
    private Spinner spinnerData;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_results);

        //widget references
        results = (TextView) findViewById(R.id.results);
        myTest = (EditText) findViewById(R.id.myTest);
        temp = (TextView) findViewById(R.id.temp);
        spinnerData = (Spinner) findViewById(R.id.spinnerData);

        //db handler object
        dbHandler = new MyDBHandler(this, null, null, 1);

        //listeners
        //spinnerData.setOnItemSelectedListener(this);

        //set array adapter for spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.summary_hx,
                R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        spinnerData.setAdapter(adapter);

        //call to printDB method to show exiting data
        //printDB();

        //retrieve string results
        Intent intent = getIntent();
        String mySummary = intent.getExtras().getString("Summary");

        //set results to TextView
        results.setText(mySummary);
    }

    public void onEditClick(View v) {
        //return to previous activity
        onBackPressed();
    }

    public void onSaveClick(View v) {
        Budgets budget = new Budgets(myTest.getText().toString());
        dbHandler.addBudgetData(budget);
        printDB();
    }

    public void onDeleteClick(View v) {
        String inputText = temp.getText().toString();
        dbHandler.deleteBudgetData(inputText);
        printDB();
    }

    public void printDB() {
        //call to dbToString method
        String budgetSummary = dbHandler.dbToString();
        temp.setText(budgetSummary);

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
