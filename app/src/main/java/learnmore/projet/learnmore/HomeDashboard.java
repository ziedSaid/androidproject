package learnmore.projet.learnmore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class HomeDashboard extends AppCompatActivity implements View.OnClickListener{

    private CardView course, donnation, contact, discuss, idea, paper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_dashboard);
        //define cards
        course = (CardView) findViewById(R.id.course);
        paper = (CardView) findViewById(R.id.paper);
        idea= (CardView) findViewById(R.id.idea);
        discuss = (CardView) findViewById(R.id.discuss);
        contact = (CardView) findViewById(R.id.contact);
        donnation = (CardView) findViewById(R.id.donnation);
        //add click listner
        course.setOnClickListener(this);
        paper.setOnClickListener(this);
        idea.setOnClickListener(this);
        discuss.setOnClickListener(this);
        contact.setOnClickListener(this);
        donnation.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent;

        switch (view.getId()){
            case R.id.course : intent = new Intent(this, Courses.class); startActivity(intent); break;
            case R.id.paper : intent = new Intent(this, Papers.class); startActivity(intent); break;
            case R.id.idea : intent = new Intent(this, Idea.class); startActivity(intent); break;
            case R.id.discuss : intent = new Intent(this, Discussion.class); startActivity(intent); break;
            case R.id.contact: intent = new Intent(this, Contact.class); startActivity(intent); break;
            case R.id.donnation : intent = new Intent(this, Donnation.class); startActivity(intent); break;
            default:break;
        }

    }
}
