package com.deguzman.budgetcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class BudgetCalculatorMain extends AppCompatActivity implements TextView.OnEditorActionListener, View.OnClickListener,
        AdapterView.OnItemSelectedListener {

    //LogCat
    private static final String TAG = "My LogCat";

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
    private Button calcButton;
    private Button resetButton;

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
                android.R.layout.simple_spinner_item);
        incomeTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        incomeTypeDD.setAdapter(incomeTypeAdapter);
        ArrayAdapter<CharSequence> expAdapter = ArrayAdapter.createFromResource(this, R.array.number_of_exp,
                android.R.layout.simple_spinner_item);
        expAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numberOfExp.setAdapter(expAdapter);

        Log.i(TAG, "OnCreate");
    }

    public void calculate() {
        //get pay type and use it as a basis for calculations based on days
        //values for average number of days based on pay types\
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
    }

    private List<String> expTypeAL = new ArrayList<String>();
    private List<Double> expAmtAL = new ArrayList<Double>();

    public double calcExpenses(){
        double expSum = 0.0;

        for (int i=0; i<expAmtAL.size(); i++){
            if (expAmt1.getText().toString().trim().length() == 0){
                Toast.makeText(null, "Please enter expense amount beginning in the first expense field",
                        Toast.LENGTH_LONG).show();
                expAmtAL.removeAll(expAmtAL);
            } else {
                expSum =+ expAmtAL.get(i);
                Log.i(TAG, "Second if: " + expSum);
            }
        }

        return expSum;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.calcButton:
                Log.i(TAG, "Calculate");
                Log.i(TAG, "Value of first exp: " + expType1.getText().toString() + "" + expAmt1.getText().toString());
                Log.i(TAG, "Value of second exp: " + expType2.getText().toString() + "" + expAmt2.getText().toString());

                Log.i(TAG, "Final: " + String.valueOf(calcExpenses()));

                break;
        }
    }


    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

        if (actionId == EditorInfo.IME_ACTION_DONE ||
                actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
            if (expAmt1.getText().toString().trim().length() != 0) {
                expTypeAL.add(expType1.getText().toString());
                expAmtAL.add(Double.parseDouble(expAmt1.getText().toString()));
            }

            if (expAmt2.getText().toString().trim().length() != 0){
                expTypeAL.add(expType2.getText().toString());
                expAmtAL.add(Double.parseDouble(expAmt2.getText().toString()));
            }

            if (expAmt3.getText().toString().trim().length() != 0){
                expTypeAL.add(expType3.getText().toString());
                expAmtAL.add(Double.parseDouble(expAmt3.getText().toString()));
            }
                /*


                expTypeAL.add(expType4.getText().toString());
                expTypeAL.add(expType5.getText().toString());
                expTypeAL.add(expType6.getText().toString());
                expTypeAL.add(expType7.getText().toString());
                expTypeAL.add(expType8.getText().toString());
                expTypeAL.add(expType9.getText().toString());
                expTypeAL.add(expType10.getText().toString());*/

            //put expense title and amount in ArrayList



            /*expAmtAL.add(expAmt4.getText().toString());
            expAmtAL.add(expAmt5.getText().toString());
            expAmtAL.add(expAmt6.getText().toString());
            expAmtAL.add(expAmt7.getText().toString());
            expAmtAL.add(expAmt8.getText().toString());
            expAmtAL.add(expAmt9.getText().toString());
            expAmtAL.add(expAmt10.getText().toString());*/
        }

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
