public class Frame {
    private int curScore = 0;
    private int remainingBonus = 0;
    private int remainingThrowing = 2;
    private int availablePin = 10;

    public void addScore(int score) {
        if (availablePin > 0 && remainingThrowing > 0) {
            remainingThrowing--;
            curScore += score;
            availablePin -= score;

            if (isSpare(score)) {
                remainingBonus = 1;
            } else if (isStrike(score)) {
                remainingBonus = 2;
                remainingThrowing = 0;
            }
        } else if (remainingBonus > 0) {
            addBonus(score);
        } else if (isCompleted()) {
            curScore += score;
        }
    }

    private void addBonus(int score) {
        curScore += score;
        remainingBonus--;
    }

    private boolean isStrike(int score) {
        return score == 10;
    }

    private boolean isSpare(int score){
        return availablePin == 0 && remainingThrowing == 0;
    }

    public int getScore() {
        return curScore;
    }

    public boolean isCompleted() {
        return remainingThrowing == 0 && remainingBonus == 0;
    }
}
