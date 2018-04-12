package learnmore.projet.learnmore;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import learnmore.projet.learnmore.Adapters.CourseRecycleViewAdapter;
import learnmore.projet.learnmore.Model.Course;

public class Papers extends AppCompatActivity {


    RecyclerView recyclerView;
    CourseRecycleViewAdapter crvAdapter;
    List<Course> myData;
    MaterialSearchView materialSearchView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_papers);
        myData = new ArrayList<>();
        final FirebaseAuth mAuth;
        toolbar =(Toolbar) findViewById(R.id.toolbarp);
        setSupportActionBar(toolbar);
//Autentficaton anonyme
        mAuth = FirebaseAuth.getInstance();
        mAuth.signInAnonymously()
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("anonymous :", "signInAnonymously:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("failed login", "signInAnonymously:failure", task.getException());
                        }
                    }
                });

//Retrive courses collection

        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        database.child("products").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot coursDataSnapshot : dataSnapshot.getChildren()) {
                    Course course = coursDataSnapshot.getValue(Course.class);
                    course.setId(coursDataSnapshot.getKey());
                    myData.add(course);
                    Log.d("Course Id ", course.getId() );
                    crvAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
//Research

        materialSearchView = (MaterialSearchView) findViewById(R.id.search_view);
        materialSearchView.closeSearch();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_papers);
        crvAdapter =new CourseRecycleViewAdapter(this, myData);

        materialSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                processQuery(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                processQuery(query);
                return true;
            }
        });

        recyclerView.setAdapter(crvAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

    }

    private void processQuery(String query) {
        List<Course> res = new ArrayList<>();

        for (Course c : myData){
            String s =c.getTitle().toLowerCase();
            String q =query.toLowerCase();
            boolean b = s.contains(q);
            if (b)
            {
                res.add(c);
                Log.d("course", "Search1="+b);
            }
        }
        crvAdapter.setMyData(res);
        crvAdapter.notifyDataSetChanged();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        materialSearchView.setMenuItem(item);

        return true;
    }
}
