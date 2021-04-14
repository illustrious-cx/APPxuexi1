package com.example.appxuexi1;
import android.content . Context;
import android.view. LayoutInflater;
import android.view. View;
import android.view.ViewGroup;
import android. widget. BaseAdapter;
import android. widget. TextView;
import java.util.List;
import com.example.appxuexi1.Xiti_xml;
import com.example.appxuexi1.R;
public class Xiti_Adapter extends BaseAdapter {
    private Context mContext;
    private List<Xiti_xml> ebl;

    public Xiti_Adapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<Xiti_xml> ebl) {
        this.ebl = ebl;
    }

    @Override
    public int getCount() {
        return ebl == null ? 0 : ebl.size();
    }

    public Xiti_xml getItem(int position) {
        return ebl == null ? null : ebl.get(position);
    }

    public long getItemId(int position) {
        return position;
    }
            /*得到相应position对应的Item视图，position是当前Item的位置，
            convertView参数就是滑出屏幕的Item的View*/

    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        //复用convertView
        if (convertView == null) {
            vh = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.xiti_list, null);
            vh.title = (TextView) convertView.findViewById(R.id.title);
            vh.content = (TextView) convertView.findViewById(R.id.content);
            vh.one = (TextView) convertView.findViewById(R.id.background);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
//获取position对应的Item的数据对象
        final Xiti_xml bean = getItem(position);
        if (bean != null) {
            vh.one.setText(position + 1 + "");
            vh.title.setText(bean.title);
            vh.content.setText(bean.content);
            vh.one.setBackgroundResource(bean.background);
        }
//每个Item的点击事件
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bean == null)
                    return;
//跳转到习题详情页面
            }
        });
        return convertView;
    }
    class ViewHolder{
        public TextView title, content;
        public TextView one;
    }
}
