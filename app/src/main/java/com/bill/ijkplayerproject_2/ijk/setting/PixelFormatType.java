package com.bill.ijkplayerproject_2.ijk.setting;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Bill on 2018/10/23.
 * PixelFormat 参数
 */

@StringDef({
        PixelFormatType.RGB_565,
        PixelFormatType.RGB_888,
        PixelFormatType.RGBX_8888,
        PixelFormatType.YV12,
        PixelFormatType.OpenGL_ES2,
})
@Retention(RetentionPolicy.SOURCE)
public @interface PixelFormatType {
    String RGB_565 = "fcc-rv16";
    String RGB_888 = "fcc-rv24";
    String RGBX_8888 = "fcc-rv32";
    String YV12 = "fcc-yv12";
    String OpenGL_ES2 = "fcc-_es2";
}