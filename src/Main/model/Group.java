package Main.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Group {

    private List<Answer> correctAnswers;
    private String topic;
    private Boolean solved;
    private Color solvedColor;

    public Group(String topic) {
        this.topic = topic;
        this.correctAnswers = new ArrayList<>();
        this.solved = false;
    }

    public String getTopic() {
        return topic;
    }

    public void setCorrectAnswer(Answer answer) {
        correctAnswers.add(answer);
        answer.setGroup(this);
    }

    public List<Answer> getCorrectAnswers() {
        return correctAnswers;
    }

    public Boolean getSolved() {
        return solved;
    }

    public void solve() {
        solved = true;
    }

    public boolean contains(Answer ans) {
        if (correctAnswers.contains(ans)) {
            return true;
        } else {
            return false;
        }
    }

    public void setSolvedColor(Color color) {
        this.solvedColor = color;
    }

    public Color getSolvedColor() {
        return solvedColor;
    }
}
