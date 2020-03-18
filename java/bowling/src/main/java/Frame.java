import java.util.ArrayList;

public class Frame {
    private ArrayList<Integer> rolls;
    private FrameType type;

    public Frame() {
        this.rolls = new ArrayList<>();
        this.type = null;
    }

    public void setType(FrameType type) {
        this.type = type;
    }

    public FrameType getType() {
        return type;
    }

    public ArrayList<Integer> getRolls() {
        return this.rolls;
    }

    public void rollScore(int score) {
        this.rolls.add(score);

        if(score == 10) {
            type = FrameType.STRIKE;
        } else if(rolls.size() == 2) {
            if(rolls.get(0) + rolls.get(1) == 10) {
                type = FrameType.SPARE;
            } else {
                type = FrameType.HOLE;
            }
        }
    }

    public int frameScore() {
        int score = 0;
        for(int roll : rolls) {
            score += roll;
        }
        return score;
    }
}
