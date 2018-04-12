package learnmore.projet.learnmore;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

import java.util.List;

import learnmore.projet.learnmore.Model.Question;

/**
 * Created by khalil on 06/04/2018.
 */


public class TestStepperAdapter extends AbstractFragmentStepAdapter {

    private static final String CURRENT_STEP_POSITION_KEY ="position";
    private List<Question> question;

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }

    public TestStepperAdapter(FragmentManager fm, Context context, List<Question> question) {
        super(fm, context);
        this.question = question;
    }

    @Override
    public Step createStep(int position) {
        final StepFragmentTest step = new StepFragmentTest();
        step.setQuestion(question.get(position));
        Bundle b = new Bundle();
        b.putInt(CURRENT_STEP_POSITION_KEY, position);
        step.setArguments(b);
        return step;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0) int position) {
        //Override this method to set Step title for the Tabs, not necessary for other stepper types
        return new StepViewModel.Builder(context)
                .setTitle("Question " + (position+1)) //can be a CharSequence instead
                .create();
    }
}