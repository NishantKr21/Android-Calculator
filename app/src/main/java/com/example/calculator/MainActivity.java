package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText calculation,result;
    String curr,resul;
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,badd,bmul,bsub,bdiv,bdot,bequal,brem,bdel,bclr;
    private boolean dot_ins,oper_ins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        calculation = findViewById(R.id.calc);
        result = findViewById(R.id.res);
        curr = "";
        resul = "";
        dot_ins=false;
        oper_ins=false;

        b0 = findViewById(R.id.btn0);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);
        b5 = findViewById(R.id.btn5);
        b6 = findViewById(R.id.btn6);
        b7 = findViewById(R.id.btn7);
        b8 = findViewById(R.id.btn8);
        b9 = findViewById(R.id.btn9);
        bdot = findViewById(R.id.btnd);
        badd = findViewById(R.id.btnplus);
        bsub = findViewById(R.id.btnsub);
        bmul = findViewById(R.id.btnmul);
        bdiv = findViewById(R.id.btndiv);
        bequal = findViewById(R.id.btnequal);
        brem = findViewById(R.id.btnrem);
        bdel = findViewById(R.id.btnOFF);
        bclr = findViewById(R.id.btnclr);

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr += "0";
                displayOne();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr += "1";
                displayOne();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr += "2";
                displayOne();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr += "3";
                displayOne();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr += "4";
                displayOne();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr += "5";
                displayOne();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr += "6";
                displayOne();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr += "7";
                displayOne();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr += "8";
                displayOne();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr += "9";
                displayOne();
            }
        });
        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(curr.isEmpty()){
                    curr+="0.";
                    dot_ins=true;
                } else if(dot_ins==false){
                    curr+=".";
                    dot_ins=true;
                }
                displayOne();
            }
        });
        bclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
                displayOne();
                displayTwo();
            }
        });
        bdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backSpace();
                displayOne();
            }
        });
        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot_ins=false;
                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1,curr.length()).equals(".")){
                        backSpace();
                    }
                    if(oper_ins==false){
                        curr+=" / ";
                        oper_ins=true;
                    }
                }
                displayOne();

            }
        });
        bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot_ins=false;
                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1,curr.length()).equals(".")){
                        backSpace();
                    }
                    if(oper_ins==false){
                        curr+=" * ";
                        oper_ins=true;
                    }
                }
                displayOne();

            }
        });
        badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot_ins=false;
                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1,curr.length()).equals(".")){
                        backSpace();
                    }
                    if(oper_ins==false){
                        curr+=" + ";
                        oper_ins=true;
                    }
                }
                displayOne();

            }
        });
        bsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot_ins=false;
                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1,curr.length()).equals(".")){
                        backSpace();
                    }
                    if(oper_ins==false){
                        curr+=" - ";
                        oper_ins=true;
                    }
                }
                displayOne();

            }
        });
        brem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot_ins=false;
                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1,curr.length()).equals(".")){
                        backSpace();
                    }
                    if(oper_ins==false){
                        curr+=" % ";
                        oper_ins=true;
                    }
                }
                displayOne();

            }
        });
        bequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(oper_ins==true && !curr.substring(curr.length()-1,curr.length()).equals(" ")){
                    String [] tokens=curr.split(" ");

                    switch (tokens[1].charAt(0)){
                        case '+':
                            resul=Double.toString(Double.parseDouble(tokens[0]) + Double.parseDouble(tokens[2]));
                            break;
                        case '-':
                            resul=Double.toString(Double.parseDouble(tokens[0]) - Double.parseDouble(tokens[2]));
                            break;
                        case '*':
                            resul=Double.toString(Double.parseDouble(tokens[0]) * Double.parseDouble(tokens[2]));
                            break;
                        case '/':
                            resul=Double.toString(Double.parseDouble(tokens[0]) / Double.parseDouble(tokens[2]));
                            break;
                        case '%':
                            resul=Double.toString(Double.parseDouble(tokens[0]) % Double.parseDouble(tokens[2]));
                            break;
                    }
                    displayTwo();
                }
            }
        });
        }

        public void displayOne(){
            calculation.setText(curr);
        }
        public void displayTwo(){
            result.setText(resul);
        }
        public void clear(){
             curr="";
             resul="";
             dot_ins=false;
             oper_ins=false;

        }
        public void backSpace(){
             if(!curr.isEmpty()){
                 if(curr.substring(curr.length()-1,curr.length()).equals(".")){
                     dot_ins=false;

                 }
                 if(curr.substring(curr.length()-1,curr.length()).equals(" ")){
                     curr=curr.substring(0,curr.length()-3);
                     oper_ins=false;
                 }
                 else{
                     curr=curr.substring(0,curr.length()-1);
                 }
             }
        }

}