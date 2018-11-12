package com.bill.ijkplayerproject_2.manager;

import com.bill.ijkplayerproject_2.MyApplication;
import com.bill.ijkplayerproject_2.ijk.widget.media.IjkVideoView;

public class VideoViewManager {

    private static class SingletonHolder {
        private final static VideoViewManager instance = new VideoViewManager();
    }

    public static VideoViewManager getInstance() {
        return SingletonHolder.instance;
    }

    private IjkVideoView ijkVideoView;

    private VideoViewManager() {
        ijkVideoView = new IjkVideoView(MyApplication.getApplication());
    }

    public IjkVideoView getVideoView() {
        return ijkVideoView;
    }

    public void play(String url) {
        ijkVideoView.setVideoPath(url);
        ijkVideoView.start();
    }

    public void pause() {
        ijkVideoView.pause();
    }

    public void stop() {
        ijkVideoView.stopPlayback();
        ijkVideoView.release(true);
    }

}
