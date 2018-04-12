package learnmore.projet.learnmore.Model;

import java.util.List;

/**
 * Created by khalil on 06/04/2018.
 */

public class Score {
    int correct;
    int wrong;
    int resultat;

    public Score() {
    }

    public Score(int correct, int wrong, int resultat) {
        this.correct = correct;
        this.wrong = wrong;
        this.resultat = resultat;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getWrong() {
        return wrong;
    }

    public void setWrong(int wrong) {
        this.wrong = wrong;
    }

    public int getResultat() {
        return resultat;
    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
    }



}
