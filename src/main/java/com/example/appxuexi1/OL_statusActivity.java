package com.example.appxuexi1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OL_statusActivity extends AppCompatActivity {
    private LinearLayout click;
    private TextView name;
    private GridLayout shezhi,kecheng,xiti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ol_status_activity);
        click=(LinearLayout)findViewById(R.id.touxiang);
        click.setOnClickListener(new touxiang());
        shezhi=(GridLayout)findViewById(R.id.shezhi);
        shezhi.setOnClickListener(new setting());
        name=(TextView)findViewById(R.id.name);
        kecheng=(GridLayout)findViewById(R.id.kecheng);
        kecheng.setOnClickListener(new kecheng());
        xiti=(GridLayout)findViewById(R.id.xiti);
        xiti.setOnClickListener(new xiti());


       /* Intent intent = getIntent();//接受来自登录页面的值
        String jieshou = intent.getStringExtra("username");//接受来自登录页面的值
        String jieshoulogin =intent.getStringExtra("login");//接受来自登录页面的值*/

    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data!=null)
        {
            String username=data.getStringExtra("username");
            if (!TextUtils.isEmpty(username))
            {
                name.setText(username);

            }
        }
    }
    class touxiang implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(OL_statusActivity.this,LoginActivity.class);
            startActivityForResult(intent,0);

        }
    }
    class setting implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(OL_statusActivity.this,SettingsActivity.class);
            startActivity(intent);
            finish();
        }
    }
    class kecheng implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(OL_statusActivity.this,KechengActivity.class);
            startActivity(intent);
            finish();
        }
    }
    class xiti implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(OL_statusActivity.this,XitiActivity.class);
            startActivity(intent);
            finish();
        }
    }


}