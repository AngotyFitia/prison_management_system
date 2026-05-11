package prison;

import java.time.LocalDate;

public class Penitentiary extends Person {
    private String rank; 
    private int yearsExperience;

    public Penitentiary(String name, int x, int y, String gender, LocalDate birthDate,
                        String rank, int yearsExperience) {
        super(name, x, y, gender, birthDate);
        this.rank = rank;
        this.yearsExperience = yearsExperience;
    }

    public String getRank() { return rank; }
    public int getYearsExperience() { return yearsExperience; }

    public void patrol() {
        System.out.println(getName() + " is patrolling around the cells.");
    }

    public void releaseDetainee(Detainee detainee) {
        if (rank.equals("chief") || rank.equals("sub-chief")) {
            System.out.println(getName() + " released " + detainee.getName());
        } else {
            System.out.println(getName() + " cannot release detainees.");
        }
    }
}
