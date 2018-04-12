package learnmore.projet.learnmore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import learnmore.projet.learnmore.AcountActivities.LoginActivity;

public class Discussion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussion);
    }
    void goLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
    }
}
