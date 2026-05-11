package prison;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private int number;
    private List<Detainee> detainees;

    public Cell(int number) {
        this.number = number;
        this.detainees = new ArrayList<>();
    }

    public int getNumber() { return number; }
    public List<Detainee> getDetainees() { return detainees; }

    public void addDetainee(Detainee d) {
        detainees.add(d);
    }
}
