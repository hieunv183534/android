package com.example.hello_toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int countShow;
    private Button button_toast, button_count;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_toast = (Button) findViewById(R.id.button_toast);
        button_count = (Button) findViewById(R.id.button_count);
        textView = (TextView) findViewById(R.id.textView);
        countShow = 0;


        button_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(MainActivity.this, R.string.hello_toast , Toast.LENGTH_SHORT);
                toast.show();
                countShow = 0;
                textView.setText(Integer.toString(countShow));
            }
        });

        button_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countShow++;
                textView.setText(Integer.toString(countShow));
            }
        });
    }


}