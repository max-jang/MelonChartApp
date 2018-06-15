package com.hynixlabs.melonchart.vo;

import java.util.List;

public class MusicItem {

    /**
     * Melon API: http://hynixlabs.com:8080/
     * Thanks to https://www.npmjs.com/package/melon-chart-api
     * data : [{"rank":"1","title":"뚜두뚜두 (DDU-DU DDU-DU)","artist":"BLACKPINK","album":"SQUARE UP"},
     * dates : {"start":"2018061511","end":"2018061511"}
     */

    private DatesBean dates;
    private List<DataBean> data;

    public DatesBean getDates() {
        return dates;
    }

    public void setDates(DatesBean dates) {
        this.dates = dates;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DatesBean {
        /**
         * start : 2018061511
         * end : 2018061511
         */

        private String start;
        private String end;

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }
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
    }
}
