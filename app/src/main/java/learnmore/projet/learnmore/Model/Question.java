package learnmore.projet.learnmore.Model;

import java.io.Serializable;

/**
 * Created by khalil on 31/03/2018.
 */

public class Question implements Serializable {
    private int id;
    private String question;
    private String optA;
    private String optB;
    private String optC;
    private String answer;
    private String courseId;

    public Question(){
        id=0;
        question = "";
        optA = "";
        optB = "";
        optC = "";
        answer = "";
    }

    public Question(int id, String question, String optA, String optB, String optC, String answer, String courseTitle) {
        this.question = question;
        this.optA = optA;
        this.optB = optB;
        this.optC = optC;
        this.answer = answer;

    }

    public Question(String question, String optA, String optB, String optC, String answer){
        this.question = question;
        this.optA = optA;
        this.optB = optB;
        this.optC = optC;
        this.answer = answer;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public String getOptC() {
        return optC;
    }

    public String getOptB() {
        return optB;
    }

    public String getOptA() {
        return optA;
    }

    public String getQuestion() {
        return question;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOptA(String optA) {
        this.optA = optA;
    }

    public void setOptB(String optB) {
        this.optB = optB;
    }

    public void setOptC(String optC) {
        this.optC = optC;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
