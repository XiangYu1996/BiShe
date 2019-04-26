package com.example.testbishe;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
        mWode_my.setOnClickListener(this);
        mWode_change_my.setOnClickListener(this);
        mWode_change_pass.setOnClickListener(this);
        mWode_zhuxiao.setOnClickListener(this);
        mWode_exit.setOnClickListener(this);


    }


    public void showdialog(View view)
    {
     //Toast.makeText(this,"clickme",Toast.LENGTH_LONG).show();
     AlertDialog.Builder alertdialogbuilder=new AlertDialog.Builder(view.getContext());
     alertdialogbuilder.setMessage("您确认要退出程序");
     alertdialogbuilder.setPositiveButton("确定", click1);
     alertdialogbuilder.setNegativeButton("取消", click2);
     AlertDialog alertdialog1=alertdialogbuilder.create();
     alertdialog1.show();
     }
    public void showdialog2(View view)
    {
        //Toast.makeText(this,"clickme",Toast.LENGTH_LONG).show();
        AlertDialog.Builder alertdialogbuilder=new AlertDialog.Builder(view.getContext());
        alertdialogbuilder.setMessage("您确认要注销登录");
        alertdialogbuilder.setPositiveButton("确定", click1);
        alertdialogbuilder.setNegativeButton("取消", click2);
        AlertDialog alertdialog1=alertdialogbuilder.create();
        alertdialog1.show();
    }

    private DialogInterface.OnClickListener click1=new DialogInterface.OnClickListener()
    {
        @Override
        public void onClick(DialogInterface arg0,int arg1)
        {
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    };
    private DialogInterface.OnClickListener click2=new DialogInterface.OnClickListener()
    {@Override

    public void onClick(DialogInterface arg0,int arg1)
    {
        arg0.cancel();
    }
    };



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.wode_my:

                Intent intwodemy = new Intent(getContext(),WodeMyAcitvity.class);
                startActivity(intwodemy);
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
                showdialog2(view);
                //Toast.makeText(getContext(), "注销", Toast.LENGTH_SHORT).show();

                break;
            case R.id.wode_exit:

                showdialog(view);

                break;

        }
    }
}
