package com.example.appxuexi1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static android.graphics.Color.WHITE;
import static android.graphics.Color.rgb;

public class LoginActivity extends AppCompatActivity {
    private Button loginclick;
    private TextView registertext;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);
        loginclick=(Button)findViewById(R.id.denglubutton);
        loginclick.setOnClickListener(new denglu());
        registertext=(TextView)findViewById(R.id.registertext);
        registertext.setOnClickListener(new zhucezhanghao());
        back=(ImageView)findViewById(R.id.back);
        back.setOnClickListener(new back());
    }
    public String md5(String text){
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance( "md5" );
            byte[] result = digest.digest(text.getBytes( ));
            StringBuilder sb = new StringBuilder();
            for(byte b : result){
                int number = b & 0xff;
                String hex = Integer.toHexString(number);
                if(hex.length() == 1){
                    sb.append("0" + hex);}else{
                    sb.append (hex);
                }
            }
            return sb.toString();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return "";
        }
    }

    class denglu implements View.OnClickListener {
        public void onClick(View View){
            TextView username=(TextView)findViewById(R.id.username);//获取用户名文本框ID
            TextView password=(TextView)findViewById(R.id.password);//获取密码文本框ID
            String user=username.getText().toString();//获取文本信息
            String pass=md5(password.getText().toString());//获取文本信息

            SharedPreferences sp = getSharedPreferences("loginInfo", MODE_PRIVATE);
            String zhanghao=sp.getString(user,null);
            String mima=sp.getString(pass,null);

            if(user.equals("")){
                Toast.makeText(getApplicationContext(), "账号不能为空", Toast.LENGTH_SHORT);
                Toast toast = Toast.makeText(getApplicationContext(), "账号不能为空", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            else if(!user.equals(zhanghao)){
                Toast.makeText(getApplicationContext(), "账号输入错误", Toast.LENGTH_SHORT);
                Toast toast = Toast.makeText(getApplicationContext(), "账号输入错误", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }

            else if(pass.equals("")){
                Toast.makeText(getApplicationContext(), "密码不能为空", Toast.LENGTH_SHORT);
                Toast toast = Toast.makeText(getApplicationContext(), "密码不能为空", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }

            else if(!pass.equals(mima)){
                Toast.makeText(getApplicationContext(), "密码输入错误", Toast.LENGTH_SHORT);
                Toast toast = Toast.makeText(getApplicationContext(), "密码输入错误", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }

            else {
                Intent intent=new Intent(LoginActivity.this,OL_statusActivity.class);


                Intent back = new Intent();
                back.putExtra("username", username.getText().toString());
                setResult(RESULT_OK, back);


                finish();
            }


        }


    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data!=null)
        {
            String username=data.getStringExtra("username");
            if (!TextUtils.isEmpty(username))
            {

            }
        }
    }
    class zhucezhanghao implements  View.OnClickListener{
        public void onClick(View V){
            Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(intent);
            finish();
        }
    }
    class back implements View.OnClickListener{
        public void onClick(View V){
            Intent intent=new Intent(LoginActivity.this,OL_statusActivity.class);
            startActivity(intent);
            finish();
        }
    }

}