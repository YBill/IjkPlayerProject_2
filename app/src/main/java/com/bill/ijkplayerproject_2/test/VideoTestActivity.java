package com.bill.ijkplayerproject_2.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.bill.ijkplayerproject_2.R;
import com.bill.ijkplayerproject_2.ijk.widget.media.AndroidMediaController;
import com.bill.ijkplayerproject_2.ijk.widget.media.IjkVideoView;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class VideoTestActivity extends AppCompatActivity {

    private boolean mBackPressed;
    private IjkVideoView mVideoView;
    private AndroidMediaController mMediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_test);
        mVideoView = findViewById(R.id.ijk_video_view);
        mMediaController = new AndroidMediaController(this, true);
        mVideoView.setMediaController(mMediaController);
        mMediaController.setPrevNextListeners(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(VideoTestActivity.this, "下一个", Toast.LENGTH_SHORT).show();
            }
        }, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(VideoTestActivity.this, "上一个", Toast.LENGTH_SHORT).show();
            }
        });

        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        mVideoView.setVideoPath("https://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f30.mp4");
//        mVideoView.setVideoPath("https://imedia-peoplesdaily.pdnews.cn/up/cms/www/201811/061606450mgl.mp4");
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
