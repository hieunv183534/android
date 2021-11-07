package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int a,b, result, thisO;
    int operator;
    TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);

        findViewById(R.id.btn0).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);
        findViewById(R.id.btnPlus).setOnClickListener(this);
        findViewById(R.id.btnMinus).setOnClickListener(this);
        findViewById(R.id.btnMul).setOnClickListener(this);
        findViewById(R.id.btnDiv).setOnClickListener(this);
        findViewById(R.id.btnEqual).setOnClickListener(this);
        findViewById(R.id.btnDot).setOnClickListener(this);
        findViewById(R.id.btnOpposite).setOnClickListener(this);
        findViewById(R.id.btnDel).setOnClickListener(this);
        findViewById(R.id.btnC).setOnClickListener(this);
        findViewById(R.id.btnCE).setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.btn0){
            this.updateO(0);
        }
        if(id == R.id.btn1){
            this.updateO(1);
        }
        if(id == R.id.btn2){
            this.updateO(2);
        }
        if(id == R.id.btn3){
            this.updateO(3);
        }
        if(id == R.id.btn4){
            this.updateO(4);
        }
        if(id == R.id.btn5){
            this.updateO(5);
        }
        if(id == R.id.btn6){
            this.updateO(6);
        }
        if(id == R.id.btn7){
            this.updateO(7);
        }
        if(id == R.id.btn8){
            this.updateO(8);
        }
        if(id == R.id.btn9){
            this.updateO(9);
        }
        if(id == R.id.btnPlus){
            if(this.result != 0){
                this.a = this.result;
            }else{
                this.a = this.thisO;
            }
            this.thisO  = 0;
            this.operator = 1;
            this.text2.setText(a+"+");
        }
        if(id == R.id.btnMinus){
            if(this.result != 0){
                this.a = this.result;
            }else{
                this.a = this.thisO;
            }
            this.thisO  = 0;
            this.operator = 2;
            this.text2.setText(a+"-");
        }
        if(id == R.id.btnMul){
            if(this.result != 0){
                this.a = this.result;
            }else{
                this.a = this.thisO;
            }
            this.thisO  = 0;
            this.operator = 3;
            this.text2.setText(a+"x");
        }
        if(id == R.id.btnDiv){
            if(this.result != 0){
                this.a = this.result;
            }else{
                this.a = this.thisO;
            }
            this.thisO  = 0;
            this.operator = 4;
            this.text2.setText(a+":");
        }
        if(id == R.id.btnDel){
            this.thisO /= 10;
            this.text1.setText(String.valueOf(this.thisO));
        }
        if(id == R.id.btnEqual){
            try {
                switch (this.operator){
                    case 1:
                        this.text2.setText(this.a+"+" + this.thisO+"=");
                        this.result = this.a + this.thisO;
                        this.text1.setText(String.valueOf(this.result));
                        break;
                    case 2:
                        this.text2.setText(this.a+"-" + this.thisO+"=");
                        this.result = this.a - this.thisO;
                        this.text1.setText(String.valueOf(this.result));
                        break;
                    case 3:
                        this.text2.setText(this.a+"x" + this.thisO+"=");
                        this.result = this.a * this.thisO;
                        this.text1.setText(String.valueOf(this.result));
                        break;
                    case 4:
                        if(this.thisO == 0){
                            this.a = 0;
                            this.thisO = 0;
                            this.result = 0;
                            this.text1.setText("Can't div by 0");
                            this.operator = -1;
                        }else{
                            this.text2.setText(this.a+":" + this.thisO+"=");
                            this.result = this.a / this.thisO;
                            this.text1.setText(String.valueOf(this.result));
                            break;
                        }
                }
                this.operator = -1;
                this.thisO = 0;
            }catch(Exception e){
                this.text1.setText(e.getMessage());
            }
        }
        if(id == R.id.btnDot){

        }
        if(id == R.id.btnOpposite){
            this.thisO = - this.thisO;
            this.text1.setText(String.valueOf(this.thisO));
        }
        if(id == R.id.btnC){
            this.a = 0;
            this.thisO = 0;
            this.result = 0;
            this.text1.setText(String.valueOf(0));
            this.text2.setText("");
            this.operator = 0;
        }
        if(id == R.id.btnCE){
            this.thisO = 0 ;
            this.text1.setText(String.valueOf(this.thisO));
        }
    }

    public void updateO(int x){
        if(this.operator == -1){
            this.text2.setText("");
            this.result =0;
        }
        this.thisO = this.thisO *10 +x;
        this.text1.setText(String.valueOf(this.thisO));
    }
}