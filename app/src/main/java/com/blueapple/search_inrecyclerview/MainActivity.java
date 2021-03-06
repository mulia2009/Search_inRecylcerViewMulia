package com.blueapple.search_inrecyclerview;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<MyModel> arrayList = new ArrayList<>();
    public EditText mTvSearchview;
    public RecyclerView mRecyclerList;

    DataAdapter dataAdapter;
    public Spinner mSpinner;
    //filter


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        getSupportActionBar().hide();
        addData();

        mTvSearchview.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {

                filter(s.toString());

            }
        });
    }

    private void filter(String text) {
        ArrayList<MyModel> filteredList = new ArrayList<>();

        for (MyModel myModel : arrayList) {
            if (myModel.getCountry_name().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(myModel);
            }
        }

        dataAdapter.filterList(filteredList);


    }

    private void addData() {
        MyModel myModel1 = new MyModel("India");
        MyModel myModel2 = new MyModel("US");
        MyModel myModel3 = new MyModel("Russia");
        MyModel myModel4 = new MyModel("Japan");
        MyModel myModel5 = new MyModel("Indonesia");
        MyModel myModel6 = new MyModel("Israil");

        arrayList.add(myModel1);
        arrayList.add(myModel2);
        arrayList.add(myModel3);
        arrayList.add(myModel4);
        arrayList.add(myModel5);
        arrayList.add(myModel6);

        Log.d("arraylist", String.valueOf(arrayList.size()));

        dataAdapter = new DataAdapter(this, arrayList);

        ArrayAdapter<MyModel> arrayAdapter=new ArrayAdapter<MyModel>(this,
                android.R.layout.simple_spinner_dropdown_item,arrayList);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinner.setAdapter(arrayAdapter);

        mRecyclerList.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerList.setHasFixedSize(true);
        mRecyclerList.setAdapter(dataAdapter);


        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();

                MyModel myModel= (MyModel) parent.getSelectedItem();

                Toast.makeText(MainActivity.this, ""+position+" "+myModel.getCountry_name(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void initView() {
        mTvSearchview = findViewById(R.id.tv_searchview);
        mRecyclerList = (RecyclerView) findViewById(R.id.recyclerList);
        mSpinner = (Spinner) findViewById(R.id.spinner);
    }
}
