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


import com.squareup.picasso.Picasso;

import java.util.List;

import learnmore.projet.learnmore.CourseActivity;
import learnmore.projet.learnmore.Model.Course;
import learnmore.projet.learnmore.R;


/**
 * Created by khalil on 26/03/2018.
 */

public class CourseRecycleViewAdapter extends RecyclerView.Adapter<CourseRecycleViewAdapter.MyViewHolder> {

    Context myContext;
    List<Course> myData;

    public CourseRecycleViewAdapter(Context myContext, List<Course> myData) {
        this.myContext = myContext;
        this.myData = myData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(myContext);
        view = layoutInflater.inflate(R.layout.cardview_cours_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.tv_course_title.setText(myData.get(position).getTitle());
        Picasso.with(myContext).load(myData.get(position).getImageUrl()).into(holder.iv_course_img);

        holder.cv_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myContext, CourseActivity.class);

                //adding extra data
                intent.putExtra("Title", myData.get(position).getTitle());
                intent.putExtra("Thumbnail", myData.get(position).getImageUrl());
                intent.putExtra("Categroie", myData.get(position).getCategorie());
                intent.putExtra("Description", myData.get(position).getPrice());
                intent.putExtra("courseId", myData.get(position).getId());
                //start the activity
                myContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return myData.size();
    }

    public void setMyData(List<Course> myData) {
        this.myData = myData;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_course_title;
        ImageView iv_course_img;
        CardView cv_course;
        public MyViewHolder(View itemView) {
            super(itemView);

            cv_course = (CardView) itemView.findViewById(R.id.course_card);
            tv_course_title = (TextView) itemView.findViewById(R.id.course_title);
            iv_course_img = (ImageView) itemView.findViewById(R.id.course_img);
        }
    }
}
