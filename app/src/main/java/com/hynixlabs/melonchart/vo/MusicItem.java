package com.hynixlabs.melonchart.vo;

import java.util.List;

/**
 * Melon API: http://hynixlabs.com:8080/
 * Thanks to https://www.npmjs.com/package/melon-chart-api
 * data : [{"rank":"1","title":"뚜두뚜두 (DDU-DU DDU-DU)","artist":"BLACKPINK","album":"SQUARE UP"}
 */

public class MusicItem {
    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * rank : 1
         * title : 뚜두뚜두 (DDU-DU DDU-DU)
         * artist : BLACKPINK
         * album : SQUARE UP
         */
        private String rank;
        private String title;
        private String artist;
        private String album;
        private String albumArts;


        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getArtist() {
            return artist;
        }

        public void setArtist(String artist) {
            this.artist = artist;
        }

        public String getAlbum() {
            return album;
        }

        public void setAlbum(String album) {
            this.album = album;
        }

        public String getAlbumArts() {
            return albumArts;
        }

        public void setAlbumArts(String albumArts) {
            this.albumArts = albumArts;
        }
    }

}
