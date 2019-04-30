package com.example.testbishe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;


public class TeacherNewQiaodao extends AppCompatActivity implements View.OnClickListener {


    private LocationClient mLocationClient;
    private BDAbstractLocationListener mBDLocationListener;
    private double latitude;
    private double longitude;
    private String address;


    private TextView show_jiangdu;
    private TextView show_weidu;
    private Button getgps;
    private Button teacher_new_cancel;
    private Button teacher_new_queren;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_new_qiandao);

        getgps = (Button) findViewById(R.id.get_gps);
        teacher_new_queren = (Button)findViewById(R.id.teacher_new_queren);
        teacher_new_cancel = (Button)findViewById(R.id.teacher_new_cancel);
        show_jiangdu = (TextView) findViewById(R.id.show_jingdu);
        show_weidu = (TextView) findViewById(R.id.show_weidu);

        // 声明LocationClient类
        mLocationClient = new LocationClient(getApplicationContext());
        mBDLocationListener = new MyBDLocationListener();

        // 注册监听
        mLocationClient.registerLocationListener(mBDLocationListener);
        //获取地址
        getLocation();

        getgps.setOnClickListener(this);
        teacher_new_queren .setOnClickListener(this);
        teacher_new_cancel.setOnClickListener(this);
    }


    /** 获得所在位置经纬度及详细地址 */
    public void getLocation(){
        // 声明定位参数  
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);// 设置定位模式 高精度  
        option.setCoorType("bd09ll");// 设置返回定位结果是百度经纬度 默认gcj02  
        option.setScanSpan(5000);// 设置发起定位请求的时间间隔 单位ms  
        option.setIsNeedAddress(true);// 设置定位结果包含地址信息  
        option.setNeedDeviceDirect(true);// 设置定位结果包含手机机头 的方向  
        // 设置定位参数  
        mLocationClient.setLocOption(option);
        // 启动定位  
        mLocationClient.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.get_gps:
                     if (latitude != 0) {
                         show_jiangdu.setText(String.valueOf(latitude));
                         show_weidu.setText(String.valueOf(longitude));
                         //使用后要注销监听，否则出错---经度:4.9E-324 纬度:4.9E-324
                         mLocationClient.unRegisterLocationListener(mBDLocationListener);
                     } else {
                         Toast.makeText(v.getContext(), "GPS正在定位", Toast.LENGTH_SHORT).show();
                     }
                break;
            case R.id.teacher_new_queren:

                break;
            case R.id.teacher_new_cancel:

                break;




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
                address = bdLocation.getAddrStr();
                //获取定位类型、定位错误返回码，具体信息可参照类参考中BDLocation类中的说明
                int errorCode = bdLocation.getLocType();
                Log.v("GPS",  " 经度:" + latitude
                        + " 纬度:" + longitude + "—"+"获取定位类型、定位错误返回码"+errorCode+" "+address);
                //Toast.makeText(getContext(), " 经度:" + latitude + " 纬度:" + longitude + "—", Toast.LENGTH_SHORT).show();
            }
            if (mLocationClient.isStarted()) {
                // 获得位置之后停止定位
                mLocationClient.stop();
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}