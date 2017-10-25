package Fragmens;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import Bean.MynewRibao;
import Myadater.MyNewRibaoadater;
import Utils.Icalls;
import Utils.Okhttp;
import okhttp3.Request;
import test.bwie.com.myruanjian1.R;

public class Zuixinribao extends Fragment {

    private RecyclerView mRecy;
    private View v;
    private LinearLayoutManager linearLayoutManager;
    private List<MynewRibao.StoriesBean> list = new ArrayList<>();
    private List<MynewRibao.TopStoriesBean> top = new ArrayList<>();
    String urls = "http://news-at.zhihu.com/api/4/news/latest";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_zuixinribao, container, false);

        initview();
        
        InitData();
        return v;
    }

    private void InitData() {
        Okhttp.getOkhttps().GetDatas(urls, new Icalls() {
            @Override
            public void Success(final Object o) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                      MynewRibao  mynewRibao = new Gson().fromJson(o.toString(), MynewRibao.class);

                        list.addAll(mynewRibao.getStories());
                        top.addAll(mynewRibao.getTop_stories());

                        MyNewRibaoadater myNewRibaoadater = new MyNewRibaoadater(getActivity(),list,top);
                        mRecy.setAdapter(myNewRibaoadater);
                    }
                });
            }

            @Override
            public void Error(Exception e, Request request) {

            }
        });
    }

    private void initview() {

        mRecy  = v.findViewById(R.id.newribao);

        linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecy.setLayoutManager(linearLayoutManager);

    }

}
