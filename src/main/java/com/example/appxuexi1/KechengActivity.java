package com.example.appxuexi1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

public class KechengActivity extends AppCompatActivity {
    private GridLayout xiti,me;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kecheng);
        xiti=(GridLayout)findViewById(R.id.xiticlick);
        xiti.setOnClickListener(new xiti());
        me=(GridLayout)findViewById(R.id.meclick);
        me.setOnClickListener(new me());
    }
    class xiti implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(KechengActivity.this,XitiActivity.class);
            startActivity(intent);
            finish();

        }
    }
    class me implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(KechengActivity.this,OL_statusActivity.class);
            startActivity(intent);
            finish();

        }
    }
}