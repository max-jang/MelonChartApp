package com.hynixlabs.melonchart.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hynixlabs.melonchart.R;
import com.hynixlabs.melonchart.holder.ItemHolder;
import com.hynixlabs.melonchart.vo.MusicItem;

public class RecyclerAdapter extends RecyclerView.Adapter<ItemHolder> {

    private MusicItem vo;
    private Context context;
    private CardView cardView;
    private TextView txt_title;
    private TextView txt_artist;
    private TextView txt_album;
    private TextView txt_rank;
    private ImageView img_album;

    public RecyclerAdapter(MusicItem vo, Context context) {
        this.vo = vo;
        this.context = context;
    }

    @NonNull
    @Override // 새로운 뷰 홀더 생성
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item, parent,
                false);
        return new ItemHolder(view); //Holder로 View 넘김
    }

    // View 의 내용을 해당 포지션의 데이터로 바꿈(바인딩)
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        cardView = holder.cardView;
        txt_title = holder.txt_title;
        txt_artist = holder.txt_artist;
        txt_album = holder.txt_album;
        txt_rank = holder.txt_rank;
        img_album = holder.img_album;

        txt_title.setText(vo.getData().get(position).getTitle());
        txt_artist.setText(vo.getData().get(position).getArtist());
        txt_album.setText(vo.getData().get(position).getAlbum());
        txt_rank.setText(vo.getData().get(position).getRank());

        if (!vo.getData().get(position).getAlbumArts().isEmpty()) {
            Glide.with(context)
                    .load(vo.getData().get(position).getAlbumArts())
                    .into(img_album);
        }
    }

    @Override
    public int getItemCount() {
        return vo.getData().size();
    }


}


