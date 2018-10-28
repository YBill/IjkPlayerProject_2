package com.bill.ijkplayerproject_2.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;

import com.bill.ijkplayerproject_2.R;
import com.bill.ijkplayerproject_2.ijk.setting.PixelFormatType;
import com.bill.ijkplayerproject_2.ijk.setting.PlayerConfig;
import com.bill.ijkplayerproject_2.ijk.setting.PlayerType;
import com.bill.ijkplayerproject_2.ijk.setting.RenderType;
import com.bill.ijkplayerproject_2.ijk.setting.ScaleType;
import com.bill.ijkplayerproject_2.util.PageJumpUtil;

public class VideoSettingActivity extends AppCompatActivity {

    private CheckBox backgroundBackPlay;
    private RadioGroup mPlayerTypeGroup;

    private CheckBox useMediaCodec;
    private CheckBox useMediaCodecAutoRotate;
    private CheckBox mediaCodecHandleResolutionChange;
    private RadioGroup mPixelFormatTypeGroup;
    private RadioGroup mScaleTypeGroup;

    private CheckBox usingOpenslEs;

    private RadioGroup mRenderTypeGroup;
    private CheckBox enableDetachedSurfaceTexture;

    private CheckBox usingMediaDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_setting);

        backgroundBackPlay = findViewById(R.id.background_play);
        mPlayerTypeGroup = findViewById(R.id.player_type);
        useMediaCodec = findViewById(R.id.use_media_codec);
        useMediaCodecAutoRotate = findViewById(R.id.use_media_codec_auto_rotate);
        mediaCodecHandleResolutionChange = findViewById(R.id.media_codec_handle_resolution_change);
        mPixelFormatTypeGroup = findViewById(R.id.pixel_format_type);
        mScaleTypeGroup = findViewById(R.id.scale_type);
        usingOpenslEs = findViewById(R.id.using_opensl_es);
        mRenderTypeGroup = findViewById(R.id.render_type);
        enableDetachedSurfaceTexture = findViewById(R.id.enable_detached_surface_texture);
        usingMediaDataSource = findViewById(R.id.using_mediadatasource);


    }


    private void goVideoAct() {
        PlayerConfig.getInstance().setEnableBackgroundPlay(backgroundBackPlay.isChecked());
        switch (mPlayerTypeGroup.getCheckedRadioButtonId()) {
            case R.id.ijk_player:
                PlayerConfig.getInstance().setPlayer(PlayerType.PV_PLAYER__IjkMediaPlayer);
                break;
            case R.id.media_player:
                PlayerConfig.getInstance().setPlayer(PlayerType.PV_PLAYER__AndroidMediaPlayer);
                break;
            case R.id.exo_player:
                PlayerConfig.getInstance().setPlayer(PlayerType.PV_PLAYER__IjkExoMediaPlayer);
                break;
        }

        PlayerConfig.getInstance().setUsingMediaCodec(useMediaCodec.isChecked());
        PlayerConfig.getInstance().setUsingMediaCodecAutoRotate(useMediaCodecAutoRotate.isChecked());
        PlayerConfig.getInstance().setMediaCodecHandleResolutionChange(mediaCodecHandleResolutionChange.isChecked());
        switch (mPixelFormatTypeGroup.getCheckedRadioButtonId()) {
            case R.id.rgb_565:
                PlayerConfig.getInstance().setPixelFormat(PixelFormatType.RGB_565);
                break;
            case R.id.rgb_888:
                PlayerConfig.getInstance().setPixelFormat(PixelFormatType.RGB_888);
                break;
            case R.id.rgbx_8888:
                PlayerConfig.getInstance().setPixelFormat(PixelFormatType.RGBX_8888);
                break;
            case R.id.yv12:
                PlayerConfig.getInstance().setPixelFormat(PixelFormatType.YV12);
                break;
            case R.id.opengl_es2:
                PlayerConfig.getInstance().setPixelFormat(PixelFormatType.OpenGL_ES2);
                break;
        }
        switch (mScaleTypeGroup.getCheckedRadioButtonId()) {
            case R.id.fit_parent:
                PlayerConfig.getInstance().setScale(ScaleType.AR_ASPECT_FIT_PARENT);
                break;
            case R.id.fill_parent:
                PlayerConfig.getInstance().setScale(ScaleType.AR_ASPECT_FILL_PARENT);
                break;
            case R.id.wrap_content:
                PlayerConfig.getInstance().setScale(ScaleType.AR_ASPECT_WRAP_CONTENT);
                break;
            case R.id.match_parent:
                PlayerConfig.getInstance().setScale(ScaleType.AR_MATCH_PARENT);
                break;
            case R.id.fit_parent_16_9:
                PlayerConfig.getInstance().setScale(ScaleType.AR_16_9_FIT_PARENT);
                break;
            case R.id.wrap_content_4_3:
                PlayerConfig.getInstance().setScale(ScaleType.AR_4_3_FIT_PARENT);
                break;
        }

        PlayerConfig.getInstance().setUsingOpenSLES(usingOpenslEs.isChecked());

        switch (mRenderTypeGroup.getCheckedRadioButtonId()) {
            case R.id.surface_view:
                PlayerConfig.getInstance().setRender(RenderType.RENDER_SURFACE_VIEW);
                break;
            case R.id.texture_view:
                PlayerConfig.getInstance().setRender(RenderType.RENDER_TEXTURE_VIEW);
                break;
            case R.id.no_view:
                PlayerConfig.getInstance().setRender(RenderType.RENDER_NONE_VIEW);
                break;
        }
        PlayerConfig.getInstance().setEnableDetachedSurfaceTextureView(enableDetachedSurfaceTexture.isChecked());

        PlayerConfig.getInstance().setUsingMediaDataSource(usingMediaDataSource.isChecked());

        PageJumpUtil.gotoVideoTestActivity(this);
    }

    public void handleVideo(View view) {
        goVideoAct();
    }
}
