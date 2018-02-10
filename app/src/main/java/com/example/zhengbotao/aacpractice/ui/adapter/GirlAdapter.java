package com.example.zhengbotao.aacpractice.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhengbotao.aacpractice.R;
import com.example.zhengbotao.aacpractice.data.Girl;
import com.example.zhengbotao.aacpractice.ui.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengbotao on 18-2-8.
 */

public class GirlAdapter extends RecyclerView.Adapter<GirlAdapter.ViewHolder>{

    private List<Girl> list;

    public GirlAdapter() {
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
                .inflate(R.layout.fragment_girl_rcv_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Girl girl = list.get(position);
        holder.getGirlIm().setImageResource(girl.getResId());
        holder.getGirlTitleTv().setText(girl.getTitle());
        holder.getGirlSubtitleTv().setText(girl.getSubTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView girlIm;
        private TextView girlTitleTv;
        private TextView girlSubtitleTv;

        public ViewHolder(View itemView) {
            super(itemView);

            girlIm = itemView.findViewById(R.id.rcv_girl_item_im);
            girlTitleTv = itemView.findViewById(R.id.rcv_girl_item_title_tv);
            girlSubtitleTv = itemView.findViewById(R.id.rcv_girl_item_subtitle_tv);
        }

        private ImageView getGirlIm(){
            return girlIm;
        }

        private TextView getGirlTitleTv(){
            return girlTitleTv;
        }
        private TextView getGirlSubtitleTv(){
            return girlSubtitleTv;
        }

    }


//    public void setGirlData(){
//
//    }

    public void clearGirlData(){
        list.clear();
        notifyDataSetChanged();
    }

}
