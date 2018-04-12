package learnmore.projet.learnmore.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import learnmore.projet.learnmore.Model.Video;
import learnmore.projet.learnmore.R;
import learnmore.projet.learnmore.VideoActivity;

/**
 * Created by khalil on 27/03/2018.
 */

public class VideoRecyclerViewAdapter extends RecyclerView.Adapter<VideoRecyclerViewAdapter.MyViewHolder> {

    List<Video> myVideos;
    Context myContext;


    public VideoRecyclerViewAdapter(List<Video> myVideos, Context myContext) {
        this.myVideos = myVideos;
        this.myContext = myContext;
    }

    public List<Video> getMyVideos() {
        return myVideos;
    }

    public void setMyVideos(List<Video> myVideos) {
        this.myVideos = myVideos;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater =LayoutInflater.from(myContext);
        view = layoutInflater.inflate(R.layout.cardview_video_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
   //     holder.iv_video_img.setImageResource(myVideos.get(position).getThumbnail());
        holder.tv_video_desc.setText(myVideos.get(position).getDescription());
        holder.tv_video_title.setText(myVideos.get(position).getTitle());
        holder.cv_video.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(myContext, VideoActivity.class);
               intent.putExtra("url", myVideos.get(position).getVideoUrl());

                myContext.startActivity(intent);
           }
       });
    }

    @Override
    public int getItemCount() {
        return myVideos.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_video_title;
        TextView tv_video_desc;
        ImageView iv_video_img;
        CardView cv_video;

        public MyViewHolder(View itemView) {
            super(itemView);

            cv_video = (CardView) itemView.findViewById(R.id.video_card);
            tv_video_title = (TextView) itemView.findViewById(R.id.video_tit);
            tv_video_desc = (TextView) itemView.findViewById(R.id.video_des);
            iv_video_img = (ImageView) itemView.findViewById(R.id.video_img);
        }
    }

}
