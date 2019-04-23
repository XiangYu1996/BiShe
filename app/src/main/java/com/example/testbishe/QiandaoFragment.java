package com.example.testbishe;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class QiandaoFragment extends Fragment {
    List<ItemQiandao> mList = new ArrayList<>();
    RecyclerView mRecyclerView;
    ItemQiandaoAdapter mItemQiandaoAdapter;

    public QiandaoFragment(){
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.qiandao_fragment, container, false);


        mRecyclerView = view.findViewById(R.id.qiandao_recyclerView);
        mItemQiandaoAdapter = new ItemQiandaoAdapter(mList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(new RecycleViewDivider(this.getContext(), LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mItemQiandaoAdapter);

        initList();

        return view;
    }

    private void initList() {
        for (int i=0;i<3;i++) {
            ItemQiandao messi = new ItemQiandao("03-111", "高数", "胡明");
            mList.add(messi);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }



}
