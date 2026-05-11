package prison;

import java.time.LocalDate;

public class Person {
    private String name;
    private int x;
    private int y;
    private String gender;
    private LocalDate birthDate;

    public Person(String name, int x, int y, String gender, LocalDate birthDate) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public String getName() { return name; }
    public int getX() { return x; }
    public int getY() { return y; }
    public String getGender() { return gender; }
    public LocalDate getBirthDate() { return birthDate; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
}
