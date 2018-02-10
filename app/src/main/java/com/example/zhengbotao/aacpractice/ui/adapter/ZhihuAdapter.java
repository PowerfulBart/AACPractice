package com.example.zhengbotao.aacpractice.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhengbotao.aacpractice.R;
import com.example.zhengbotao.aacpractice.data.Girl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengbotao on 18-2-8.
 */

public class ZhihuAdapter extends RecyclerView.Adapter<ZhihuAdapter.ViewHolder> {

    private List<Girl> list;

    public ZhihuAdapter() {
        initData();
    }

    // temporary data
    private void initData() {

        list = new ArrayList<>();

        for(int i = 0; i < 20 ; i++){
            list.add(new Girl(R.drawable.ic_favorite,"美女" + i,"2018-02-10 -> " + i));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_zhihu_rcv_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Girl girl = list.get(position);
        holder.getZhihulIm().setImageResource(girl.getResId());
        holder.getZhihuTitleTv().setText(girl.getTitle());
        holder.getZhihuSubtitleTv().setText(girl.getSubTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView ZhihulIm;
        private TextView ZhihuTitleTv;
        private TextView ZhihuSubtitleTv;

        public ViewHolder(View itemView) {
            super(itemView);

            ZhihulIm = itemView.findViewById(R.id.rcv_zhihu_item_im);
            ZhihuTitleTv = itemView.findViewById(R.id.rcv_zhihu_item_title_tv);
            ZhihuSubtitleTv = itemView.findViewById(R.id.rcv_zhihu_item_subtitle_tv);
        }

        private ImageView getZhihulIm(){
            return ZhihulIm;
        }

        private TextView getZhihuTitleTv(){
            return ZhihuTitleTv;
        }
        private TextView getZhihuSubtitleTv(){
            return ZhihuSubtitleTv;
        }
    }
}
