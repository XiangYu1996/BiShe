package com.example.testbishe;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

import java.util.ArrayList;
import java.util.List;

public class QiandaoFragment extends Fragment {
    List<ItemQiandao> mList = new ArrayList<>();
    RecyclerView mRecyclerView;
    ItemQiandaoAdapter mItemQiandaoAdapter;



    //百度地图获取定位
    private final String TAG = "MainActivity";
    private LocationClient mLocationClient;
    private BDAbstractLocationListener mBDLocationListener;
    private Double latitude;
    private Double longitude;



    public QiandaoFragment(){
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.qiandao_fragment, container, false);

        // 声明LocationClient类
        mLocationClient = new LocationClient(this.getContext());
        mBDLocationListener = new MyBDLocationListener();
        // 注册监听
        mLocationClient.registerLocationListener(mBDLocationListener);


        initList();

        mRecyclerView = view.findViewById(R.id.qiandao_recyclerView);
        mItemQiandaoAdapter = new ItemQiandaoAdapter(mList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(new RecycleViewDivider(this.getContext(), LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mItemQiandaoAdapter);


        return view;
    }


    /** 获得所在位置经纬度及详细地址 */
    public void getLocation(View view) {
        // 声明定位参数
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);// 设置定位模式 高精度
        option.setCoorType("bd09ll");// 设置返回定位结果是百度经纬度 默认gcj02
        option.setScanSpan(5000);// 设置发起定位请求的时间间隔 单位ms
        option.setIsNeedAddress(true);// 设置定位结果包含地址信息
        option.setNeedDeviceDirect(true);// 设置定位结果包含手机机头 的方向
        // 设置定位参数
        mLocationClient.setLocOption(option);
        // 启动定位
        mLocationClient.start();

    }


    private void initList() {
        for (int i=0;i<10;i++) {
            ItemQiandao messi = new ItemQiandao("03-111", "高数", "胡明",latitude,longitude);
            mList.add(messi);
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        // 取消监听函数
        if (mLocationClient != null) {
            mLocationClient.unRegisterLocationListener(mBDLocationListener);
        }
    }


private class MyBDLocationListener extends BDAbstractLocationListener {

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            // 非空判断
            if (bdLocation != null) {
                // 根据BDLocation 对象获得经纬度以及详细地址信息
                 latitude = bdLocation.getLatitude();
                 longitude = bdLocation.getLongitude();
                //String address = bdLocation.getAddrStr();
                Log.i(TAG,  " latitude:" + latitude
                        + " longitude:" + longitude + "—");
                //Toast.makeText(getContext(), " 经度:" + latitude
                //       + " 纬度:" + longitude + "—", Toast.LENGTH_SHORT).show();
                if (mLocationClient.isStarted()) {
                    // 获得位置之后停止定位
                    mLocationClient.stop();
                }
            }
        }


}




}
