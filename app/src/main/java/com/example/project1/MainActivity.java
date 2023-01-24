package com.example.project1;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText num1 = (EditText) findViewById(R.id.num1);
        final EditText num2 = (EditText) findViewById(R.id.num2);
        final EditText num3 = (EditText) findViewById(R.id.num3);

        final ListView list1 = (ListView) findViewById(R.id.list1);

        Button randomBtn = (Button) findViewById(R.id.rendomBtn);
        Button resultBtn = (Button) findViewById(R.id.resultBtn);

        randomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rand1 = new Random().nextInt(8)+2;
                int rand2 = new Random().nextInt(8)+2;

                num1.setText(String.valueOf(rand1));
                num2.setText(String.valueOf(rand2));
            }
        });

        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(view.getWindowToken(), 0);

                if (num1.getText().equals("") || num2.getText().equals("") || num3.getText().equals("")) {
                    Toast.makeText(MainActivity.this, "값을 넣어 주세요!", Toast.LENGTH_SHORT).show();
                } else {
                    String str1 = num1.getText().toString();
                    String str2 = num2.getText().toString();
                    String str3 = num3.getText().toString();

                    int a1 = Integer.parseInt(str1);
                    int a2 = Integer.parseInt(str2);
                    int a3 = Integer.parseInt(str3);

                    int res1 = a1 * a2;
                    if (a3 == res1) {
                        Toast.makeText(MainActivity.this, "정답입니다!", Toast.LENGTH_SHORT).show();
                        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, new String[0]);

                        list1.setAdapter(adapter1);
                    }else {
                        Toast.makeText(MainActivity.this, "틀렸습니다!", Toast.LENGTH_SHORT).show();
                        String[] values = new String[9];

                        for (int i = 0; i < 9; i++) {
                            values[i] = String.valueOf(a1) + "X" + (i + 1) + "=" + (a1 * (i + 1));
                        }
                        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, values);

                        list1.setAdapter(adapter1);

                    }
                }
            }
        });
    }
}