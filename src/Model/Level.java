package Model;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private List<String> description = new ArrayList<String>();
    private List<Answer> answers;
    private int number;

    private List<Level> nextLevels = new ArrayList<>();
    private Level preLevel;

    public void setNextLevels(List<Level> nextLevels) {
        this.nextLevels = nextLevels;
    }

    public List<Level> getNextLevels() {
        return nextLevels;
    }

    public void setPreLevel(Level preLevel) {
        this.preLevel = preLevel;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setDescription(String description) {
        this.description.add(description);
    }

    public List<String> getDescription() {
        return description;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
