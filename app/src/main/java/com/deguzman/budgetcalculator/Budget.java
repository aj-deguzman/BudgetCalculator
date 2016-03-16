package com.deguzman.budgetcalculator;

public class Budget {

    //declare variables
    private int _id;
    private String _budgetName;

    //constructors
    public Budget() {
    }

    public Budget(String budgetName) {
        this._budgetName = budgetName;
    }

    //setters and getters
    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_dataName(String _budgetName) {
        this._budgetName = _budgetName;
    }

    public int get_id() {
        return _id;
    }

    public String get_budgetName() {
        return _budgetName;
    }
}