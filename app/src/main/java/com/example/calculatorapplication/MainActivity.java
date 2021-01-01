package com.example.calculatorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Double firstValueWithOperator;
    Double secondValueWithOperator;


    Operator operator;
    DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonOne = findViewById(R.id.buttonOne);

        decimalFormat = new DecimalFormat("#.##########");


        Button buttonTwo = findViewById(R.id.buttonTwo);

        Button buttonThree = findViewById(R.id.buttonThree);
        Button buttonFour = findViewById(R.id.buttonFour);
        Button buttonFive = findViewById(R.id.buttonFive);
        Button buttonSix = findViewById(R.id.buttonSix);
        Button buttonSeven = findViewById(R.id.buttonSeven);
        Button buttonEight = findViewById(R.id.buttonEight);
        Button buttonNine = findViewById(R.id.buttonNine);
        Button buttonZero = findViewById(R.id.buttonZero);


        final EditText editText = findViewById(R.id.editText);

        final TextView textView = findViewById(R.id.tvTextView);


        Button buttonAdd = findViewById(R.id.buttonAdd);

        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        Button buttonMulti = findViewById(R.id.buttonMulti);
        Button buttonDevide = findViewById(R.id.buttonDevide);
        Button buttonModulo = findViewById(R.id.buttonModulo);

        Button buttonEqual = findViewById(R.id.buttonEqual);
        Button buttonClear = findViewById(R.id.buttonClear);

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText.setText(editText.getText().toString() + "1");
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText.setText(editText.getText().toString() + "2");
            }
        });
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "3");
            }
        });
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "4");
            }
        });
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "5");
            }
        });
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "6");
            }
        });
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "7");
            }
        });
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "8");
            }
        });
        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "9");
            }
        });
        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "0");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = Operator.ADD;
                firstValueWithOperator = Double.parseDouble(editText.getText().toString());
                textView.setText(decimalFormat.format(firstValueWithOperator) + " + ");
                editText.setText("");
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = Operator.SUBTRACT;
                firstValueWithOperator = Double.parseDouble(editText.getText().toString());
                textView.setText(decimalFormat.format(firstValueWithOperator) + " - ");
                editText.setText("");
            }
        });

        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = operator.MULTI;
                firstValueWithOperator = Double.parseDouble(editText.getText().toString());
                textView.setText(decimalFormat.format(firstValueWithOperator) + " * ");
                editText.setText("");
            }
        });
        buttonDevide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = operator.DEVIDE;
                firstValueWithOperator = Double.parseDouble(editText.getText().toString());
                textView.setText(decimalFormat.format(firstValueWithOperator) + "/");
                editText.setText("");

            }
        });
        buttonModulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = operator.MODULO;
                firstValueWithOperator = Double.parseDouble(editText.getText().toString());
                textView.setText(decimalFormat.format(firstValueWithOperator) + "%");
                editText.setText("");

            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
                editText.setText("");
            }
        });


        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondValueWithOperator = Double.parseDouble(editText.getText().toString());

                if (operator.equals(Operator.ADD)) {
                    double ans = firstValueWithOperator + secondValueWithOperator;
                    textView.setText("");
                    editText.setText("");
                    textView.setText(decimalFormat.format(firstValueWithOperator) + "+"
                            + decimalFormat.format(secondValueWithOperator) + " = " + decimalFormat.format(ans));
                } else if (operator.equals(Operator.SUBTRACT)) {
                    double ans = firstValueWithOperator - secondValueWithOperator;
                    textView.setText("");
                    editText.setText("");
                    textView.setText(decimalFormat.format(firstValueWithOperator) + "+"
                            + decimalFormat.format(secondValueWithOperator) + " = " + decimalFormat.format(ans));
                } else if (operator.equals(Operator.MULTI)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    double ans = firstValueWithOperator * secondValueWithOperator;
                    textView.setText("");
                    editText.setText("");
                    stringBuilder.append(decimalFormat.format(firstValueWithOperator));
                    stringBuilder.append(" * ");
                    stringBuilder.append(decimalFormat.format(secondValueWithOperator));
                    stringBuilder.append(" = ");
                    stringBuilder.append(decimalFormat.format(ans));

                    textView.setText(stringBuilder.toString());

                } else if (operator.equals(operator.DEVIDE)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    double ans = firstValueWithOperator / secondValueWithOperator;
                    textView.setText("");
                    editText.setText("");
                    stringBuilder.append(decimalFormat.format(firstValueWithOperator));
                    stringBuilder.append(" / ");
                    stringBuilder.append(decimalFormat.format(secondValueWithOperator));
                    stringBuilder.append(" = ");
                    stringBuilder.append(decimalFormat.format(ans));
                    textView.setText(stringBuilder.toString());
                } else if (operator.equals(operator.MODULO)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    double ans = firstValueWithOperator % secondValueWithOperator;
                    textView.setText("");
                    editText.setText("");
                    stringBuilder.append(decimalFormat.format(firstValueWithOperator));
                    stringBuilder.append(" % ");
                    stringBuilder.append(decimalFormat.format(secondValueWithOperator));
                    stringBuilder.append(" = ");
                    stringBuilder.append(decimalFormat.format(ans));
                    textView.setText(stringBuilder.toString());
                }
            }
        });
    }
}
