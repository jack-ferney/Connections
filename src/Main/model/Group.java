package Main.model;

public class Group {

    private AnswerList correctAnswers;
    private String topic;
    private Boolean solved;

    public Group(String topic, AnswerList correctAnswers) {
        this.topic = topic;
        this.correctAnswers = correctAnswers;
        this.solved = false;
    }

    public String getTopic() {
        return topic;
    }

    public AnswerList getCorrectAnswers() {
        return correctAnswers;
    }

    public Boolean getSolved() {
        return solved;
    }

    public void solve() {
        solved = true;
    }
}
