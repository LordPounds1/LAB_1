package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Button ok_btn, cnc_btn;
    TextView mainTextView;
    EditText mainEditText;
    ListView mainListView;
    ArrayAdapter mArrayAdapter;
    ArrayList mNameList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ok_btn = findViewById(R.id.ok_btn);
        cnc_btn = findViewById(R.id.cnc_btn);
        mainTextView = findViewById(R.id.main_textview);
        mainEditText = (EditText) findViewById(R.id.main_edittext);

        mainListView = findViewById(R.id.main_listview);
        mArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                mNameList);
        mainListView.setAdapter(mArrayAdapter);
        mainListView.setOnItemClickListener(this);

        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTextView.setText("Нажата кнопка ОК");
            }
        });

        cnc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTextView.setText("Нажата кнопка Cancel");
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("omg android", position + ": " + mNameList.get(position));
        mainTextView.setText(mNameList.get(position).toString()
                + " is learning Android development!");
    }
}


