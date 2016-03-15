package com.deguzman.budgetcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.deguzman.budgetcalculator.BudgetCalculatorMain;

import java.text.NumberFormat;


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

        //set results to TextView
        String myResults = bcm.printResults();
        results.setText(myResults);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.editButton:
                //create instance of Intent and execute to move to result on calculate button click
                Intent i = new Intent(this, BudgetCalculatorMain.class);
                startActivity(i);

                break;
        }
    }
}
