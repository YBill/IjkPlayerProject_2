package com.bill.ijkplayerproject_2.ijk.setting;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Bill on 2018/10/23.
 * 渲染器类型
 */

@IntDef({
        RenderType.RENDER_NONE,
        RenderType.RENDER_SURFACE_VIEW,
        RenderType.RENDER_TEXTURE_VIEW,
        RenderType.RENDER_NONE_VIEW
})
@Retention(RetentionPolicy.SOURCE)
public @interface RenderType {
    int RENDER_NONE = 0;
    int RENDER_SURFACE_VIEW = 1;
    int RENDER_TEXTURE_VIEW = 2;
    int RENDER_NONE_VIEW = 3;
}