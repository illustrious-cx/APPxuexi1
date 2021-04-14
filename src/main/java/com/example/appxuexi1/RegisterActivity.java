package com.example.appxuexi1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static android.graphics.Color.*;

public class RegisterActivity extends AppCompatActivity {
    private Button registerclick;
    private ImageView backclick;
    String a = "^[0-9]*$";//纯数字检测
    String b = "^[\u4e00-\u9fa5]+$";//纯汉字检测
    String c = "^[@ \u4E00-\u9FA5A-Za-z0-9]+$";//非法字符检测
    String d = "^[A-Za-z0-9]+$";//英文或者数字检测
    String e = "^1\\d{10}$";//11位手机号码检测(1开头)检测
    private String sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registeractivity);
        registerclick=(Button)findViewById(R.id.zhucebutton);
        registerclick.setOnClickListener(new zhuce());
        backclick=(ImageView)findViewById(R.id.back);
        backclick.setOnClickListener(new imageback());
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


    class zhuce implements View.OnClickListener {
        public void onClick(View View){
            TextView username=(TextView)findViewById(R.id.username);//获取用户名文本框ID
            TextView password=(TextView)findViewById(R.id.password);//获取密码文本框ID
            TextView repassword=(TextView)findViewById(R.id.repassword);//获取确认密码文本框ID
            String user=username.getText().toString();//获取文本信息
            String pass=password.getText().toString();//获取文本信息
            String repass=repassword.getText().toString();//获取文本信息

            if (user.equals("")){
                Toast.makeText(getApplicationContext(),"用户名不能为空", Toast.LENGTH_SHORT);
                Toast toast= Toast.makeText(getApplicationContext(),"用户名不能为空", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            else if(pass.equals("")){
                Toast.makeText(getApplicationContext(),"密码不能为空", Toast.LENGTH_SHORT);
                Toast toast= Toast.makeText(getApplicationContext(),"密码不能为空", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            else if(!repass.equals(pass)){
                Toast.makeText(getApplicationContext(),"密码不一致", Toast.LENGTH_SHORT);
                Toast toast= Toast.makeText(getApplicationContext(),"密码不一致", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            else if(!user.matches(d)||!pass.matches(d)){
                Toast.makeText(getApplicationContext(),"数据格式不正确", Toast.LENGTH_SHORT);
                Toast toast= Toast.makeText(getApplicationContext(),"数据格式不正确", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            else {
                Intent intent=new Intent();
                intent.setClass(RegisterActivity.this,LoginActivity.class);//传值
                intent.putExtra("username",user);//传值
                setResult(RESULT_OK,intent);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_SHORT);
                Toast toast = Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_SHORT);
                toast.show();
                //click.setBackground(R.drawable.register_icon_selected);
                registerclick.setTextColor(WHITE);
                registerclick.setText("注册成功");
                //创建的文件loginInfo.xml
                SharedPreferences sp = getSharedPreferences("loginInfo", MODE_PRIVATE);

                //写入userName，md5Psw
                SharedPreferences.Editor editor = sp.edit();
                editor.putString(user,md5(pass));
                editor.commit();

                //对接loginInfo.xml，获取username为123456的加密密码并输出
                sp = getSharedPreferences("loginInfo", MODE_PRIVATE);
                String spPsw = sp.getString("123456", null);
                System.out.println(pass);

                /*SQLiteOpenHelper sqLiteOpenHelper = new SQLiteHelper(this);
                sqLiteOpenHelper.getReadableDatabase();//获取数据库.db文件的地址
//创增删改
                sqLiteOpenHelper.getReadableDatabase().execSQL(sql);
//查询数据
                Cursor cursor = sqLiteOpenHelper.getReadableDatabase().rawQuery(sql);
                while (cursor.moveToNext()) {
                    String abc = cursor.getString(cursor.getColumnIndex("panduan"));
                    System.out.println(abc);
                }*/
            }
        }

    }
    class imageback implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

}
