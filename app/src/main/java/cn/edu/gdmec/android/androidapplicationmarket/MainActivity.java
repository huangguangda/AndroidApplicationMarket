package cn.edu.gdmec.android.androidapplicationmarket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private String[] names = {"京东商城","QQ","QQ斗地主","新浪微博","天猫","UC","微信"};

    private int[] icons = {R.drawable.jd,R.drawable.qq,R.drawable.dz,R.drawable.xl,R.drawable.tm,R.drawable.uc,R.drawable.wx};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        //定义需要的适配器数据

        mListView = (ListView) findViewById ( R.id.lv );
        //listview
        MyBaseAdapter mAdapter = new MyBaseAdapter ();
        //设置adapter
        mListView.setAdapter ( mAdapter );

    }
    class MyBaseAdapter extends BaseAdapter{

        //返回item总数
        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return names[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        //得到item的view的视图
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //将list_item布局转换成一个View对象
            View view=View.inflate ( MainActivity.this, R.layout.list_item, null );
            //找到条目中控件
            ImageView imageView=(ImageView) view.findViewById ( R.id.item_image );

            TextView mTextView=(TextView) view.findViewById ( R.id.item_tv );

            mTextView.setText ( names[position] );
            imageView.setBackgroundResource ( icons[position] );
            return view;
        }
    }
}
