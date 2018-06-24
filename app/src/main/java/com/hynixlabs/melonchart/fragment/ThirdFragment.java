package com.hynixlabs.melonchart.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hynixlabs.melonchart.R;

public class ThirdFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        return view;
    }

    public ThirdFragment newInstance() {
        ThirdFragment firstFragment = new ThirdFragment();
        Bundle args = new Bundle();
        firstFragment.setArguments(args);
        return firstFragment;
    }

}
