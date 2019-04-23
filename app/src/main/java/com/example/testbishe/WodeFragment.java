package com.example.testbishe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class WodeFragment extends Fragment implements View.OnClickListener {

    private TextView mUserName;
    private TextView mWode_my;
    private TextView mWode_change_my;
    private TextView mWode_change_pass;
    private TextView mWode_zhuxiao;
    private TextView mWode_exit;

    public WodeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.wode_fragment, container, false);

        initViews(view);








        return view;
    }

    private void initViews(View view) {
        mUserName = (TextView) view.findViewById(R.id.wode_user_name);
        mWode_my = (TextView) view.findViewById(R.id.wode_my);
        mWode_change_my = (TextView) view.findViewById(R.id.wode_change_my);
        mWode_change_pass = (TextView) view.findViewById(R.id.wode_change_pass);
        mWode_zhuxiao = (TextView) view.findViewById(R.id.wode_zhuxiao);
        mWode_exit = (TextView) view.findViewById(R.id.wode_exit);

        mUserName.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.wode_my:

                Intent wode_my = new Intent(getContext(),WodeMyAcitvity.class);
                startActivity(wode_my);
                break;
            case R.id.wode_change_my:
                Intent wode_change_my = new Intent(getContext(),WodeChangeMyAcitvity.class);
                startActivity(wode_change_my);
                break;
            case R.id.wode_change_pass:
                Intent intent = new Intent(getContext(),WodeChangePasswordAcitvity.class);
                startActivity(intent);

                break;
            case R.id.wode_zhuxiao:
                Toast.makeText(getContext(), "注销", Toast.LENGTH_SHORT).show();

                break;
            case R.id.wode_exit:
                Toast.makeText(getContext(), "退出", Toast.LENGTH_SHORT).show();

                break;

        }
    }
}
