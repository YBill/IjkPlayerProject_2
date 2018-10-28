package com.bill.ijkplayerproject_2.util;

import android.app.Activity;
import android.content.Intent;

import com.bill.ijkplayerproject_2.test.AudioTestActivity;
import com.bill.ijkplayerproject_2.test.VideoSettingActivity;
import com.bill.ijkplayerproject_2.test.VideoTestActivity;

public class PageJumpUtil {

    public static void gotoAudioTestActivity(Activity activity) {
        Intent intent = new Intent(activity, AudioTestActivity.class);
        activity.startActivity(intent);
    }

    public static void gotoVideoTestActivity(Activity activity) {
        Intent intent = new Intent(activity, VideoTestActivity.class);
        activity.startActivity(intent);
    }

    public static void gotoVideoSettingActivity(Activity activity) {
        Intent intent = new Intent(activity, VideoSettingActivity.class);
        activity.startActivity(intent);
    }

}
