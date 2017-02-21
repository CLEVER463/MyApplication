package com.pinyin.liusirui.testdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText pass;
    private Button login;
    private LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.py_user_name);
        pass = (EditText)findViewById(R.id.py_user_pass);
        login = (Button)findViewById(R.id.login);
        container = (LinearLayout)findViewById(R.id.container);
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pass.setFocusable(false);
            }
        });
        pass.setFocusable(true);
        pass.setFocusableInTouchMode(true);
        pass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(pass.getText()!=null&&hasFocus){
                    if(name.getText().equals(pass.getText()))
                    Toast.makeText(getApplicationContext(),"True",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"false",Toast.LENGTH_LONG).show();
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),name.getText()+"\n"+pass.getText(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
