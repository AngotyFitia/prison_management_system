package prison;

import java.time.LocalDate;

public class Visitor extends Person {
    public Visitor(String name, int x, int y, String gender, LocalDate birthDate) {
        super(name, x, y, gender, birthDate);
    }

    public void visit() {
        System.out.println(getName() + " is visiting a detainee.");
    }
}
