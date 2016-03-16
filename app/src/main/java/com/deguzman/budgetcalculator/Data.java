package com.deguzman.budgetcalculator;

public class Data {

    //declare variables
    private int _id;
    private String _dataName;

    //constructors
    public Data(){
    }

    public Data(String _dataName) {
        this._dataName = _dataName;
    }

    //setters and getters
    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_dataName(String _dataName) {
        this._dataName = _dataName;
    }

    public int get_id() {
        return _id;
    }

    public String get_dataName() {
        return _dataName;
    }
}
