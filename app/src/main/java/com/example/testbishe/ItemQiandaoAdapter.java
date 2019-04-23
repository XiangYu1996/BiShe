package com.example.testbishe;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

import java.util.List;

public class ItemQiandaoAdapter extends RecyclerView.Adapter<ItemQiandaoAdapter.ViewHolder> {

    private List<ItemQiandao> mItemQiandaos;


    private LocationClient mLocationClient = null;
    private BDAbstractLocationListener mBDLocationListener;
    private double latitude;
    private double longitude;



    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView item_address;
        TextView item_classname;
        TextView item_teacher;
        Button item_qiandao_img;

        public ViewHolder(View itemView) {
            super(itemView);
            View itemQiandao = itemView;
            item_address = (TextView) itemQiandao.findViewById(R.id.item_qiandao_address);
            item_classname = (TextView) itemQiandao.findViewById(R.id.item_qiandao_class);
            item_teacher = (TextView) itemQiandao.findViewById(R.id.item_qiandao_teacher);
            item_qiandao_img = (Button) itemQiandao.findViewById(R.id.item_qiandao_img);
        }
    }
    public ItemQiandaoAdapter(List<ItemQiandao> ItemQiandao){
        mItemQiandaos = ItemQiandao;
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

    @NonNull
    @Override
    public ItemQiandaoAdapter.ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_qiandao,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);

        // 声明LocationClient类
        mLocationClient = new LocationClient(view.getContext());
        mBDLocationListener = new ItemQiandaoAdapter.MyBDLocationListener();
        // 注册监听
        //mLocationClient.registerLocationListener(mBDLocationListener);
        //获取地址


        //为签到按钮设置点击事件
        viewHolder.item_qiandao_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();


//
//                // 声明LocationClient类
//                mLocationClient = new LocationClient(v.getContext());
//                mBDLocationListener = new ItemQiandaoAdapter.MyBDLocationListener();
//                // 注册监听
                mLocationClient.registerLocationListener(mBDLocationListener);
//                //获取地址

                getLocation();


                if (latitude != 0) {
                    Toast.makeText(v.getContext(),mItemQiandaos.get(position).getAddress()+"  "
                            +mItemQiandaos.get(position).getClassname()+"   "
                            +mItemQiandaos.get(position).getTeachername()
                            +"  经度"+latitude
                            +"纬度"+longitude, Toast.LENGTH_SHORT).show();


                    //使用后要注销监听，否则出错---经度:4.9E-324 纬度:4.9E-324
                    mLocationClient.unRegisterLocationListener(mBDLocationListener);

                }else {
                    Toast.makeText(v.getContext(), "GPS正在定位", Toast.LENGTH_SHORT).show();

                }

            }

        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemQiandaoAdapter.ViewHolder holder, int position) {
        ItemQiandao itemQiandao = mItemQiandaos.get(position);
        holder.item_address.setText(itemQiandao.getAddress());
        holder.item_classname.setText(itemQiandao.getClassname());
        holder.item_teacher.setText(itemQiandao.getTeachername());



    }

    @Override
    public int getItemCount() {
        return mItemQiandaos.size();
    }

    private class MyBDLocationListener extends BDAbstractLocationListener {

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            // 非空判断
            if (bdLocation != null) {
                // 根据BDLocation 对象获得经纬度以及详细地址信息
                latitude = bdLocation.getLatitude();
                longitude = bdLocation.getLongitude();
                String address = bdLocation.getAddrStr();
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
}
