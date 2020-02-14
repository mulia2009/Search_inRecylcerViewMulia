package com.blueapple.search_inrecyclerview;

import androidx.annotation.NonNull;

public class MyModel
{
    String country_name;

    public MyModel(String country_name) {
        this.country_name = country_name;

    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    String state_name;

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    @NonNull
    @Override
    public String toString() {

        return country_name;
    }
}
