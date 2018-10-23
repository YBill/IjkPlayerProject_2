package com.bill.ijkplayerproject_2.ijk.setting;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Bill on 2018/10/23.
 * 视频比例参数
 */

@IntDef({
        ScaleType.AR_ASPECT_FIT_PARENT,
        ScaleType.AR_ASPECT_FILL_PARENT,
        ScaleType.AR_ASPECT_WRAP_CONTENT,
        ScaleType.AR_MATCH_PARENT,
        ScaleType.AR_16_9_FIT_PARENT,
        ScaleType.AR_4_3_FIT_PARENT
})
@Retention(RetentionPolicy.SOURCE)
public @interface ScaleType {
    int AR_ASPECT_FIT_PARENT = 0; // without clip
    int AR_ASPECT_FILL_PARENT = 1; // may clip
    int AR_ASPECT_WRAP_CONTENT = 2;
    int AR_MATCH_PARENT = 3;
    int AR_16_9_FIT_PARENT = 4;
    int AR_4_3_FIT_PARENT = 5;

}