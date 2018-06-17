package com.hynixlabs.melonchart.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hynixlabs.melonchart.R;
import com.hynixlabs.melonchart.adapter.RecyclerAdapter;
import com.hynixlabs.melonchart.service.RequestInterface;
import com.hynixlabs.melonchart.vo.MusicItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FirstFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private MusicItem musicItem;
    private SwipeRefreshLayout layout;
    private Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        context = getActivity();
        //RecyclerView 설정
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        //가로, 세로 레이아웃매니저 설정
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getMusicList();

        layout = view.findViewById(R.id.swipe_layout);
        layout.setOnRefreshListener(this);
        return view;
    }

    private void getMusicList() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://202.182.103.65:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        System.out.println(retrofit + " is Running");

        final RequestInterface request = retrofit.create(RequestInterface.class);
        Call<MusicItem> call = request.getJSON();
        // Set up progress before call
        // show it
        call.enqueue(new Callback<MusicItem>() {
            @Override
            public void onResponse(Call<MusicItem> call, Response<MusicItem> response) {
                if (response.isSuccessful()) {
                    System.out.println(response + " into Response");
                    // 데이터를 받아서 RecyclerAdapter에 설정
                    musicItem = response.body();
                    if (!musicItem.getData().isEmpty()) {
                        adapter = new RecyclerAdapter(musicItem, context);
                        recyclerView.setAdapter(adapter);
                        layout.setRefreshing(false);
                    }
                }
            }

            @Override
            public void onFailure(Call<MusicItem> call, Throwable t) {
                Log.d("Error", t.getMessage());
                layout.setRefreshing(false);
            }
        });

        System.out.println("getMusicList()");

    }

    @Override
    public void onRefresh() {
        getMusicList();
    }


    public FirstFragment newInstance() {
        FirstFragment firstFragment = new FirstFragment();
        Bundle args = new Bundle();
        firstFragment.setArguments(args);
        return firstFragment;
    }

}
