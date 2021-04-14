package com.example.appxuexi1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class XiugaimimaActivity extends AppCompatActivity {
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiugaimima);
        back=(ImageView)findViewById(R.id.back);
        back.setOnClickListener(new back());
    }
    class back implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(XiugaimimaActivity.this,SettingsActivity.class);
            startActivity(intent);
            finish();
        }
    }
}