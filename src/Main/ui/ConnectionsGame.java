package Main.ui;

import Main.model.Answer;
import Main.model.Group;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ConnectionsGame extends JFrame {

    private int mistakesAllowed;
    private List<Answer> selectedOptions;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    public Scanner input = new Scanner(System.in);
    private Group firstGroup;
    private Group secondGroup;
    private Group thirdGroup;
    private Group forthGroup;
    private List<Group> groups;
    private List<Answer> options;
    private SubmitButton submitButton;

    public ConnectionsGame() {
        super("Connections! (By Jack)");
        groups = setupGroups();
        options = setupOptions();
        this.mistakesAllowed = 4;
        this.selectedOptions = new ArrayList<>();
        init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private List<Group> setupGroups() {
        firstGroup = setupGroup();
        firstGroup.setSolvedColor(new Color(31, 108, 255));
        secondGroup = setupGroup();
        secondGroup.setSolvedColor(new Color(243, 255, 46));
        thirdGroup = setupGroup();
        thirdGroup.setSolvedColor(new Color(36, 155, 16));
        forthGroup = setupGroup();
        forthGroup.setSolvedColor(new Color(123, 93, 169));
        List<Group> groups = new ArrayList<>();
        groups.add(firstGroup);
        groups.add(secondGroup);
        groups.add(thirdGroup);
        groups.add(forthGroup);
        return groups;
    }

    private Group setupGroup() {
        System.out.println("Group theme: ");
        Group group = new Group(input.nextLine());
        System.out.println("First answer: ");
        Answer firstAnswer = new Answer(input.nextLine());
        group.setCorrectAnswer(firstAnswer);
        System.out.println("Second answer: ");
        Answer secondAnswer = new Answer(input.nextLine());
        group.setCorrectAnswer(secondAnswer);
        System.out.println("Third answer: ");
        Answer thirdAnswer = new Answer(input.nextLine());
        group.setCorrectAnswer(thirdAnswer);
        System.out.println("Forth answer: ");
        Answer forthAnswer = new Answer(input.nextLine());
        group.setCorrectAnswer(forthAnswer);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        return group;
    }

    private List<Answer> setupOptions() {
        List<Answer> allAnswers = new ArrayList<>();
        for (Group group : groups) {
            allAnswers.addAll(group.getCorrectAnswers());
        }
        Collections.shuffle(allAnswers);
        return allAnswers;
    }

    private void init() {
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        JPanel optionsArea = new JPanel(new GridLayout(4,4,15,15));
        add(optionsArea, BorderLayout.CENTER);
        for (Answer answer : options) {
            new OptionButton(this, optionsArea, answer);
        }
        JPanel submitArea = new JPanel(new FlowLayout(FlowLayout.CENTER));
        submitButton = new SubmitButton(this, submitArea);
        add(submitArea, BorderLayout.SOUTH);
    }

    public List<Answer> getSelectedOptions() {
        return selectedOptions;
    }

    public void select(OptionButton optionButton) {
        if (!optionButton.getSelected() && selectedOptions.size() != 4) {
            optionButton.select();
            selectedOptions.add(optionButton.getAnswer());
            if (selectedOptions.size() == 4) {
                submitButton.Ready();
            }
        } else if (selectedOptions.size() == 4 && !optionButton.getSelected()) {
            JOptionPane.showMessageDialog(null, "You have already selected 4 options!");
        } else {
            optionButton.deselect();
            selectedOptions.remove(optionButton.getAnswer());
            submitButton.unReady();
        }
    }

    public void submit() {
        if (submitButton.getReady()) {
            if (checkFirstGroup()) {
                correctAnswer(firstGroup);
            } else if (checkSecondGroup()) {
                correctAnswer(secondGroup);
            } else if (checkThirdGroup()) {
                correctAnswer(thirdGroup);
            } else if (checkForthGroup()) {
                correctAnswer(forthGroup);
            } else {
                mistakesAllowed--;
                JOptionPane.showMessageDialog(null, "Incorrect\nYou have " + mistakesAllowed
                        + " incorrect attempts left.");
            }
            checkGameOver();
        }
    }

    private void checkGameOver() {
        if (mistakesAllowed == 0) {
            JOptionPane.showMessageDialog(null, "Game over! :/");
            dispose();
        } else if (checkAllSolved()) {
            JOptionPane.showMessageDialog(null, "Correct! Well done!");
        }
    }

    private boolean checkAllSolved() {
        for (Group group : groups) {
            if (!group.getSolved()) {
                return false;
            }
        }
        return true;
    }

    private void correctAnswer(Group group) {
        for (Answer ans : selectedOptions) {
            ans.solved(group);
        }
        group.solve();
        JOptionPane.showMessageDialog(null, "Correct! The group was " + group.getTopic() + ".");
        selectedOptions.removeAll(selectedOptions);
        submitButton.unReady();
    }

    private boolean checkForthGroup() {
        for (Answer ans : selectedOptions) {
            if (!forthGroup.getCorrectAnswers().contains(ans)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkThirdGroup() {
        for (Answer ans : selectedOptions) {
            if (!thirdGroup.getCorrectAnswers().contains(ans)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSecondGroup() {
        for (Answer ans : selectedOptions) {
            if (!secondGroup.getCorrectAnswers().contains(ans)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkFirstGroup() {
        for (Answer ans : selectedOptions) {
            if (!firstGroup.getCorrectAnswers().contains(ans)) {
                return false;
            }
        }
        return true;
    }
}
