package com.deguzman.budgetcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;

public class BudgetCalculatorMain extends AppCompatActivity {

    //declare variables
    private EditText incomeInput;
    private EditText expType1;
    private EditText expType2;
    private EditText expType3;
    private EditText expType4;
    private EditText expType5;
    private EditText expType6;
    private EditText expType7;
    private EditText expType8;
    private EditText expType9;
    private EditText expType10;
    private EditText expAmt1;
    private EditText expAmt2;
    private EditText expAmt3;
    private EditText expAmt4;
    private EditText expAmt5;
    private EditText expAmt6;
    private EditText expAmt7;
    private EditText expAmt8;
    private EditText expAmt9;
    private EditText expAmt10;
    private Spinner incomeTypeDD;
    private Spinner numberOfExp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_calculator_main);

        //widget references
        incomeInput = (EditText) findViewById(R.id.incomeInput);
        expType1 = (EditText) findViewById(R.id.expType1);
        expType2 = (EditText) findViewById(R.id.expType2);
        expType3 = (EditText) findViewById(R.id.expType3);
        expType4 = (EditText) findViewById(R.id.expType4);
        expType5 = (EditText) findViewById(R.id.expType5);
        expType6 = (EditText) findViewById(R.id.expType6);
        expType7 = (EditText) findViewById(R.id.expType7);
        expType8 = (EditText) findViewById(R.id.expType8);
        expType9 = (EditText) findViewById(R.id.expType9);
        expType10 = (EditText) findViewById(R.id.expType10);
        expAmt1 = (EditText) findViewById(R.id.expAmt1);
        expAmt2 = (EditText) findViewById(R.id.expAmt2);
        expAmt3 = (EditText) findViewById(R.id.expAmt3);
        expAmt4 = (EditText) findViewById(R.id.expAmt4);
        expAmt5 = (EditText) findViewById(R.id.expAmt5);
        expAmt6 = (EditText) findViewById(R.id.expAmt6);
        expAmt7 = (EditText) findViewById(R.id.expAmt7);
        expAmt8 = (EditText) findViewById(R.id.expAmt8);
        expAmt9 = (EditText) findViewById(R.id.expAmt9);
        expAmt10 = (EditText) findViewById(R.id.expAmt10);
        incomeTypeDD = (Spinner) findViewById(R.id.incomeTypeDD);
        numberOfExp = (Spinner) findViewById(R.id.numberOfExp);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
