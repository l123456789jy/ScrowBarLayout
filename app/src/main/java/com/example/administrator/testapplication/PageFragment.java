package com.example.administrator.testapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cpoopc.scrollablelayoutlib.ScrollableHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 作者：Administrator on 2016/5/10 15:27
 * 邮箱：906514731@qq.com
 * 这个是显示详情界面你的fragment必须要实现这个接口
 */
public class PageFragment extends ScrollAbleFragment implements ScrollableHelper.ScrollableContainer {

    private RecyclerView mRecyclerView;

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        List<String> strlist = new ArrayList<String>();
        for (int i = 0; i < new Random().nextInt(100) + 31; i++) {
            strlist.add(String.valueOf(i));
        }
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(new RecyclerAdapter(getActivity(), strlist));
        return view;
    }






    //必须要返回当前滑动的view
    @Override public View getScrollableView() {
        return mRecyclerView;
    }
}