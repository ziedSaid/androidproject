package learnmore.projet.learnmore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

import learnmore.projet.learnmore.Adapters.NoteRecyclerViewAdapter;
import learnmore.projet.learnmore.Model.Note;

/**
 * Created by khalil on 27/03/2018.
 */

public class FragmentNotes extends Fragment {
    View view;
    RecyclerView recyclerView;
    NoteRecyclerViewAdapter adapter;
    List<Note> myNotes;
    FirebaseFirestore firestore;
    String courseId;


    public FragmentNotes() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.notes_fragment, container, false);
        myNotes = new ArrayList<>();

        recyclerView = (RecyclerView) view.findViewById(R.id.note_id);
        adapter = new NoteRecyclerViewAdapter(myNotes, view.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));


        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        database.child("notes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot coursDataSnapshot : dataSnapshot.getChildren()) {
                    Note note = coursDataSnapshot.getValue(Note.class);
                    if (note.getCourseId().equals(getCourseId()))
                    {
                        myNotes.add(note);
                        Log.d("Course title : ", note.getTitle() );
                        adapter.notifyDataSetChanged();

                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        /*firestore = FirebaseFirestore.getInstance();
        firestore.collection("Notes").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot queryDocumentSnapshots, FirebaseFirestoreException e) {
                if (e != null){
                    Log.d("firebase erreur : ", e.getMessage() );
                }

                for (DocumentChange doc: queryDocumentSnapshots.getDocumentChanges()){
                    if(doc.getType() == DocumentChange.Type.ADDED){

                        Note course = doc.getDocument().toObject(Note.class);
                        myNotes.add(course);
                        Log.d("Course title : ", course.getTitle() );

                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });*/

        return view;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }
}
