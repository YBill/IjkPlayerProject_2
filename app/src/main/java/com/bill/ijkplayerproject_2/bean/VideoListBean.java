package com.bill.ijkplayerproject_2.bean;

public class VideoListBean {

    public String id;
    public String title;
    public String name;
    public String imgUrl;
    public int commentNum;

    public int playStatus = 0; // 播放状态：1：播放 2：暂停

    public VideoListBean(String id, String title, String name, String imgUrl, int commentNum) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.imgUrl = imgUrl;
        this.commentNum = commentNum;
    }

    public VideoListBean() {
    }
}
