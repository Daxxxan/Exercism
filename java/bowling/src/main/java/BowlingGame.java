import java.util.ArrayList;

public class BowlingGame {
    private ArrayList<Frame> frames;
    private IllegalStateException illegalStateException = null;

    public BowlingGame() {
        this.frames = new ArrayList<>();
        this.frames.add(new Frame());
    }

    private void checkScoreIsValid(int roll) {
        if(roll < 0) {
            throw new IllegalStateException("Negative roll is invalid");
        }
    }

    private void HandleSpare() {
        if (thisFrameIsA(FrameType.SPARE, lastFrame())) {
            getRollsFrame(lastFrame()).set(0, getRollsFrame(lastFrame()).get(0) + getRollsFrame(currentFrame()).get(0));
        }
    }

    private void HandleStrikes() {
        if(thisFrameIsA(FrameType.STRIKE, lastFrame())) {
            if(thisFrameIsA(FrameType.STRIKE, beforeLastFrame())) {
                if(thisFrameIsNotAlreadyThirty(beforeLastFrame())) {
                    getRollsFrame(beforeLastFrame()).set(0, getRollsFrame(beforeLastFrame()).get(0) + getRollsFrame(lastFrame()).get(0) + getRollsFrame(currentFrame()).get(0));
                }
                if(thisFrameIsNotAlreadyThirty(lastFrame())) {
                    getRollsFrame(lastFrame()).set(0, getRollsFrame(lastFrame()).get(0) + getRollsFrame(currentFrame()).get(0) + getRollsFrame(currentFrame()).get(1));
                }
            } else {
                getRollsFrame(lastFrame()).set(0, getRollsFrame(lastFrame()).get(0) + getRollsFrame(currentFrame()).get(0) + getRollsFrame(currentFrame()).get(1));
            }
        }
    }

    private ArrayList<Integer> getRollsFrame(Frame frame) {
        return frame.getRolls();
    }

    private boolean thisFrameIsNotAlreadyThirty(Frame frame) {
        return frame != null && getRollsFrame(frame).get(0) != 30;
    }

    private void handleThreeStrikesInARow() {
        if(threeStrikesInARow()) {
            getRollsFrame(beforeLastFrame()).set(0, 30);
        }
    }

    private boolean threeStrikesInARow() {
        if(thisFrameIsA(FrameType.STRIKE, lastFrame())) {
            if(thisFrameIsA(FrameType.STRIKE, beforeLastFrame())) {
                return thisFrameIsA(FrameType.STRIKE, currentFrame());
            }
        }
        return false;
    }

    private Frame currentFrame() {
        return frames.get(frames.size() - 1);
    }

    private Frame lastFrame() {
        if(frames.size() > 1) {
            return frames.get(frames.size() - 2);
        }
        return null;
    }

    private Frame beforeLastFrame() {
        if(frames.size() > 2) {
            return frames.get(frames.size() - 3);
        }
        return null;
    }

    private boolean thisFrameIsA(FrameType strike, Frame frame) {
        return frame != null && frame.getType() == strike;
    }

    private boolean strike(int pins) {
        return pins == 10;
    }

    public void roll(int pins) {
        if(currentFrame().getType() == null || frames.size() == 10) {
            currentFrame().rollScore(pins);
            HandleStrikes();
        } else {
            frames.add(new Frame());
            currentFrame().rollScore(pins);
            HandleSpare();
            handleThreeStrikesInARow();
        }
    }

    public int score() {
        int score = 0;
        for(Frame round : frames) {
            score += round.frameScore();
        }
        return score;
    }
}