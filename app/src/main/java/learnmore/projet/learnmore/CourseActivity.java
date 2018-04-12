package learnmore.projet.learnmore;

import android.content.Intent;
import android.os.Parcelable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import learnmore.projet.learnmore.Model.Question;

public class CourseActivity extends AppCompatActivity implements View.OnClickListener {

    AppBarLayout appBarLayout;
    ViewPager viewPager;
    TabLayout tabLayout;
    CourseViewPagerAdapter adapter;
    Button quizb, examb;
    String courseId;
    List<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        appBarLayout = (AppBarLayout) findViewById(R.id.coursebar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        quizb = (Button) findViewById(R.id.quizb);
        quizb.setOnClickListener(this);
        examb = (Button) findViewById(R.id.examb);
        examb.setOnClickListener(this);
        adapter = new CourseViewPagerAdapter(getSupportFragmentManager());

        //Retrive Data
        Intent intent = getIntent();
        String title = intent.getExtras().getString("Title");
        String description = intent.getExtras().getString("Description");
        courseId = intent.getExtras().getString("courseId");

        //add all our fragments :
        FragmentDescription fragmentDescription = new FragmentDescription();
        fragmentDescription.setText(title, description);

        FragmentVideo fragmentVideo = new FragmentVideo();
        fragmentVideo.setCourseId(courseId);

        FragmentNotes fragmentNotes= new FragmentNotes();
        fragmentNotes.setCourseId(courseId);

        adapter.addFragment(fragmentDescription, "Description");
        adapter.addFragment(fragmentVideo, "Videos");
        adapter.addFragment(fragmentNotes, "Notes");

        //seting up the adapter
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
//questions
        questions = new ArrayList<>();
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        database.child("test").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot coursDataSnapshot : dataSnapshot.getChildren()) {
                    Question question = coursDataSnapshot.getValue(Question.class);
                    if (question.getCourseId().equals(courseId))
                    {
                        questions.add(question);

                    }

                }
                Collections.shuffle(questions);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.quizb:
                intent = new Intent(this, TestActivity.class);
                intent.putExtra("questions", (Serializable) questions);
                startActivity(intent);
                break;
            case R.id.examb:
                intent = new Intent(this, ExamActivity.class);
                intent.putExtra("questions", (Serializable) questions);
                startActivity(intent);
                break;
            default:
                finish();
                break;
        }
    }
}
