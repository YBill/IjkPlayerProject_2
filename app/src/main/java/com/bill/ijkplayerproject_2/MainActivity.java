package com.bill.ijkplayerproject_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bill.ijkplayerproject_2.util.PageJumpUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleAudioTest(View view) {
        PageJumpUtil.gotoAudioTestActivity(this);
    }

    public void handleVideoTest(View view) {
        PageJumpUtil.gotoVideoSettingActivity(this);
    }

    public void handleVideoList(View view) {
        PageJumpUtil.gotoVideoListActivity(this);
    }
}
