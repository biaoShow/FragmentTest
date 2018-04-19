package com.example.biao.fragmenttest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;


public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Mes> list;
    private LayoutInflater mLayout;
    private OnClickItemListener onClickItemListener;

    public RecyclerviewAdapter(Context context, List<Mes> list) {
        this.context = context;
        this.list = list;
        this.mLayout = LayoutInflater.from(context);
    }

    public void setOnClickItemListener(OnClickItemListener onClickItemListener){
        this.onClickItemListener = onClickItemListener;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayout.inflate(R.layout.recyclerview_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        ((MyViewHolder) holder).tv_mestitle.setText(list.get(position).getTitle());
        ((MyViewHolder) holder).rl_recyclerview_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemListener.onClickItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_mestitle;
        RelativeLayout rl_recyclerview_item;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_mestitle = itemView.findViewById(R.id.tv_mestitle);
            rl_recyclerview_item = itemView.findViewById(R.id.rl_recyclerview_item);
        }
    }

}
