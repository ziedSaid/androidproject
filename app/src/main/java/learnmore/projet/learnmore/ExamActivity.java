package learnmore.projet.learnmore;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.List;

import learnmore.projet.learnmore.Model.Question;
import learnmore.projet.learnmore.Model.Score;

public class ExamActivity extends AppCompatActivity implements StepperLayout.StepperListener {

    private StepperLayout mStepperLayout;
    List<Question> questions;
    String coursId;
    Score score;
    public String getCoursId() {
        return coursId;
    }

    public void setCoursId(String coursId) {
        this.coursId = coursId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        mStepperLayout = (StepperLayout) findViewById(R.id.stepperLayout);
        Intent intent = getIntent();
        questions = (List<Question>) intent.getExtras().getSerializable("questions");

        final MyStepperAdapter adapter = new MyStepperAdapter(getSupportFragmentManager(), this,questions);
        mStepperLayout.setAdapter(adapter);
        score = new Score(5,0,1);
        mStepperLayout.setListener(this);
    }

    @Override
    public void onCompleted(View completeButton) {
        TextView ca = (TextView) findViewById(R.id.ca);
        TextView wa = (TextView) findViewById(R.id.wa);
        TextView fs = (TextView) findViewById(R.id.FS);
        int s = score.getCorrect()+1/(score.getWrong()+score.getCorrect()+1);
        score.setResultat(s);
        //ca.setText(score.getCorrect());
        //wa.setText(score.getWrong());
        //fs.setText(score.getCorrect()*100);
        Dialog myDialog = new Dialog(this);
        myDialog.setContentView(R.layout.popup_res);
        myDialog.show();

        Toast.makeText(this, "onCompleted! "+score.getResultat(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(VerificationError verificationError) {
        Toast.makeText(this, "onError! -> " + verificationError.getErrorMessage(), Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onStepSelected(int newStepPosition) {
       RadioGroup grp = (RadioGroup) findViewById(R.id.radG1);
        RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
        int correct = score.getCorrect();
        int wrong = score.getWrong();
        if (questions.get(newStepPosition).getAnswer().equals(answer.getText())) {
            score.setCorrect(correct++);

        }else {
            score.setWrong(wrong++);
        }
        Toast.makeText(this, "onStepSelected! -> " + newStepPosition, Toast.LENGTH_SHORT).show();
    }

    public void goHome(){
        Intent intent = new Intent(this,Courses.class);
        startActivity(intent);
    }

    @Override
    public void onReturn() {
        finish();
    }


}
