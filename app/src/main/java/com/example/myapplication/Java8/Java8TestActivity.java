package com.example.myapplication.Java8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.Arrays;


/**
 * Lambda 表达式
 * 默认方法
 *
 */

public class Java8TestActivity extends AppCompatActivity {

//    private Button button;
//    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java8_test);

        initView();
    }

    private void initView() {
//        button = findViewById(R.id.button);
//        textView = findViewById(R.id.text);


//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                v.setBackgroundResource(R.color.color_aaaaaa);
//            }
//        });
//
//        button.setOnClickListener(v -> v.setBackgroundResource(R.color.color_aaaaaa));

        initData();
    }

    private void initData() {
        StringBuilder builder = new StringBuilder();


        builder.append("10 - 5 = " + operate(10, 5, new MathInterface() {
            @Override
            public int operation(int a, int b) {
                return a - b;
            }
        }));

        builder.append(System.getProperty("line.separator"));

        builder.append("10 - 5 = " + operate(10, 5, (int a, int b) -> {
            return a - b;
        }));

        builder.append(System.getProperty("line.separator"));

        builder.append("10 - 5 = " + operate(10, 5, (a, b) -> {
            return a - b;
        }));

        builder.append(System.getProperty("line.separator"));

        builder.append("10 - 5 = " + operate(10, 5, (a, b) -> a - b ));

        builder.append(System.getProperty("line.separator"));

        MathInterface addition = (int a, int b) -> a + b;
        builder.append("10 + 5 = " + operate(10, 5, addition));

        builder.append(System.getProperty("line.separator"));

        MathInterface max = (int a, int b) -> {
            if (a > b){
                return a;
            } else {
                return  b;
            }
        };
        builder.append("max of (10  5) = " + operate(10, 5, max));

        builder.append(System.getProperty("line.separator"));

        builder.append("max of (10  5) = " + operate(10, 5, new MathInterface() {
            @Override
            public int operation(int a, int b) {
                return Math.max(a, b);
            }
        }));

        builder.append(System.getProperty("line.separator"));

        builder.append("max of (10  5) = " + operate(10, 5, (a, b) -> Math.max(a, b)));

        builder.append(System.getProperty("line.separator"));

        //方法引用
        builder.append("max of (10  5) = " + operate(10, 5, Math::max));

        builder.append(System.getProperty("line.separator"));

        builder.append("10 x 5 = " + MultiInterface.operation(10, 5));

        builder.append(System.getProperty("line.separator"));

        DivisionOperation division = new DivisionOperation();
        builder.append("10 / 5 = " + division.operation(10, 5));

//        textView.setText(builder.toString());
    }

    private int operate(int a, int b, MathInterface mathOperation) {
        return mathOperation.operation(a, b);
    }

    interface MathInterface {
        int operation(int a, int b);
    }

    interface MultiInterface {
        static int operation(int a, int b){
            return a*b;
        };
    }

    interface DivisionInterface {
        default int operation(int a, int b) {
            return a / b;
        }
    }

    class DivisionOperation implements DivisionInterface{

    }

}
