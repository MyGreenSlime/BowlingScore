import java.util.*;

public class Game {
    private List<Frame> frames;
    private boolean isNextFrame = true;

    private Deque<Frame> incompleteFrame;
    private Deque<Frame> completeFrame;
    private Frame lastFrame;

    public Game() {
        this.incompleteFrame = new LinkedList<>();
        this.completeFrame = new LinkedList<>();
        this.frames = new ArrayList<>();
    }

    public void add(int score) {
        int frameCount = completeFrame.size() + incompleteFrame.size();

        if (isNextFrame && frameCount < 10) {
            incompleteFrame.addLast(new Frame());
        }

        Iterator<Frame> it = incompleteFrame.iterator();
        while (it.hasNext()) {
            Frame frame = it.next();
            frame.addScore(score);
            if (frame.isCompleted()) {
                if (completeFrame.size() > 0) {
                    frame.addScore(completeFrame.getLast().getScore());
                }
                completeFrame.addLast(frame);
                it.remove();
            }
        }

        if (score == 10) {
            isNextFrame = true;
        } else {
            isNextFrame = !isNextFrame;
        }
    }

    public int getScore() {
        int retScore = completeFrame.size() > 0 ? completeFrame.getLast().getScore() : 0;
        for (Frame frame : incompleteFrame) {
            retScore += frame.getScore();
        }
        return retScore;
    }

    public int getScoreForFrame(int index) {
        index = index - 1;
        if (index < completeFrame.size()) {
            Iterator<Frame> it = completeFrame.iterator();
            int curIndex = 0;
            while (it.hasNext() && curIndex < index) {
                it.next();
                curIndex++;
            }
            Frame frame = it.next();
            return frame.getScore();
        } else {
            int retScore = completeFrame.size() > 0 ? completeFrame.getLast().getScore() : 0;
            int remainingIndex = index - completeFrame.size();
            Iterator<Frame> it = incompleteFrame.iterator();
            int curIndex =  0;
            while (it.hasNext() && curIndex < remainingIndex) {
                retScore += it.next().getScore();
                curIndex++;
            }
            return retScore;
        }
    }
}
