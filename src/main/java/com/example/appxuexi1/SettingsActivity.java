package com.example.appxuexi1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

public class SettingsActivity extends AppCompatActivity {
    private ImageView back;
    private GridLayout xiugaimima,shezhimibao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        back=(ImageView)findViewById(R.id.back);
        back.setOnClickListener(new back());
        xiugaimima=(GridLayout)findViewById(R.id.xiugaimima);
        xiugaimima.setOnClickListener(new xiugai());
        shezhimibao=(GridLayout)findViewById(R.id.shezhimibao);
        shezhimibao.setOnClickListener(new mibao());
    }
    class back implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(SettingsActivity.this,OL_statusActivity.class);
            startActivity(intent);
            finish();
        }
    }
    class xiugai implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(SettingsActivity.this,XiugaimimaActivity.class);
            startActivity(intent);
            finish();
        }
    }
    class mibao implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(SettingsActivity.this,ShezhimibaoActivity.class);
            startActivity(intent);
            finish();
        }
    }
}