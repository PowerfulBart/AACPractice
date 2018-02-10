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
import com.example.zhengbotao.aacpractice.ui.adapter.ZhihuAdapter;

/**
 * Created by zhengbotao on 18-2-8.
 */

public class ZhihuFragment extends Fragment {

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private ZhihuAdapter zhihuAdapter;


    public ZhihuFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_zhihu,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        zhihuAdapter = new ZhihuAdapter();

        swipeRefreshLayout = view.findViewById(R.id.fragment_zhihu_srl);
        recyclerView = view.findViewById(R.id.fragment_zhihu_rcv);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(zhihuAdapter);

    }
}
