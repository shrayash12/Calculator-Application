package com.example.calculatorapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Double firstValueWithOperator;
    Double secondValueWithOperator;
    private HistoryViewModel historyViewModel;


    Operator operator;
    DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        historyViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(HistoryViewModel.class);


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
        Button buttonDecimalPoint = findViewById(R.id.buttonDecimalPoint);
        Button buttonDelete = findViewById(R.id.buttonDelete);
        ImageView imageView = findViewById(R.id.historyMenu_ic);
        final EditText editText_1 = findViewById(R.id.editText_1);
        final EditText editText_2 = findViewById(R.id.editText_2);

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

                editText_1.setText(editText_1.getText().toString() + "1");
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText_1.setText(editText_1.getText().toString() + "2");
            }
        });
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText_1.setText(editText_1.getText().toString() + "3");
            }
        });
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText_1.setText(editText_1.getText().toString() + "4");
            }
        });
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText_1.setText(editText_1.getText().toString() + "5");
            }
        });
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText_1.setText(editText_1.getText().toString() + "6");
            }
        });
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText_1.setText(editText_1.getText().toString() + "7");
            }
        });
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText_1.setText(editText_1.getText().toString() + "8");
            }
        });
        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText_1.setText(editText_1.getText().toString() + "9");
            }
        });
        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText_1.setText(editText_1.getText().toString() + "0");
            }
        });
        buttonDecimalPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText_1.setText(editText_1.getText().toString() + ".");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = Operator.ADD;
                firstValueWithOperator = Double.parseDouble(editText_1.getText().toString());
                editText_2.setText(decimalFormat.format(firstValueWithOperator) + " + ");
                editText_1.setText("");
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = Operator.SUBTRACT;
                firstValueWithOperator = Double.parseDouble(editText_1.getText().toString());
                editText_2.setText(decimalFormat.format(firstValueWithOperator) + " - ");
                editText_1.setText("");
            }
        });

        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = operator.MULTI;
                firstValueWithOperator = Double.parseDouble(editText_1.getText().toString());
                editText_2.setText(decimalFormat.format(firstValueWithOperator) + " * ");
                editText_1.setText("");
            }
        });
        buttonDevide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = operator.DEVIDE;
                firstValueWithOperator = Double.parseDouble(editText_1.getText().toString());
                editText_2.setText(decimalFormat.format(firstValueWithOperator) + "/");
                editText_1.setText("");

            }
        });
        buttonModulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = operator.MODULO;
                firstValueWithOperator = Double.parseDouble(editText_1.getText().toString());
                editText_2.setText(decimalFormat.format(firstValueWithOperator) + "%");
                editText_1.setText("");

            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText_2.setText("");
                editText_1.setText("");
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText_1.getText().toString();
                s = s.substring(0, s.length() - 1);
                editText_1.setText(s);
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondValueWithOperator = Double.parseDouble(editText_1.getText().toString());

                if (operator.equals(Operator.ADD)) {
                    double ans = firstValueWithOperator + secondValueWithOperator;
                    editText_2.setText("");
                    editText_1.setText("");
                    editText_2.setText(decimalFormat.format(firstValueWithOperator) + " + "
                            + decimalFormat.format(secondValueWithOperator) + " = " + decimalFormat.format(ans));
                } else if (operator.equals(Operator.SUBTRACT)) {
                    double ans = firstValueWithOperator - secondValueWithOperator;
                    editText_2.setText("");
                    editText_1.setText("");
                    editText_2.setText(decimalFormat.format(firstValueWithOperator) + " - "
                            + decimalFormat.format(secondValueWithOperator) + " = " + decimalFormat.format(ans));
                } else if (operator.equals(Operator.MULTI)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    double ans = firstValueWithOperator * secondValueWithOperator;
                    editText_2.setText("");
                    editText_1.setText("");
                    stringBuilder.append(decimalFormat.format(firstValueWithOperator));
                    stringBuilder.append(" * ");
                    stringBuilder.append(decimalFormat.format(secondValueWithOperator));
                    stringBuilder.append(" = ");
                    stringBuilder.append(decimalFormat.format(ans));

                    editText_2.setText(stringBuilder.toString());

                } else if (operator.equals(operator.DEVIDE)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    double ans = firstValueWithOperator / secondValueWithOperator;
                    editText_2.setText("");
                    editText_1.setText("");
                    stringBuilder.append(decimalFormat.format(firstValueWithOperator));
                    stringBuilder.append(" / ");
                    stringBuilder.append(decimalFormat.format(secondValueWithOperator));
                    stringBuilder.append(" = ");
                    stringBuilder.append(decimalFormat.format(ans));
                    editText_2.setText(stringBuilder.toString());
                } else if (operator.equals(operator.MODULO)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    double ans = firstValueWithOperator % secondValueWithOperator;
                    editText_2.setText("");
                    editText_1.setText("");
                    stringBuilder.append(decimalFormat.format(firstValueWithOperator));
                    stringBuilder.append(" % ");
                    stringBuilder.append(decimalFormat.format(secondValueWithOperator));
                    stringBuilder.append(" = ");
                    stringBuilder.append(decimalFormat.format(ans));
                    editText_2.setText(stringBuilder.toString());
                }
                historyViewModel.insert(new History(editText_2.getText().toString()));

            }
        });
    }
}
