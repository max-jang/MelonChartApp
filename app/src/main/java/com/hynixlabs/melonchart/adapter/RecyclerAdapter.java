package com.hynixlabs.melonchart.adapter;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hynixlabs.melonchart.R;
import com.hynixlabs.melonchart.holder.ItemHolder;
import com.hynixlabs.melonchart.vo.MusicItem;

public class RecyclerAdapter extends RecyclerView.Adapter<ItemHolder> {

    private MusicItem vo;
    private Context context;
    private TextView txt_title;
    private TextView txt_artist;
    private TextView txt_album;
    private TextView txt_rank;
    private ImageView img_album;
    private TextView txt_rankUpDown;
    private CardView cardView;

    private String upDown;


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
    @SuppressLint("SetTextI18n")
    public void onBindViewHolder(@NonNull ItemHolder holder, final int position) {
        txt_title = holder.txt_title;
        txt_artist = holder.txt_artist;
        txt_album = holder.txt_album;
        txt_rank = holder.txt_rank;
        img_album = holder.img_album;
        txt_rankUpDown = holder.txt_rankUpDown;
        cardView = holder.cardView;

        txt_title.setText(vo.getData().get(position).getTitle());
        txt_artist.setText(vo.getData().get(position).getArtist());
        txt_album.setText(vo.getData().get(position).getAlbum());
        txt_rank.setText(vo.getData().get(position).getRank());
        upDown = vo.getData().get(position).getRank_wrap();

        //순위 상승,하락 설정(하락, 동일, 상승마다 색, 변동률이 다르므로 설정)
        if (upDown.equals("순위 동일")) {
            txt_rankUpDown.setText("-");
            txt_rankUpDown.setTextColor(Color.parseColor("#d2d2d2"));
        } else if (upDown.substring(upDown.length() - 2, upDown.length()).equals("하락")) {
            txt_rankUpDown.setText("- " + upDown.substring(0, 1));
            txt_rankUpDown.setTextColor(Color.parseColor("#8cbefa"));
        } else if (upDown.substring(upDown.length() - 2, upDown.length()).equals("상승")) {
            txt_rankUpDown.setText("+ " + upDown.substring(0, 1));
            txt_rankUpDown.setTextColor(Color.parseColor("#f0780c"));
        }

        // Glide로 이미지 가져오기
        if (!vo.getData().get(position).getAlbumArts().isEmpty()) {
            Glide.with(context)
                    .load(vo.getData().get(position).getAlbumArts())
                    .into(img_album);
        }

        cardView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.webview);
                WebView wb = dialog.findViewById(R.id.webView);
                wb.getSettings().setJavaScriptEnabled(true);
                wb.setWebViewClient(new MyWebViewClient());
                wb.loadUrl("http://m.app.melon.com/album/music.htm?albumId=" + vo.getData().get(position).getAlbumNum());
                System.out.println("http://m.app.melon.com/album/music.htm?albumId=" + vo.getData().get(position).getAlbumNum());
                dialog.setCancelable(true);
                dialog.setTitle("WebView");
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.MATCH_PARENT;
                dialog.show();
                Window window = dialog.getWindow();
                window.setAttributes(lp);

            }
        });
    }

    @Override
    public int getItemCount() {
        return vo.getData().size();
    }


    private class MyWebViewClient extends WebViewClient {

        @Override
        //show the web page in webview but not in web browser
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}

