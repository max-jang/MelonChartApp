package com.hynixlabs.melonchart.holder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hynixlabs.melonchart.R;

public class ItemHolder extends RecyclerView.ViewHolder {
    public CardView cardView;
    public TextView txt_title;
    public TextView txt_artist;
    public TextView txt_album;
    public TextView txt_rank;
    public ImageView img_album;
    public TextView txt_rankUpDown;


    public ItemHolder(View root) {
        super(root);
        cardView = root.findViewById(R.id.cardView);
        txt_title = root.findViewById(R.id.txt_title);
        txt_artist = root.findViewById(R.id.txt_artist);
        txt_album = root.findViewById(R.id.txt_album);
        txt_rank = root.findViewById(R.id.txt_rank);
        img_album = root.findViewById(R.id.img_album);
        txt_rankUpDown = root.findViewById(R.id.txt_rankUpDown);
    }
}