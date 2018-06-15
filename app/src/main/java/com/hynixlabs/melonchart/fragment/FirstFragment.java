package com.hynixlabs.melonchart.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hynixlabs.melonchart.R;
import com.hynixlabs.melonchart.adapter.RecyclerAdapter;

public class FirstFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;

    public FirstFragment() {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        return view;
    }

    public FirstFragment newInstance() {
        FirstFragment firstFragment = new FirstFragment();
        Bundle args = new Bundle();
        firstFragment.setArguments(args);
        return firstFragment;
    }

}
