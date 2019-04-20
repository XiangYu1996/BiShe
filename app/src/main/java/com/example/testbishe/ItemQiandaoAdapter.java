package com.example.testbishe;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ItemQiandaoAdapter extends RecyclerView.Adapter<ItemQiandaoAdapter.ViewHolder> {

    private List<ItemQiandao> mItemQiandaos;



    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView item_address;
        TextView item_classname;
        TextView item_teacher;
        Button item_qiandao_img;

        public ViewHolder(View itemView) {
            super(itemView);
            View itemQiandao = itemView;
            item_address = (TextView) itemView.findViewById(R.id.item_qiandao_address);
            item_classname = (TextView) itemView.findViewById(R.id.item_qiandao_class);
            item_teacher = (TextView) itemView.findViewById(R.id.item_qiandao_teacher);
            item_qiandao_img = (Button) itemView.findViewById(R.id.item_qiandao_img);
        }
    }
    public ItemQiandaoAdapter(List<ItemQiandao> ItemQiandao){
        mItemQiandaos = ItemQiandao;
    }



    @NonNull
    @Override
    public ItemQiandaoAdapter.ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_qiandao,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);

        //为签到按钮设置点击事件
        viewHolder.item_qiandao_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Toast.makeText(v.getContext(),mItemQiandaos.get(position).getAddress()+"  "
                        +mItemQiandaos.get(position).getClassname()+"   "
                        +mItemQiandaos.get(position).getTeachername(), Toast.LENGTH_SHORT).show();
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


}
