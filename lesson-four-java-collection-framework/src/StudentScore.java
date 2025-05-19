public class StudentScore {
    public int faithScore = 10;
    public int ednaScore = 9;
    public int floraScore = 4;

    public StudentScore() {

    }

    public int getFaithScore() {
        return faithScore;
    }
    public int getEdnaScore() {
        return ednaScore;
    }
    public int getFloraScore() {
        return floraScore;
    }

    public String getHighestScore() {
        int highestScore = 0;
        if (getFloraScore() > highestScore) {
            highestScore = getFloraScore(); // highestScore = 4
        }

        if (getFaithScore() > highestScore) {
            highestScore = getFaithScore(); // highestScore = 10
        }

        if (getEdnaScore() > highestScore) {
            highestScore = getEdnaScore();
        }

        return String.format("Final Highest score is %s", highestScore);
    }
}
