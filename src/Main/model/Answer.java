package Main.model;

public class Answer {

    private String answer;
    private Boolean selected;

    public Answer(String answer) {
        this.answer = answer;
        this.selected = false;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void select() {
        if (!selected) {
            selected = true;
        }
    }

    public Boolean getSelected() {
        return selected;
    }
}
