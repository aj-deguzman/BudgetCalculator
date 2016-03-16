package com.deguzman.budgetcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

public class display_results extends AppCompatActivity {

    //declare variables
    private TextView results;

    //create instance of my main class and methods
    BudgetCalculatorMain bcm = new BudgetCalculatorMain();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_results);

        //widget references
        results = (TextView) findViewById(R.id.results);

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
        }
    }
}
