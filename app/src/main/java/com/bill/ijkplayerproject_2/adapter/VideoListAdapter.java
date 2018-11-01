package com.bill.ijkplayerproject_2.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bill.ijkplayerproject_2.R;
import com.bill.ijkplayerproject_2.bean.VideoListBean;
import com.bill.ijkplayerproject_2.ijk.widget.media.IjkVideoView;

import java.util.List;

public class VideoListAdapter extends RecyclerView.Adapter {

    private Activity activity;
    private List<VideoListBean> videoList;

    public VideoListAdapter(Activity activity, List<VideoListBean> videoList) {
        this.activity = activity;
        this.videoList = videoList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.adapter_video_list_item, parent, false);
        return new VideoItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((VideoItemViewHolder) holder).update(position);
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    private IjkVideoView ijkVideoView;

    public IjkVideoView getVideoView() {
        if (ijkVideoView == null) {
            ijkVideoView = new IjkVideoView(activity);
        } else {
            ViewParent viewParent = ijkVideoView.getParent();
            if (viewParent instanceof FrameLayout) {
                FrameLayout frameLayout = (FrameLayout) viewParent;
                frameLayout.removeAllViews();
            }
        }
        return ijkVideoView;
    }

    public class VideoItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView bgIv;
        private TextView titleTv;
        private TextView nameTv;
        private TextView commentTv;
        private ImageView playIv;
        private View videoGroup;
        private FrameLayout playerViewGroup;

        public VideoItemViewHolder(View itemView) {
            super(itemView);
            bgIv = itemView.findViewById(R.id.iv_video_bg);
            titleTv = itemView.findViewById(R.id.tv_title);
            nameTv = itemView.findViewById(R.id.tv_name);
            commentTv = itemView.findViewById(R.id.tv_comment);
            playIv = itemView.findViewById(R.id.iv_play_icon);
            videoGroup = itemView.findViewById(R.id.fl_video_group);
            playerViewGroup = itemView.findViewById(R.id.fl_player);
        }

        private void update(final int position) {
            final VideoListBean videoListBean = videoList.get(position);
            bgIv.setImageResource(R.drawable.zyw);
            titleTv.setText(videoListBean.title);
            nameTv.setText(videoListBean.name);
            commentTv.setText(videoListBean.commentNum + "评论");

            videoGroup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (videoListBean.playStatus == 1) {
                        // 当前正在播放
                        Log.e("Bill", "当前正在播放");
                    } else if (videoListBean.playStatus == 2) {
                        // 当前暂停播放
                        Log.e("Bill", "当前暂停");
                    } else {
                        // 播放当前，且将之前播放停止
                        Log.e("Bill", "当前没有播放");
                        for (int i = 0; i < videoList.size(); i++) {
                            VideoListBean bean = videoList.get(i);
                            if (bean.playStatus > 0) {
                                bean.playStatus = 0;
                                break;
                            }
                        }

                        videoListBean.playStatus = 1;

                        IjkVideoView ijkVideoView = getVideoView();
                        ijkVideoView.stopPlayback();
                        ijkVideoView.release(true);
                        playerViewGroup.addView(ijkVideoView);
                        ijkVideoView.setVideoPath("https://rmrbtest-image.peopleapp.com/upload/video/201809/1537349021125fcfb438615c1b.mp4");
                        ijkVideoView.start();
                    }
                }
            });
        }

    }

}
