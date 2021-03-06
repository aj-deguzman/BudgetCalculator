package com.deguzman.budgetcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.Intent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;


public class BudgetCalculatorMain extends AppCompatActivity implements TextView.OnEditorActionListener, View.OnClickListener,
        AdapterView.OnItemSelectedListener {

    //declare variables
    private EditText incomeInput;
    private TextView exp1;
    private TextView exp2;
    private TextView exp3;
    private TextView exp4;
    private TextView exp5;
    private TextView exp6;
    private TextView exp7;
    private TextView exp8;
    private TextView exp9;
    private TextView exp10;
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
    private Spinner summaryHx;
    private Button calcButton;
    private Button resetButton;
    private List<EditText> expTypeAL = new ArrayList<EditText>();
    private List<EditText> expAmtAL = new ArrayList<EditText>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_calculator_main);

        //widget references
        incomeInput = (EditText) findViewById(R.id.incomeInput);
        exp1 = (TextView) findViewById(R.id.exp1);
        exp2 = (TextView) findViewById(R.id.exp2);
        exp3 = (TextView) findViewById(R.id.exp3);
        exp4 = (TextView) findViewById(R.id.exp4);
        exp5 = (TextView) findViewById(R.id.exp5);
        exp6 = (TextView) findViewById(R.id.exp6);
        exp7 = (TextView) findViewById(R.id.exp7);
        exp8 = (TextView) findViewById(R.id.exp8);
        exp9 = (TextView) findViewById(R.id.exp9);
        exp10 = (TextView) findViewById(R.id.exp10);
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
        summaryHx = (Spinner) findViewById(R.id.summaryHx);
        calcButton = (Button) findViewById(R.id.calcButton);
        resetButton = (Button) findViewById(R.id.resetButton);

        //set listeners
        incomeInput.setOnEditorActionListener(this);
        expAmt1.setOnEditorActionListener(this);
        expAmt2.setOnEditorActionListener(this);
        expAmt3.setOnEditorActionListener(this);
        expAmt4.setOnEditorActionListener(this);
        expAmt5.setOnEditorActionListener(this);
        expAmt6.setOnEditorActionListener(this);
        expAmt7.setOnEditorActionListener(this);
        expAmt8.setOnEditorActionListener(this);
        expAmt9.setOnEditorActionListener(this);
        expAmt10.setOnEditorActionListener(this);
        incomeTypeDD.setOnItemSelectedListener(this);
        numberOfExp.setOnItemSelectedListener(this);
        calcButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);

        //set array adapter for spinners
        ArrayAdapter<CharSequence> incomeTypeAdapter = ArrayAdapter.createFromResource(this, R.array.income_type,
                R.layout.spinner_item2);
        incomeTypeAdapter.setDropDownViewResource(R.layout.spinner_item2);
        incomeTypeDD.setAdapter(incomeTypeAdapter);
        ArrayAdapter<CharSequence> expAdapter = ArrayAdapter.createFromResource(this, R.array.number_of_exp,
                R.layout.spinner_item2);
        expAdapter.setDropDownViewResource(R.layout.spinner_item2);
        numberOfExp.setAdapter(expAdapter);
        ArrayAdapter<CharSequence> sumAdapter = ArrayAdapter.createFromResource(this, R.array.summary_hx,
                R.layout.spinner_item);
        expAdapter.setDropDownViewResource(R.layout.spinner_item);
        summaryHx.setAdapter(sumAdapter);

        //set default values for EditTexts fields
        incomeInput.setText("0.0");
        expType1.setText("Expense Name 1");
        expType2.setText("Expense Name 2");
        expType3.setText("Expense Name 3");
        expType4.setText("Expense Name 4");
        expType5.setText("Expense Name 5");
        expType6.setText("Expense Name 6");
        expType7.setText("Expense Name 7");
        expType8.setText("Expense Name 8");
        expType9.setText("Expense Name 9");
        expType10.setText("Expense Name 10");
        expAmt1.setText("0.0");
        expAmt2.setText("0.0");
        expAmt3.setText("0.0");
        expAmt4.setText("0.0");
        expAmt5.setText("0.0");
        expAmt6.setText("0.0");
        expAmt7.setText("0.0");
        expAmt8.setText("0.0");
        expAmt9.setText("0.0");
        expAmt10.setText("0.0");

        //add EditText to ArrayList
        expTypeAL.add(expType1);
        expTypeAL.add(expType2);
        expTypeAL.add(expType3);
        expTypeAL.add(expType4);
        expTypeAL.add(expType5);
        expTypeAL.add(expType6);
        expTypeAL.add(expType7);
        expTypeAL.add(expType8);
        expTypeAL.add(expType9);
        expTypeAL.add(expType10);
        expAmtAL.add(expAmt1);
        expAmtAL.add(expAmt2);
        expAmtAL.add(expAmt3);
        expAmtAL.add(expAmt4);
        expAmtAL.add(expAmt5);
        expAmtAL.add(expAmt6);
        expAmtAL.add(expAmt7);
        expAmtAL.add(expAmt8);
        expAmtAL.add(expAmt9);
        expAmtAL.add(expAmt10);
    }

    public double calcBudget() {
        double budget = 0.0;
        double payAmt = Double.parseDouble(incomeInput.getText().toString());
        double totalExpenses = calcExpenses();

        //calculate budget
        budget = payAmt - totalExpenses;

        return budget;
    }

    //calculate daily allowance til next payday
    public double calcAllowance() {
        double allowance = 0.0;

        //get pay type and use it as a basis for calculations based on days
        //values for average number of days based on pay types
        String payType = "";

        switch (incomeTypeDD.getSelectedItemPosition()) {
            case 0:
                payType = "1";
                break;
            case 1:
                payType = "7";
                break;
            case 2:
                payType = "14";
                break;
            case 3:
                payType = "30.42";
                break;
            case 4:
                payType = "365";
                break;
        }

        //parse string inputs to double
        double totalBudget = calcBudget();
        double payTypeDays = Double.parseDouble(payType);

        //calculate daily allowance
        allowance = totalBudget/payTypeDays;

        return allowance;
    }

    //replace value of ArrayList element
    // if does not equal a value of 0.0
    //or the amount in EditText does not equal that in the element
    public void checkExpAmtVals() {
        if (Double.parseDouble(expAmt1.getText().toString()) != 0.0
                || Double.parseDouble(expAmt1.getText().toString())
                != Double.parseDouble(expAmt1.getText().toString())) {
            expAmtAL.set(0, expAmt1);
        }

        if (Double.parseDouble(expAmt2.getText().toString()) != 0.0
                || Double.parseDouble(expAmt2.getText().toString())
                != Double.parseDouble(expAmt2.getText().toString())) {
            expAmtAL.set(1, expAmt2);
        }

        if (Double.parseDouble(expAmt3.getText().toString()) != 0.0
                || Double.parseDouble(expAmt3.getText().toString())
                != Double.parseDouble(expAmt3.getText().toString())) {
            expAmtAL.set(2, expAmt3);
        }

        if (Double.parseDouble(expAmt4.getText().toString()) != 0.0
                || Double.parseDouble(expAmt4.getText().toString())
                != Double.parseDouble(expAmt4.getText().toString())) {
            expAmtAL.set(3, expAmt4);
        }

        if (Double.parseDouble(expAmt5.getText().toString()) != 0.0
                || Double.parseDouble(expAmt5.getText().toString())
                != Double.parseDouble(expAmt5.getText().toString())) {
            expAmtAL.set(4, expAmt5);
        }

        if (Double.parseDouble(expAmt6.getText().toString()) != 0.0
                || Double.parseDouble(expAmt6.getText().toString())
                != Double.parseDouble(expAmt6.getText().toString())) {
            expAmtAL.set(5, expAmt6);
        }

        if (Double.parseDouble(expAmt7.getText().toString()) != 0.0
                || Double.parseDouble(expAmt7.getText().toString())
                != Double.parseDouble(expAmt7.getText().toString())) {
            expAmtAL.set(6, expAmt7);
        }

        if (Double.parseDouble(expAmt8.getText().toString()) != 0.0
                || Double.parseDouble(expAmt8.getText().toString())
                != Double.parseDouble(expAmt8.getText().toString())) {
            expAmtAL.set(7, expAmt8);
        }

        if (Double.parseDouble(expAmt9.getText().toString()) != 0.0
                || Double.parseDouble(expAmt9.getText().toString())
                != Double.parseDouble(expAmt9.getText().toString())) {
            expAmtAL.set(8, expAmt9);
        }

        if (Double.parseDouble(expAmt10.getText().toString()) != 0.0
                || Double.parseDouble(expAmt10.getText().toString())
                != Double.parseDouble(expAmt10.getText().toString())) {
            expAmtAL.set(9, expAmt10);
        }
    }

    public double calcExpenses() {
        checkExpAmtVals();

        double expSum = 0.0;

        //loop and remove all expense amount arraylists elements whos values contain 0.0
        //and remove all expense type arraylist elements whos values contain ""
        //else add new value from editText
        for (int i=0; i<expAmtAL.size(); i++) {
            if (Double.parseDouble(expAmtAL.get(i).getText().toString()) != 0.0) {
                expSum = expSum + Double.parseDouble(expAmtAL.get(i).getText().toString());
            }
        }

        return expSum;
    }

    //print method
    public String printResults() {
        String results = "";

        //currency number format
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        results = "Summary:" + '\n'
                + "Your " + incomeTypeDD.getSelectedItem().toString() + " income is " + formatter.format(Double.parseDouble(incomeInput.getText().toString())) + '\n'
                + "Your expenses are: " + '\n'
                + expTypeAL.get(0).getText().toString() + " - " + formatter.format(Double.parseDouble(expAmtAL.get(0).getText().toString())) + '\n'
                + expTypeAL.get(1).getText().toString() + " - " + formatter.format(Double.parseDouble(expAmtAL.get(1).getText().toString())) + '\n'
                + expTypeAL.get(2).getText().toString() + " - " + formatter.format(Double.parseDouble(expAmtAL.get(2).getText().toString())) + '\n'
                + expTypeAL.get(3).getText().toString() + " - " + formatter.format(Double.parseDouble(expAmtAL.get(3).getText().toString())) + '\n'
                + expTypeAL.get(4).getText().toString() + " - " + formatter.format(Double.parseDouble(expAmtAL.get(4).getText().toString())) + '\n'
                + expTypeAL.get(5).getText().toString() + " - " + formatter.format(Double.parseDouble(expAmtAL.get(5).getText().toString())) + '\n'
                + expTypeAL.get(6).getText().toString() + " - " + formatter.format(Double.parseDouble(expAmtAL.get(6).getText().toString())) + '\n'
                + expTypeAL.get(7).getText().toString() + " - " + formatter.format(Double.parseDouble(expAmtAL.get(7).getText().toString())) + '\n'
                + expTypeAL.get(8).getText().toString() + " - " + formatter.format(Double.parseDouble(expAmtAL.get(8).getText().toString())) + '\n'
                + expTypeAL.get(9).getText().toString() + " - " + formatter.format(Double.parseDouble(expAmtAL.get(9).getText().toString())) + '\n'
                + "Your expense total is: " + formatter.format(calcExpenses()) + '\n'
                + "Your money leftover after expenses is: " + formatter.format(calcBudget()) + "\n"
                + "Your average daily allowance until next payday is: " + formatter.format(calcAllowance());

        return results;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.calcButton:

                //create instance of Intent and pass result string
                Intent i = new Intent(this, DisplayResults.class);
                i.putExtra("Summary", printResults());
                startActivity(i);


                break;
            case R.id.resetButton:
                //set default values for EditTexts fields
                incomeInput.setText("0.0");
                expType1.setText("Expense Name 1");
                expType2.setText("Expense Name 2");
                expType3.setText("Expense Name 3");
                expType4.setText("Expense Name 4");
                expType5.setText("Expense Name 5");
                expType6.setText("Expense Name 6");
                expType7.setText("Expense Name 7");
                expType8.setText("Expense Name 8");
                expType9.setText("Expense Name 9");
                expType10.setText("Expense Name 10");
                expAmt1.setText("0.0");
                expAmt2.setText("0.0");
                expAmt3.setText("0.0");
                expAmt4.setText("0.0");
                expAmt5.setText("0.0");
                expAmt6.setText("0.0");
                expAmt7.setText("0.0");
                expAmt8.setText("0.0");
                expAmt9.setText("0.0");
                expAmt10.setText("0.0");

                //replace EditText in ArrayList
                expTypeAL.set(0, expType1);
                expTypeAL.set(1, expType2);
                expTypeAL.set(2, expType3);
                expTypeAL.set(3, expType4);
                expTypeAL.set(4, expType5);
                expTypeAL.set(5, expType6);
                expTypeAL.set(6, expType7);
                expTypeAL.set(7, expType8);
                expTypeAL.set(8, expType9);
                expTypeAL.set(9, expType10);
                expAmtAL.set(0, expAmt1);
                expAmtAL.set(1, expAmt2);
                expAmtAL.set(2, expAmt3);
                expAmtAL.set(3, expAmt4);
                expAmtAL.set(4, expAmt5);
                expAmtAL.set(5, expAmt6);
                expAmtAL.set(6, expAmt7);
                expAmtAL.set(7, expAmt8);
                expAmtAL.set(8, expAmt9);
                expAmtAL.set(9, expAmt10);

                break;
        }
    }


    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        return false;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //hides expense widgets
        exp1.setVisibility(View.GONE);
        exp2.setVisibility(View.GONE);
        exp3.setVisibility(View.GONE);
        exp4.setVisibility(View.GONE);
        exp5.setVisibility(View.GONE);
        exp6.setVisibility(View.GONE);
        exp7.setVisibility(View.GONE);
        exp8.setVisibility(View.GONE);
        exp9.setVisibility(View.GONE);
        exp10.setVisibility(View.GONE);

        expType1.setVisibility(View.GONE);
        expType2.setVisibility(View.GONE);
        expType3.setVisibility(View.GONE);
        expType4.setVisibility(View.GONE);
        expType5.setVisibility(View.GONE);
        expType6.setVisibility(View.GONE);
        expType7.setVisibility(View.GONE);
        expType8.setVisibility(View.GONE);
        expType9.setVisibility(View.GONE);
        expType10.setVisibility(View.GONE);

        expAmt1.setVisibility(View.GONE);
        expAmt2.setVisibility(View.GONE);
        expAmt3.setVisibility(View.GONE);
        expAmt4.setVisibility(View.GONE);
        expAmt5.setVisibility(View.GONE);
        expAmt6.setVisibility(View.GONE);
        expAmt7.setVisibility(View.GONE);
        expAmt8.setVisibility(View.GONE);
        expAmt9.setVisibility(View.GONE);
        expAmt10.setVisibility(View.GONE);

        //shows expense widgets based on number of expenses chosen by user
        if(numberOfExp.getSelectedItemPosition() == 0) {
            exp1.setVisibility(View.VISIBLE);
            expType1.setVisibility(View.VISIBLE);
            expAmt1.setVisibility(View.VISIBLE);
        } else if (numberOfExp.getSelectedItemPosition() == 1) {
            exp1.setVisibility(View.VISIBLE);
            expType1.setVisibility(View.VISIBLE);
            expAmt1.setVisibility(View.VISIBLE);
            exp2.setVisibility(View.VISIBLE);
            expType2.setVisibility(View.VISIBLE);
            expAmt2.setVisibility(View.VISIBLE);
        } else if (numberOfExp.getSelectedItemPosition() == 2) {
            exp1.setVisibility(View.VISIBLE);
            expType1.setVisibility(View.VISIBLE);
            expAmt1.setVisibility(View.VISIBLE);
            exp2.setVisibility(View.VISIBLE);
            expType2.setVisibility(View.VISIBLE);
            expAmt2.setVisibility(View.VISIBLE);
            exp3.setVisibility(View.VISIBLE);
            expType3.setVisibility(View.VISIBLE);
            expAmt3.setVisibility(View.VISIBLE);
        } else if (numberOfExp.getSelectedItemPosition() == 3) {
            exp1.setVisibility(View.VISIBLE);
            expType1.setVisibility(View.VISIBLE);
            expAmt1.setVisibility(View.VISIBLE);
            exp2.setVisibility(View.VISIBLE);
            expType2.setVisibility(View.VISIBLE);
            expAmt2.setVisibility(View.VISIBLE);
            exp3.setVisibility(View.VISIBLE);
            expType3.setVisibility(View.VISIBLE);
            expAmt3.setVisibility(View.VISIBLE);
            exp4.setVisibility(View.VISIBLE);
            expType4.setVisibility(View.VISIBLE);
            expAmt4.setVisibility(View.VISIBLE);
        } else if (numberOfExp.getSelectedItemPosition() == 4) {
            exp1.setVisibility(View.VISIBLE);
            expType1.setVisibility(View.VISIBLE);
            expAmt1.setVisibility(View.VISIBLE);
            exp2.setVisibility(View.VISIBLE);
            expType2.setVisibility(View.VISIBLE);
            expAmt2.setVisibility(View.VISIBLE);
            exp3.setVisibility(View.VISIBLE);
            expType3.setVisibility(View.VISIBLE);
            expAmt3.setVisibility(View.VISIBLE);
            exp4.setVisibility(View.VISIBLE);
            expType4.setVisibility(View.VISIBLE);
            expAmt4.setVisibility(View.VISIBLE);
            exp5.setVisibility(View.VISIBLE);
            expType5.setVisibility(View.VISIBLE);
            expAmt5.setVisibility(View.VISIBLE);
        } else if (numberOfExp.getSelectedItemPosition() == 5) {
            exp1.setVisibility(View.VISIBLE);
            expType1.setVisibility(View.VISIBLE);
            expAmt1.setVisibility(View.VISIBLE);
            exp2.setVisibility(View.VISIBLE);
            expType2.setVisibility(View.VISIBLE);
            expAmt2.setVisibility(View.VISIBLE);
            exp3.setVisibility(View.VISIBLE);
            expType3.setVisibility(View.VISIBLE);
            expAmt3.setVisibility(View.VISIBLE);
            exp4.setVisibility(View.VISIBLE);
            expType4.setVisibility(View.VISIBLE);
            expAmt4.setVisibility(View.VISIBLE);
            exp5.setVisibility(View.VISIBLE);
            expType5.setVisibility(View.VISIBLE);
            expAmt5.setVisibility(View.VISIBLE);
            exp6.setVisibility(View.VISIBLE);
            expType6.setVisibility(View.VISIBLE);
            expAmt6.setVisibility(View.VISIBLE);
        } else if (numberOfExp.getSelectedItemPosition() == 6) {
            exp1.setVisibility(View.VISIBLE);
            expType1.setVisibility(View.VISIBLE);
            expAmt1.setVisibility(View.VISIBLE);
            exp2.setVisibility(View.VISIBLE);
            expType2.setVisibility(View.VISIBLE);
            expAmt2.setVisibility(View.VISIBLE);
            exp3.setVisibility(View.VISIBLE);
            expType3.setVisibility(View.VISIBLE);
            expAmt3.setVisibility(View.VISIBLE);
            exp4.setVisibility(View.VISIBLE);
            expType4.setVisibility(View.VISIBLE);
            expAmt4.setVisibility(View.VISIBLE);
            exp5.setVisibility(View.VISIBLE);
            expType5.setVisibility(View.VISIBLE);
            expAmt5.setVisibility(View.VISIBLE);
            exp6.setVisibility(View.VISIBLE);
            expType6.setVisibility(View.VISIBLE);
            expAmt6.setVisibility(View.VISIBLE);
            exp7.setVisibility(View.VISIBLE);
            expType7.setVisibility(View.VISIBLE);
            expAmt7.setVisibility(View.VISIBLE);
        } else if (numberOfExp.getSelectedItemPosition() == 7) {
            exp1.setVisibility(View.VISIBLE);
            expType1.setVisibility(View.VISIBLE);
            expAmt1.setVisibility(View.VISIBLE);
            exp2.setVisibility(View.VISIBLE);
            expType2.setVisibility(View.VISIBLE);
            expAmt2.setVisibility(View.VISIBLE);
            exp3.setVisibility(View.VISIBLE);
            expType3.setVisibility(View.VISIBLE);
            expAmt3.setVisibility(View.VISIBLE);
            exp4.setVisibility(View.VISIBLE);
            expType4.setVisibility(View.VISIBLE);
            expAmt4.setVisibility(View.VISIBLE);
            exp5.setVisibility(View.VISIBLE);
            expType5.setVisibility(View.VISIBLE);
            expAmt5.setVisibility(View.VISIBLE);
            exp6.setVisibility(View.VISIBLE);
            expType6.setVisibility(View.VISIBLE);
            expAmt6.setVisibility(View.VISIBLE);
            exp6.setVisibility(View.VISIBLE);
            expType6.setVisibility(View.VISIBLE);
            expAmt6.setVisibility(View.VISIBLE);
            exp7.setVisibility(View.VISIBLE);
            expType7.setVisibility(View.VISIBLE);
            expAmt7.setVisibility(View.VISIBLE);
            exp8.setVisibility(View.VISIBLE);
            expType8.setVisibility(View.VISIBLE);
            expAmt8.setVisibility(View.VISIBLE);
        } else if (numberOfExp.getSelectedItemPosition() == 8) {
            exp1.setVisibility(View.VISIBLE);
            expType1.setVisibility(View.VISIBLE);
            expAmt1.setVisibility(View.VISIBLE);
            exp2.setVisibility(View.VISIBLE);
            expType2.setVisibility(View.VISIBLE);
            expAmt2.setVisibility(View.VISIBLE);
            exp3.setVisibility(View.VISIBLE);
            expType3.setVisibility(View.VISIBLE);
            expAmt3.setVisibility(View.VISIBLE);
            exp4.setVisibility(View.VISIBLE);
            expType4.setVisibility(View.VISIBLE);
            expAmt4.setVisibility(View.VISIBLE);
            exp5.setVisibility(View.VISIBLE);
            expType5.setVisibility(View.VISIBLE);
            expAmt5.setVisibility(View.VISIBLE);
            exp6.setVisibility(View.VISIBLE);
            expType6.setVisibility(View.VISIBLE);
            expAmt6.setVisibility(View.VISIBLE);
            exp7.setVisibility(View.VISIBLE);
            expType7.setVisibility(View.VISIBLE);
            expAmt7.setVisibility(View.VISIBLE);
            exp8.setVisibility(View.VISIBLE);
            expType8.setVisibility(View.VISIBLE);
            expAmt8.setVisibility(View.VISIBLE);
            exp9.setVisibility(View.VISIBLE);
            expType9.setVisibility(View.VISIBLE);
            expAmt9.setVisibility(View.VISIBLE);
        } else if (numberOfExp.getSelectedItemPosition() == 9) {
            exp1.setVisibility(View.VISIBLE);
            expType1.setVisibility(View.VISIBLE);
            expAmt1.setVisibility(View.VISIBLE);
            exp2.setVisibility(View.VISIBLE);
            expType2.setVisibility(View.VISIBLE);
            expAmt2.setVisibility(View.VISIBLE);
            exp3.setVisibility(View.VISIBLE);
            expType3.setVisibility(View.VISIBLE);
            expAmt3.setVisibility(View.VISIBLE);
            exp4.setVisibility(View.VISIBLE);
            expType4.setVisibility(View.VISIBLE);
            expAmt4.setVisibility(View.VISIBLE);
            exp5.setVisibility(View.VISIBLE);
            expType5.setVisibility(View.VISIBLE);
            expAmt5.setVisibility(View.VISIBLE);
            exp6.setVisibility(View.VISIBLE);
            expType6.setVisibility(View.VISIBLE);
            expAmt6.setVisibility(View.VISIBLE);
            exp7.setVisibility(View.VISIBLE);
            expType7.setVisibility(View.VISIBLE);
            expAmt7.setVisibility(View.VISIBLE);
            exp8.setVisibility(View.VISIBLE);
            expType8.setVisibility(View.VISIBLE);
            expAmt8.setVisibility(View.VISIBLE);
            exp9.setVisibility(View.VISIBLE);
            expType9.setVisibility(View.VISIBLE);
            expAmt9.setVisibility(View.VISIBLE);
            exp10.setVisibility(View.VISIBLE);
            expType10.setVisibility(View.VISIBLE);
            expAmt10.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
