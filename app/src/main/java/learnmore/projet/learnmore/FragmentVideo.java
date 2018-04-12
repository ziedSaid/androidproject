package learnmore.projet.learnmore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import learnmore.projet.learnmore.Adapters.VideoRecyclerViewAdapter;
import learnmore.projet.learnmore.Model.Video;

/**
 * Created by khalil on 27/03/2018.
 */

public class FragmentVideo extends Fragment {
    View view;
    RecyclerView recyclerView;
    VideoRecyclerViewAdapter adapter;
    List<Video> myVideos;
    FirebaseFirestore firestore;
    String courseId;


    public FragmentVideo() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.video_fragment, container, false);
        myVideos = new ArrayList<>();

        recyclerView = (RecyclerView) view.findViewById(R.id.video_id);
        adapter = new VideoRecyclerViewAdapter(myVideos, view.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        database.child("videos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot coursDataSnapshot : dataSnapshot.getChildren()) {
                    Video video = coursDataSnapshot.getValue(Video.class);
                    if (video.getCourseId().equals(getCourseId()))
                    {
                        myVideos.add(video);
                        Log.d("Course title : ", video.getTitle() );
                        adapter.notifyDataSetChanged();

                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return view;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
