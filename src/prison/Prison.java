package prison;

import java.util.ArrayList;
import java.util.List;

public class Prison {
    private List<Cell> cells;

    public Prison() {
        this.cells = new ArrayList<>();
    }

    public void addCell(Cell cell) {
        cells.add(cell);
    }

    public List<Cell> getCells() {
        return cells;
    }
}
