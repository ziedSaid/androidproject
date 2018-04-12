package learnmore.projet.learnmore;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import org.w3c.dom.Text;

import java.util.Locale;

import learnmore.projet.learnmore.Model.Question;
import learnmore.projet.learnmore.Model.Score;

/**
 * Created by khalil on 03/04/2018.
 */

public class StepFragmentSample extends Fragment implements Step {
    View v;
    Question question;
    TextView textView;
    RadioButton rda;
    RadioButton rdb;
    RadioButton rdc;
    RadioGroup grp;
    RadioButton answer;
    Score score;

    static final long START_TIME_IN_MILLIS = 600000;
    TextView countDown;
    CountDownTimer countDownTimer;
    boolean mTimerRunning;
    long mTimeLeftInMillis = START_TIME_IN_MILLIS;


    public Score getScore() {
        return score;
    }
    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.step, container, false);

        textView = (TextView) v.findViewById(R.id.question);
        textView.setText(question.getQuestion());
        rda = (RadioButton) v.findViewById(R.id.rad0);
        rdb = (RadioButton) v.findViewById(R.id.rad1);
        rdc = (RadioButton) v.findViewById(R.id.rad2);
        countDown = (TextView) v.findViewById(R.id.countdown);
        countDownTimer =new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long l) {
                mTimeLeftInMillis = l;
                updateCountDownText();
            }

            @Override
            public void onFinish() {

            }
        }.start();
        rda.setText(question.getOptA());
        rdb.setText(question.getOptB());
        rdc.setText(question.getOptC());
        grp = (RadioGroup) v.findViewById(R.id.radG1);
        answer = (RadioButton) v.findViewById(grp.getCheckedRadioButtonId());
        score = new Score(1,1,1);
        //initialize your UI

        return v;
    }

    private void updateCountDownText() {
        int minute = (int) ((mTimeLeftInMillis / 1000) / 60);
        int seconds = (int) ((mTimeLeftInMillis / 1000) % 60);

        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d", minute,seconds);

        countDown.setText(timeLeftFormatted);
    }

    @Override
    public VerificationError verifyStep() {
        //return null if the user can go to the next step, create a new VerificationError instance otherwise
        if (!question.getAnswer().equals(answer.getText())) {
            //VerificationError verificationError =new VerificationError("wrong anser");
            //return  verificationError;

            return null;
        }
        else{

            return null;
        }
    }

    @Override
    public void onSelected() {
        //update UI when selected
    }

    @Override
    public void onError(@NonNull VerificationError error) {
        //handle error inside of the fragment, e.g. show error on EditText
    }
}
