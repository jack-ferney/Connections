package Main.ui;

import Main.model.Answer;
import Main.model.Board;
import Main.model.Group;

import java.util.ArrayList;
import java.util.List;

public class ConnectionsGame {

    private Board game;
    private int mistakesAllowed;
    private List<Answer> selectedOptions;

    public ConnectionsGame(List<Group> groups, List<Answer> options) {
        this.game = new Board(options, groups);
        this.mistakesAllowed = 4;
        this.selectedOptions = new ArrayList<>();
    }
    
    public List<Answer> getSelectedOptions() {
        return selectedOptions;
    }
}
