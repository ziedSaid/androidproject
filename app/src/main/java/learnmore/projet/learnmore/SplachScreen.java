package learnmore.projet.learnmore;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import learnmore.projet.learnmore.AcountActivities.LoginActivity;

public class SplachScreen extends AppCompatActivity implements View.OnClickListener{

    LinearLayout l1, l2;
    Button sb;
    Animation uptodown, downtoup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach_screen);
        l1 = (LinearLayout) findViewById(R.id.splachll);
        l2 = (LinearLayout) findViewById(R.id.splachll2);
        sb = (Button) findViewById(R.id.splachb);
        uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this, R.anim.downtoup);
        l1.setAnimation(uptodown);
        l2.setAnimation(downtoup);
        final Intent intent =new Intent(this, HomeDashboard.class);
        Thread thread =new Thread(){
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        thread.start();

       // sb.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent =new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
