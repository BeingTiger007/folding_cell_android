package com.example.folding_cell_android;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

public class YoutubeVideos extends AppCompatActivity implements VideoAdapter.AddLifecycleCallbackListener {

    private RecyclerView recyclerView ;
    private VideoAdapter videoAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_videos);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P){
            getWindow().getAttributes().layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }

        recyclerView = findViewById(R.id.youtube_video_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setFocusable(false);

        videoAdapter = new VideoAdapter(this);
        recyclerView.setAdapter(videoAdapter);
        videoAdapter.setId(getIdVideo());

    }

    @Override
    public void addLifeCycleCallBack(YouTubePlayerView youTubePlayerView) {
        getLifecycle().addObserver(youTubePlayerView);
    }

    private ArrayList<Video> getIdVideo () {
        ArrayList<Video> mVideoIdList = new ArrayList<>();

        mVideoIdList.add(new Video("iwlP4MZz6qs"));
        mVideoIdList.add(new Video("_gikjdpWmcI"));
        mVideoIdList.add(new Video("7WE_K7NDL0s"));
        mVideoIdList.add(new Video("FTlczfR82mQ"));

        mVideoIdList.add(new Video("EFafSYg-PkI"));
        mVideoIdList.add(new Video("hs3piaN4b5I"));
        mVideoIdList.add(new Video("S-AGE8rDs3Q"));
        mVideoIdList.add(new Video("Zz6eOVaaelI"));

        return mVideoIdList;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}