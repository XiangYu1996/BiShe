package com.example.testbishe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DengLuActivity extends AppCompatActivity implements View.OnClickListener {

    private Button denglu;
    private Button zhuce;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.denglu);
        initViews();
    }

    private void initViews() {

        denglu = (Button) findViewById(R.id.denglu_btn);
        zhuce = (Button) findViewById(R.id.zhuce_btn);


        denglu.setOnClickListener(this);
        zhuce.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.denglu_btn:

                break;
            case R.id.zhuce_btn:

                break;


        }

    }
}
