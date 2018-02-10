package com.example.zhengbotao.aacpractice.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhengbotao.aacpractice.R;
import com.example.zhengbotao.aacpractice.ui.adapter.GirlAdapter;

/**
 * Created by zhengbotao on 18-2-8.
 */

public class GirlFragment extends Fragment {

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private GirlAdapter girlAdapter;


    public GirlFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_girl,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        girlAdapter = new GirlAdapter();
        recyclerView = view.findViewById(R.id.fragment_girl_rcv);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(girlAdapter);

        swipeRefreshLayout = view.findViewById(R.id.fragment_girl_srl);

        /**
         *
         */
        swipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        /**
         *  下拉刷新
         *  setRefreshing():设置开始刷新、结束刷新
         *  isRefreshing():是否正在刷新中
         *  setEnabled():取消刷新
         *  setColorSchemeResources():刷新图标的颜色，有多个颜色就每一圈换一色，循环
         */
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//                girlAdapter.clearGirlData();
//                swipeRefreshLayout.setRefreshing(true);

            }
        });

        /**
         *  上拉加载
         */
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });

    }


}
