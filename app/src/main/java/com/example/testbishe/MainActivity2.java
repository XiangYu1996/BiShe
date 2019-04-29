package com.example.testbishe;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    private TextView title, banner_qiandao_text, banner_lishi_text, banner_wode_text;
    private ViewPager vp;
    private QiandaoFragmentTeacher mQiandaoFragmentTeacher;
    private LishiFragment mLishiFragment;
    private WodeFragment mWodeFragment;

    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private TestViewStatePagerAdapter mFragmentAdapter;

    String[] titles = new String[]{"签到", "记录", "我的"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        initViews();

        mFragmentAdapter = new TestViewStatePagerAdapter(this.getSupportFragmentManager(), mFragmentList);
        vp.setOffscreenPageLimit(3);//ViewPager的缓存为3帧
        vp.setAdapter(mFragmentAdapter);
        title.setText(titles[0]);
        banner_qiandao_text.setBackgroundColor(getResources().getColor(R.color.banner_back_color));
        vp.setCurrentItem(0);//初始设置ViewPager选中第一帧
        banner_qiandao_text.setTextColor(Color.parseColor("#66CDAA"));

        //ViewPager的监听事件
        vp.addOnPageChangeListener(new MainActivity2.myPageChangeListener());
    }



    private void initViews() {

        title = (TextView) findViewById(R.id.title);
        banner_qiandao_text = (TextView) findViewById(R.id.qinadao_text_view);
        banner_lishi_text = (TextView) findViewById(R.id.lishi_text_view);
        banner_wode_text = (TextView) findViewById(R.id.wode_text_view);

        banner_qiandao_text.setOnClickListener(this);
        banner_lishi_text.setOnClickListener(this);
        banner_wode_text.setOnClickListener(this);


        vp = (ViewPager) findViewById(R.id.main_view_pager);
        mQiandaoFragmentTeacher = new QiandaoFragmentTeacher();
        mLishiFragment = new LishiFragment();
        mWodeFragment = new WodeFragment();

        //给FragmentList添加数据
        mFragmentList.add(mQiandaoFragmentTeacher);
        mFragmentList.add(mLishiFragment);
        mFragmentList.add(mWodeFragment);


    }



    public class myPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            /*此方法在页面被选中时调用*/

            title.setText(titles[position]);
            changeTextColor(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
                /*此方法是在状态改变的时候调用，其中arg0这个参数有三种状态（0，1，2）。
                arg0 ==1的时辰默示正在滑动，
                arg0==2的时辰默示滑动完毕了，
                arg0==0的时辰默示什么都没做。*/
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.qinadao_text_view:
                vp.setCurrentItem(0, true);
                break;
            case R.id.lishi_text_view:
                vp.setCurrentItem(1, true);
                break;
            case R.id.wode_text_view:
                vp.setCurrentItem(2, true);
                break;
        }

    }

    /*
     *由ViewPager的滑动修改底部导航Text的颜色
     */
    private void changeTextColor(int position) {
        if (position == 0) {
            banner_qiandao_text.   setBackgroundColor(getResources().getColor(R.color.banner_back_color));
            banner_lishi_text.setBackgroundColor(getResources().getColor(R.color.white));
            banner_wode_text.   setBackgroundColor(getResources().getColor(R.color.white));
            banner_qiandao_text.setTextColor(Color.parseColor("#66CDAA"));
            banner_lishi_text.setTextColor(Color.parseColor("#000000"));
            banner_wode_text.setTextColor(Color.parseColor("#000000"));
        } else if (position == 1) {
            banner_qiandao_text.   setBackgroundColor(getResources().getColor(R.color.white));
            banner_lishi_text.setBackgroundColor(getResources().getColor(R.color.banner_back_color));
            banner_wode_text.   setBackgroundColor(getResources().getColor(R.color.white));
            banner_lishi_text.setTextColor(Color.parseColor("#66CDAA"));
            banner_qiandao_text.setTextColor(Color.parseColor("#000000"));
            banner_wode_text.setTextColor(Color.parseColor("#000000"));
        } else if (position == 2) {
            banner_qiandao_text.   setBackgroundColor(getResources().getColor(R.color.white));
            banner_lishi_text.setBackgroundColor(getResources().getColor(R.color.white));
            banner_wode_text.   setBackgroundColor(getResources().getColor(R.color.banner_back_color));
            banner_wode_text.setTextColor(Color.parseColor("#66CDAA"));
            banner_qiandao_text.setTextColor(Color.parseColor("#000000"));
            banner_lishi_text.setTextColor(Color.parseColor("#000000"));
        }
    }
}
