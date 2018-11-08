package com.bill.ijkplayerproject_2.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;

import com.bill.ijkplayerproject_2.R;
import com.bill.ijkplayerproject_2.adapter.VideoListAdapter;
import com.bill.ijkplayerproject_2.bean.VideoListBean;
import com.bill.ijkplayerproject_2.ijk.widget.media.IjkVideoView;
import com.bill.ijkplayerproject_2.manager.VideoViewManager;

import java.util.ArrayList;
import java.util.List;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class VideoListActivity extends AppCompatActivity {

    private RecyclerView rvVideoList;
    private VideoListAdapter videoListAdapter;

    private List<VideoListBean> videoList = new ArrayList<>(20);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);
        init();
        bindView();
        addListener();
        loadData();

        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        IjkMediaPlayer.native_profileEnd();
    }

    @Override
    protected void onStop() {
        super.onStop();
        release();
    }

    private void init() {
        rvVideoList = findViewById(R.id.recycler_list);
    }

    private void bindView() {
        videoListAdapter = new VideoListAdapter(this, videoList);
        rvVideoList.setLayoutManager(new LinearLayoutManager(this));
        rvVideoList.setAdapter(videoListAdapter);
    }

    private void addListener() {
        // 滑动监听
        rvVideoList.addOnScrollListener(new RecyclerView.OnScrollListener() {

            private int prevFirstItemPosition; // 记录上一次第一个可见item的position
            private int prevLastItemPosition; // 记录上一次最后一个可见item的position
            private View prevFistView; // 记录上一次第一个可见item的View
            private View prevLastView; // 记录上一次最后一个可见item的View

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                LinearLayoutManager linearManager = (LinearLayoutManager) layoutManager;
                //获取最后一个可见view的位置
                int lastItemPosition = linearManager.findLastVisibleItemPosition();
                //获取第一个可见view的位置
                int firstItemPosition = linearManager.findFirstVisibleItemPosition();
                //获取可见view的总数
                int itemCount = linearManager.getChildCount();

//                Log.e("Bill", itemCount + "|" + firstItemPosition + "|" + lastItemPosition);

                if (prevFirstItemPosition < firstItemPosition) {
                    // Item向上滑出屏幕了，滑出的Item的position为prevFirstItemPosition，滑出的Item的View为prevFistView

                    VideoListBean firstBean = videoList.get(prevFirstItemPosition);
                    if (firstBean.playStatus > 0) {
                        firstBean.playStatus = 0;
                        release();
                    }
                } else if (prevLastItemPosition > lastItemPosition) {
                    // Item向下滑出屏幕了，滑出的Item的position为prevLastItemPosition，滑出的Item的View为prevLastView

                    VideoListBean lastBean = videoList.get(prevLastItemPosition);
                    if (lastBean.playStatus > 0) {
                        lastBean.playStatus = 0;
                        release();
                    }
                }
                prevFirstItemPosition = firstItemPosition;
                prevLastItemPosition = lastItemPosition;
                prevFistView = recyclerView.getChildAt(0);
                prevLastView = recyclerView.getChildAt(itemCount - 1);

            }
        });
    }

    private void release() {
        IjkVideoView videoView = VideoViewManager.getInstance().getVideoView();
        ViewParent viewParent = videoView.getParent();
        if (viewParent instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) viewParent;
            frameLayout.removeAllViews();

            VideoViewManager.getInstance().stop();
        }
    }

    private void loadData() {
        for (int i = 0; i < 20; i++) {
            VideoListBean bean = new VideoListBean("", "大熊猫比爬高，还没开始就开始耍赖，果然是国宝", "新青年", "", 100);
            videoList.add(bean);
        }
        videoListAdapter.notifyDataSetChanged();
    }

}
