package com.example.appxuexi1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.net.ConnectivityManagerCompat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.*;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.example.appxuexi1.Xiti_Adapter;
import com.example.appxuexi1.Xiti_xml;
import com.example.appxuexi1.R;

public class XitiActivity extends AppCompatActivity {
    private GridLayout kecheng,me;
    private LinearLayout boxuegukc,boxueguxt,me2;
    private TextView xitilistbg;
    private FrameLayout framelist;
    private ListView xitilist;
    List<String> list;
    List<String> list1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiti);
        kecheng=(GridLayout)findViewById(R.id.kechengclick);
        kecheng.setOnClickListener(new kecheng());
        me=(GridLayout)findViewById(R.id.meclick);
        me.setOnClickListener(new me());
        initlist();
    }

    class kecheng implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(XitiActivity.this,KechengActivity.class);
            startActivity(intent);
            finish();

        }
    }
    class me implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(XitiActivity.this,OL_statusActivity.class);
            startActivity(intent);
            finish();

        }
    }
    @SuppressLint("WrongViewCast")
    private void initlist() {
        /*list=(FrameLayout)findViewById(R.id.list);
        if(mExercisesView==null){
            mExercisesView=new Xiti_View(this);
            list.addView(mExercisesView.getView());
        }
        else{
            mExercisesView.getView();
        }
        mExercisesView.showView();*/

        xitilist = (ListView) this.findViewById(R.id.xitilist);

            //获取到集合数据
            //名字列表，之后可以动态加入数据即可，这里只是数据例子
        list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");

        list1 = new ArrayList<>();
        list1.add("第1章 Androld基础入门");
        list1.add("第2章 Androld UI开发");
        list1.add("第3章 Activity");
        list1.add("第4章 数据储存");
        list1.add("第5章 SQLite数据库");
        list1.add("第6章 广播接收者");
        list1.add("第7章 服务");
        list1.add("第8章 内容提供者");
        list1.add("第9章 网络编程");
        list1.add("第10章 高级编程");


       /* list2.add("R.drawable.exercises_bg_1");
        list2.add("R.drawable.exercises_bg_2");
        list2.add("R.drawable.exercises_bg_3");
        list2.add("R.drawable.exercises_bg_4");
        list2.add("R.drawable.exercises_bg_1");
        list2.add("R.drawable.exercises_bg_2");
        list2.add("R.drawable.exercises_bg_3");
        list2.add("R.drawable.exercises_bg_4");
        list2.add("R.drawable.exercises_bg_1");
        list2.add("R.drawable.exercises_bg_2");*/


           List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
            for (int y = 0; y < list.size(); y++) {
                HashMap<String, Object> item = new HashMap<String, Object>();
                item.put("backgroundtext", list.get(y));
                item.put("title", list1.get(y));
                data.add(item);
            }
            //创建SimpleAdapter适配器将数据绑定到item显示控件上
            SimpleAdapter adapter = new SimpleAdapter(XitiActivity.this, data, R.layout.xiti_list,
                    new String[]{"backgroundtext", "title"}, new int[]{R.id.background, R.id.title});
            //实现列表的显示
            xitilist.setAdapter(adapter);

    }
}