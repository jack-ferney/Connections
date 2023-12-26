package Main.model;

import java.util.List;

public class Board {

    private List<Answer> options;
    private List<Group> groups;
    private Boolean solved;

    public Board(List<Answer> options, List<Group> groups) {
        this.options = options;
        this.groups = groups;
        this.solved = false;
    }

    public List<Answer> getOptions() {
        return options;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public Boolean getSolved() {
        return solved;
    }

    public void solve() {
        solved = true;
    }

}
