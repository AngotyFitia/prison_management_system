package prison;

import java.time.LocalDate;

public class Sentence {
    private int durationYears;
    private LocalDate startDate;

    public Sentence(int durationYears, LocalDate startDate) {
        this.durationYears = durationYears;
        this.startDate = startDate;
    }

    public int getDurationYears() { return durationYears; }
    public LocalDate getStartDate() { return startDate; }

    public void decreaseDuration() {
        if (durationYears > 0) {
            durationYears--;
        }
    }
}
