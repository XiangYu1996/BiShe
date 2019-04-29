package com.example.testbishe;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class QiandaoFragmentTeacher extends Fragment {


    private Button qiandao_new;
    private RelativeLayout qiandao_fragment_main;

    public QiandaoFragmentTeacher() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.qiandao_teacher_fragment, container, false);

        qiandao_new = (Button) view.findViewById(R.id.qiandao_teacher_new);
        qiandao_fragment_main = (RelativeLayout) view.findViewById(R.id.qiandao_fragment_main);

        qiandao_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qiandao_new.setVisibility(View.GONE);
                qiandao_fragment_main.setVisibility(View.VISIBLE);


            }
        });

        return view;
    }
}
