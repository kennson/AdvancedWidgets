package com.mobility.dictwilson.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    Button button;
    Spinner spinner;
    ToggleButton toggle;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button= (Button) findViewById(R.id.button2);
        button.setOnClickListener(this);

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.locations, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        toggle = (ToggleButton) findViewById(R.id.toggleButton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggle.setTextOn("Has Voucher");
                } else {
                    toggle.setTextOff("No Voucher");
                }
            }
        });

        textView = (TextView) findViewById(R.id.textView12);
        Bundle bundle;
        bundle = getIntent().getExtras();
        textView.setText(bundle.getString(""));
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(Main2Activity.this,Main3Activity.class));
    }
}
