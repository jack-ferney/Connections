package Main.model;

import java.util.List;

public class AnswerList {

    private List<Answer> answerList;
    private Group answer;
    private Boolean solved;

    public AnswerList(List<Answer> answerList, Group answer) {
        this.answerList = answerList;
        this.answer = answer;
        this.solved = false;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public Group getAnswer() {
        return answer;
    }

    public Boolean getSolved() {
        return solved;
    }

    public void solve() {
        solved = true;
    }
}
