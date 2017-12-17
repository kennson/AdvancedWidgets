package com.mobility.dictwilson.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    TextView result;
    CheckBox burger, buffalo, pasta;
    Switch burgers, buffalos, pastas;
    int burgercno = 120, buffalocno = 250, pastacno = 210, total, ten = 10;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        burgers = (Switch) findViewById(R.id.switch6);
        buffalos = (Switch) findViewById(R.id.switch5);
        pastas = (Switch) findViewById(R.id.switch7);

        result = (TextView) findViewById(R.id.textView5);
        burger = (CheckBox) findViewById(R.id.checkBox);
        buffalo = (CheckBox) findViewById(R.id.checkBox2);
        pasta = (CheckBox) findViewById(R.id.checkBox3);


        burgers.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if (isChecked && burger.isChecked()) {
                   if(isChecked && burger.isChecked() && buffalo.isChecked()){
                       if (isChecked && burger.isChecked() && buffalo.isChecked() && pasta.isChecked()){
                           total = burgercno + buffalocno + pastacno + ten;
                           result.setText(Integer.toString(total));
                       }else {
                           total = burgercno + buffalocno + ten;
                           result.setText(Integer.toString(total));
                       }
                   }else if (isChecked && burger.isChecked() && pasta.isChecked()){
                       total = burgercno + pastacno + ten;
                       result.setText(Integer.toString(total));
                   }else {
                       total = burgercno + ten;
                       result.setText(Integer.toString(total));
                   }
               } else if (isChecked) {
                       total = ten;
                       result.setText(Integer.toString(total));
               } else {
                       result.setText("0");
                    }
               }
        });

        buffalos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && buffalo.isChecked()) {
                    if(isChecked && buffalo.isChecked() && pasta.isChecked()){
                        if(isChecked && buffalo.isChecked() && pasta.isChecked() && burger.isChecked()){
                            total = burgercno + buffalocno + pastacno + ten;
                            result.setText(Integer.toString(total));
                        }else {
                            total = pastacno + buffalocno + ten;
                            result.setText(Integer.toString(total));
                        }
                    }else if (isChecked && burger.isChecked() && buffalo.isChecked()){
                        total = burgercno + buffalocno + ten;
                        result.setText(Integer.toString(total));
                    }else {
                        total = buffalocno + ten;
                        result.setText(Integer.toString(total));
                    }
                } else if (isChecked) {
                        total = ten;
                        result.setText(Integer.toString(total));
                } else {
                        result.setText("0");
                    }
                }
        });

        pastas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked && pasta.isChecked()) {
                    if(isChecked && pasta.isChecked() && burger.isChecked()){
                        if (isChecked && pasta.isChecked() && burger.isChecked() && buffalo.isChecked()){
                            total = burgercno + buffalocno + pastacno + ten;
                            result.setText(Integer.toString(total));
                        }else {
                            total = pastacno + burgercno + ten;
                            result.setText(Integer.toString(total));
                        }
                    }else if (isChecked && buffalo.isChecked() && pasta.isChecked()){
                        total = buffalocno + pastacno + ten;
                        result.setText(Integer.toString(total));
                    }else {
                        total = pastacno + ten;
                        result.setText(Integer.toString(total));
                    }
                } else if (isChecked) {
                        total = ten;
                        result.setText(Integer.toString(total));
                } else {
                        result.setText("0");
                    }
                }
        });
    }

    @Override
    public void onClick(View view) {
        if (burger.isChecked() == false && buffalo.isChecked() == false && pasta.isChecked() == false){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle("Ooppss!");
            alertDialogBuilder
                    .setMessage("Select an item")
                    .setCancelable(false)
                    .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {

                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }else{
            startActivity(new Intent(MainActivity.this, Main2Activity.class));
            final TextView textView = (TextView) findViewById(R.id.textView5);
            Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
            intent.putExtra("", textView.getText().toString());
            startActivity(intent);
        }

    }

    public void onCheckboxClicked(View view) {
        if (burger.isChecked()) {
            if (buffalo.isChecked()) {
                if (pasta.isChecked()) {
                    total = burgercno + buffalocno + pastacno;
                    result.setText(Integer.toString(total));
                } else {
                    total = burgercno + buffalocno;
                    result.setText(Integer.toString(total));
                }
            } else if (pasta.isChecked()) {
                if (buffalo.isChecked()) {
                    total = burgercno + buffalocno + pastacno;
                    result.setText(Integer.toString(total));
                } else {
                    total = burgercno + pastacno;
                    result.setText(Integer.toString(total));
                }
            } else {
                result.setText("120");
            }
        }
        if (buffalo.isChecked()) {
            if (burger.isChecked()) {
                if (pasta.isChecked()) {
                    total = burgercno + buffalocno + pastacno;
                    result.setText(Integer.toString(total));
                } else {
                    total = burgercno + buffalocno;
                    result.setText(Integer.toString(total));
                }
            } else if (pasta.isChecked()) {
                if (burger.isChecked()) {
                    total = burgercno + buffalocno + pastacno;
                    result.setText(Integer.toString(total));
                } else {
                    total = buffalocno + pastacno;
                    result.setText(Integer.toString(total));
                }
            } else {
                result.setText("250");
            }
        }
        if (pasta.isChecked()) {
            if (burger.isChecked()) {
                if (buffalo.isChecked()) {
                    total = burgercno + buffalocno + pastacno;
                    result.setText(Integer.toString(total));
                } else {
                    total = burgercno + pastacno;
                    result.setText(Integer.toString(total));
                }
            } else if (buffalo.isChecked()) {
                if (burger.isChecked()) {
                    total = burgercno + buffalocno + pastacno;
                    result.setText(Integer.toString(total));
                } else {
                    total = buffalocno + pastacno;
                    result.setText(Integer.toString(total));
                }
            } else {
                result.setText("210");
            }
        }
    }
}

