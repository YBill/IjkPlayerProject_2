package com.bill.ijkplayerproject_2.test;

import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bill.ijkplayerproject_2.R;

import java.io.IOException;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class AudioTestActivity extends AppCompatActivity {

    private IjkMediaPlayer ijkMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_test);
    }

    public void handlePlayAudio(View view) {
        createPlayer();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        release();
    }

    private void createPlayer() {
        ijkMediaPlayer = new IjkMediaPlayer();
        ijkMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            ijkMediaPlayer.setDataSource("https://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f30.mp4");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ijkMediaPlayer.prepareAsync();
        ijkMediaPlayer.setOnCompletionListener(new IMediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(IMediaPlayer mp) {
                release();
            }
        });
    }

    private void release() {
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.stop();
            ijkMediaPlayer.release();
            ijkMediaPlayer = null;
        }
    }

}
