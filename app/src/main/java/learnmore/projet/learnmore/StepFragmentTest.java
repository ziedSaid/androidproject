package learnmore.projet.learnmore;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import learnmore.projet.learnmore.Model.Question;

/**
 * Created by khalil on 06/04/2018.
 */

public class StepFragmentTest extends Fragment implements Step {

    View v;
    TextView txtQuestion;
    RadioButton rda,rdb,rdc;
    Question question;
    RadioGroup grp;
    RadioButton answer;

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.step_test, container, false);



        txtQuestion = (TextView)v.findViewById(R.id.questionT);
        rda = (RadioButton)v.findViewById(R.id.radio0);
        rdb = (RadioButton)v.findViewById(R.id.radio1);
        rdc = (RadioButton)v.findViewById(R.id.radio2);

        rda.setText(question.getOptA());
        rdb.setText(question.getOptB());
        rdc.setText(question.getOptC());
        grp = (RadioGroup) v.findViewById(R.id.radG1);

        //initialize your UI

        return v;
    }

    @Override
    public VerificationError verifyStep() {
        //return null if the user can go to the next step, create a new VerificationError instance otherwise
        //answer = (RadioButton) v.findViewById(grp.getCheckedRadioButtonId());
        if (!question.getAnswer().contains("hey"/*answer.getText()*/))
            {
                VerificationError verificationError = new VerificationError("wrong anser");
                return verificationError;
            }

            return null;

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