package com.bill.ijkplayerproject_2.ijk.setting;

import android.content.Context;
import android.content.SharedPreferences;

import com.bill.ijkplayerproject_2.MyApplication;
import com.bill.ijkplayerproject_2.R;

import java.lang.reflect.Method;

/**
 * Created by Bill on 2018/10/23.
 * 视频参数设置
 */

public class PlayerConfig {

    private static class SingletonHolder {
        private static final PlayerConfig INSTANCE = new PlayerConfig();
    }

    public static final PlayerConfig getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static final String NAME = "player_config_preference";
    private Context mAppContext;
    private SharedPreferences mSharedPreferences;
    private SharedPreferencesCompat mCompat;

    private PlayerConfig() {
        mAppContext = MyApplication.getApplication();
        mSharedPreferences = mAppContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        mCompat = new SharedPreferencesCompat();
    }

    /**
     * 是否允许后台播放
     *
     * @return
     */
    public boolean getEnableBackgroundPlay() {
        String key = mAppContext.getString(R.string.pref_key_enable_background_play);
        return mSharedPreferences.getBoolean(key, false);
    }

    public void setEnableBackgroundPlay(boolean enable) {
        String key = mAppContext.getString(R.string.pref_key_enable_background_play);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key, enable);
        mCompat.apply(editor);
    }

    public @PlayerType
    int getPlayer() {
        String key = mAppContext.getString(R.string.pref_key_player);
        int value = mSharedPreferences.getInt(key, 0);
        return value;
    }

    public void setPlayer(@PlayerType int type) {
        String key = mAppContext.getString(R.string.pref_key_player);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(key, type);
        mCompat.apply(editor);
    }

    public void setRender(@RenderType int type) {
        String key = mAppContext.getString(R.string.pref_key_render);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(key, type);
        mCompat.apply(editor);
    }

    public @RenderType
    int getRender() {
        String key = mAppContext.getString(R.string.pref_key_render);
        int value = mSharedPreferences.getInt(key, 0);
        return value;
    }

    public void setScale(@ScaleType int type) {
        String key = mAppContext.getString(R.string.pref_key_scale);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(key, type);
        mCompat.apply(editor);
    }

    public @ScaleType
    int getScale() {
        String key = mAppContext.getString(R.string.pref_key_scale);
        int value = mSharedPreferences.getInt(key, 0);
        return value;
    }


    /**
     * 使用编解码器硬编码还是软编码
     *
     * @return true 硬编码 false 为软编码
     */
    public boolean getUsingMediaCodec() {
        String key = mAppContext.getString(R.string.pref_key_using_media_codec);
        return mSharedPreferences.getBoolean(key, false);
    }

    public void setUsingMediaCodec(boolean using) {
        String key = mAppContext.getString(R.string.pref_key_using_media_codec);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key, using);
        mCompat.apply(editor);
    }

    /**
     * 使用编解码是否自转
     *
     * @return
     */
    public boolean getUsingMediaCodecAutoRotate() {
        String key = mAppContext.getString(R.string.pref_key_using_media_codec_auto_rotate);
        return mSharedPreferences.getBoolean(key, false);
    }

    public void setUsingMediaCodecAutoRotate(boolean using) {
        String key = mAppContext.getString(R.string.pref_key_using_media_codec_auto_rotate);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key, using);
        mCompat.apply(editor);
    }

    /**
     * @return
     */
    public boolean getMediaCodecHandleResolutionChange() {
        String key = mAppContext.getString(R.string.pref_key_media_codec_handle_resolution_change);
        return mSharedPreferences.getBoolean(key, false);
    }

    public void setMediaCodecHandleResolutionChange(boolean change) {
        String key = mAppContext.getString(R.string.pref_key_media_codec_handle_resolution_change);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key, change);
        mCompat.apply(editor);
    }

    /**
     * @return
     */
    public boolean getUsingOpenSLES() {
        String key = mAppContext.getString(R.string.pref_key_using_opensl_es);
        return mSharedPreferences.getBoolean(key, false);
    }

    public void setUsingOpenSLES(boolean using) {
        String key = mAppContext.getString(R.string.pref_key_using_opensl_es);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key, using);
        mCompat.apply(editor);
    }

    public @PixelFormatType
    String getPixelFormat() {
        String key = mAppContext.getString(R.string.pref_key_pixel_format);
        return mSharedPreferences.getString(key, "");
    }

    public void setPixelFormat(@PixelFormatType String type) {
        String key = mAppContext.getString(R.string.pref_key_pixel_format);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, type);
        mCompat.apply(editor);
    }

    /**
     * @return
     */
    public boolean getEnableDetachedSurfaceTextureView() {
        String key = mAppContext.getString(R.string.pref_key_enable_detached_surface_texture);
        return mSharedPreferences.getBoolean(key, false);
    }

    public void setEnableDetachedSurfaceTextureView(boolean enable) {
        String key = mAppContext.getString(R.string.pref_key_enable_detached_surface_texture);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key, enable);
        mCompat.apply(editor);
    }

    /**
     * @return
     */
    public boolean getUsingMediaDataSource() {
        String key = mAppContext.getString(R.string.pref_key_using_mediadatasource);
        return mSharedPreferences.getBoolean(key, false);
    }

    public void setUsingMediaDataSource(boolean using) {
        String key = mAppContext.getString(R.string.pref_key_using_mediadatasource);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key, using);
        mCompat.apply(editor);
    }

    /**
     * 创建一个解决SharedPreferencesCompat.apply方法的一个兼容类
     */
    private static class SharedPreferencesCompat {
        private final Method sApplyMethod = findApplyMethod();

        /**
         * 反射查找apply的方法
         *
         * @return
         */
        private Method findApplyMethod() {
            try {
                Class<SharedPreferences.Editor> clz = SharedPreferences.Editor.class;
                return clz.getMethod("apply");
            } catch (Exception e) {
            }

            return null;
        }

        /**
         * 如果找到则使用apply执行，否则使用commit
         *
         * @param editor
         */
        public void apply(SharedPreferences.Editor editor) {
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor);
                    return;
                }
            } catch (Exception e) {
            }
            editor.commit();
        }
    }

}
