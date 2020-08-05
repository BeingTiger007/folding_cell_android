package com.example.folding_cell_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter <VideoAdapter.VideoViewHolder> {

    private Context mContext;
    private ArrayList<Video> mListVideo ;

    public VideoAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setId(ArrayList<Video> mList) {
        mListVideo = mList ;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VideoAdapter.VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video,parent,false);
        return new VideoAdapter.VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final VideoAdapter.VideoViewHolder holder, int position) {
        final Video video = mListVideo.get(position);
        if (video == null) {
            return;
        }
        holder.youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                youTubePlayer.loadVideo(video.getVideoID(), 0);
            }
        });
    }



    @Override
    public int getItemCount() {

        if (mListVideo == null) {
            return  0 ;
        } else {
            return mListVideo.size();
        }
    }

    public interface AddLifecycleCallbackListener {
        void addLifeCycleCallBack(YouTubePlayerView youTubePlayerView);
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {

        private YouTubePlayerView youTubePlayerView;

        public VideoViewHolder(@NonNull View videoView) {
            super(videoView);
            youTubePlayerView = videoView.findViewById(R.id.youtube_player_view);
            ((YoutubeVideos) mContext).addLifeCycleCallBack(youTubePlayerView);

        }
    }
}
