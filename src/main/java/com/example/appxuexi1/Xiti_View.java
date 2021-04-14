package com.example.appxuexi1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import com.example.appxuexi1.Xiti_Adapter;
import com.example.appxuexi1.Xiti_xml;
import com.example.appxuexi1.R;

public class Xiti_View {
    private ListView list;
    private Xiti_Adapter adapter;
    private List<Xiti_xml> ebl;
    private Activity mContext;
    private LayoutInflater mInflater;
    private View mCurrentView;


    public Xiti_View(Activity context) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    private void createView() {
        initView();
    }

    private void initView() {
        mCurrentView = mInflater.inflate(R.layout.xiti_list, null);
        list = (ListView) mCurrentView.findViewById(R.id.xitilist);
        adapter = new Xiti_Adapter(mContext);
        initData();
        adapter.setData(ebl);
        list.setAdapter(adapter);
    }

    private void initData() {
        ebl = new ArrayList<Xiti_xml>();
        for (int i = 0; i < 10; i++) {
            Xiti_xml bean = new Xiti_xml();
            bean.id = (i + 1);
            switch (i) {
                case 0:
                    bean.title = "第1章 Androld基础入门";
                    bean.content = "共计5题";
                    bean.background = (R.drawable.exercises_bg_1);
                    break;
                case 1:
                    bean.title = "第2章 Androld UI开发";
                    bean.content = "共计5题";
                    bean.background = (R.drawable.exercises_bg_2);
                    break;
                case 2:
                    bean.title = "第3章 Activity";
                    bean.content = "共计5题";
                    bean.background = (R.drawable.exercises_bg_3);
                    break;
                case 3:
                    bean.title = "第4章 数据储存";
                    bean.content = "共计5题";
                    bean.background = (R.drawable.exercises_bg_4);
                    break;
                case 4:
                    bean.title = "第5章 SQLite数据库";
                    bean.content = "共计5题";
                    bean.background = (R.drawable.exercises_bg_1);
                    break;
                case 5:
                    bean.title = "第6章 广播接收者";
                    bean.content = "共计5题";
                    bean.background = (R.drawable.exercises_bg_2);
                    break;
                case 6:
                    bean.title="第7章 服务";
                    bean.content="共计5题";
                    bean.background= (R.drawable.exercises_bg_3);
                    break;
                case 7:
                    bean.title="第8章 内容提供者";
                    bean.content="共计5题";
                    bean.background= (R.drawable.exercises_bg_4);
                    break;
                case 8:
                    bean.title="第9章 网络编程";
                    bean.content="共计5题";
                    bean.background= (R.drawable.exercises_bg_1);
                    break;
                case 9:
                    bean.title="第10章 高级编程";
                    bean.content="共计5题";
                    bean.background= (R.drawable.exercises_bg_2);
                    break;
                default:
                    break;

            }
            ebl.add(bean);
        }
    }
    public View getView(){
        if(mCurrentView==null){
            createView();
        }
        return mCurrentView;
    }
    public  void showView(){
        if(mCurrentView==null){
            createView();
        }
        mCurrentView.setVisibility(View.VISIBLE);
    }
}
