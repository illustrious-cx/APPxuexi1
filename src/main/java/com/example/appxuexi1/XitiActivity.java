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

            //?????????????????????
            //??????????????????????????????????????????????????????????????????????????????
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
        list1.add("???1??? Androld????????????");
        list1.add("???2??? Androld UI??????");
        list1.add("???3??? Activity");
        list1.add("???4??? ????????????");
        list1.add("???5??? SQLite?????????");
        list1.add("???6??? ???????????????");
        list1.add("???7??? ??????");
        list1.add("???8??? ???????????????");
        list1.add("???9??? ????????????");
        list1.add("???10??? ????????????");


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
            //??????SimpleAdapter???????????????????????????item???????????????
            SimpleAdapter adapter = new SimpleAdapter(XitiActivity.this, data, R.layout.xiti_list,
                    new String[]{"backgroundtext", "title"}, new int[]{R.id.background, R.id.title});
            //?????????????????????
            xitilist.setAdapter(adapter);

    }
}