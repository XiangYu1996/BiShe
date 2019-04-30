package com.example.testbishe;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testbishe.QianDao.ItemQiandao;
import com.example.testbishe.QianDao.ItemQiandaoAdapter;
import com.example.testbishe.QianDao.RecycleViewDivider;

import java.util.ArrayList;
import java.util.List;

public class QiandaoFragment extends Fragment {
    List<ItemQiandao> mList = new ArrayList<>();
    RecyclerView mRecyclerView;
    ItemQiandaoAdapter mItemQiandaoAdapter;
    TextView qiandao_recycle_null;

    public QiandaoFragment(){
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.qiandao_fragment, container, false);
        qiandao_recycle_null = (TextView)view.findViewById(R.id.qiandao_recycler_null);
if (mList==null){
    mRecyclerView.setVisibility(View.GONE);
    qiandao_recycle_null.setVisibility(View.VISIBLE);


}else {
    mRecyclerView = view.findViewById(R.id.qiandao_recyclerView);
    mItemQiandaoAdapter = new ItemQiandaoAdapter(mList);
    LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    mRecyclerView.setLayoutManager(layoutManager);
    mRecyclerView.addItemDecoration(new RecycleViewDivider(this.getContext(), LinearLayoutManager.VERTICAL));
    mRecyclerView.setAdapter(mItemQiandaoAdapter);
    mRecyclerView.setVisibility(View.VISIBLE);
    qiandao_recycle_null.setVisibility(View.GONE);
}
        initList();
        return view;
    }

    private void initList() {
        for (int i=0;i<3;i++) {
            ItemQiandao messi = new ItemQiandao("03-111", "高数", "胡明");
            mList.add(messi);
        }
        mList.add(new ItemQiandao("0000022", "数据结构", "胡鸣"));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }



}
