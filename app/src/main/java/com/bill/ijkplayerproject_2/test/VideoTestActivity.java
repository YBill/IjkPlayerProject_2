package com.bill.ijkplayerproject_2.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bill.ijkplayerproject_2.R;
import com.bill.ijkplayerproject_2.ijk.widget.media.IjkVideoView;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class VideoTestActivity extends AppCompatActivity {

    private boolean mBackPressed;
    private IjkVideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_test);
        mVideoView = findViewById(R.id.ijk_video_view);

        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        mVideoView.setVideoPath("https://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f30.mp4");
        mVideoView.start();
    }

    @Override
    public void onBackPressed() {
        mBackPressed = true;
        super.onBackPressed();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mBackPressed || !mVideoView.isBackgroundPlayEnabled()) {
            mVideoView.stopPlayback();
            mVideoView.release(true);
            mVideoView.stopBackgroundPlay();
        } else {
            mVideoView.enterBackground();
        }
        IjkMediaPlayer.native_profileEnd();
    }

}
