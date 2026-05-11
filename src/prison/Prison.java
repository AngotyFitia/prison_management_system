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

    // Group detainees by sentence duration
    public List<List<Detainee>> groupDetainees(List<Detainee> detainees) {
        List<Detainee> group1 = new ArrayList<>(); // ≤ 5 years
        List<Detainee> group2 = new ArrayList<>(); // 6–10 years
        List<Detainee> group3 = new ArrayList<>(); // 11–15 years
        List<Detainee> group4 = new ArrayList<>(); // 16+ years

        for (Detainee d : detainees) {
            int years = d.getSentence().getDurationYears();
            if (years <= 5) group1.add(d);
            else if (years <= 10) group2.add(d);
            else if (years <= 15) group3.add(d);
            else group4.add(d);
        }

        List<List<Detainee>> groups = new ArrayList<>();
        groups.add(group1);
        groups.add(group2);
        groups.add(group3);
        groups.add(group4);

        return groups;
    }

    // Assign detainees to cells (3 per cell)
    public void assignToCells(List<List<Detainee>> groups) {
        int cellNumber = 1;
        for (List<Detainee> group : groups) {
            int count = 0;
            Cell cell = new Cell(cellNumber++);
            for (Detainee d : group) {
                cell.addDetainee(d);
                d.setCellNumber(cell.getNumber());
                count++;
                if (count == 3) { // max 3 per cell
                    addCell(cell);
                    cell = new Cell(cellNumber++);
                    count = 0;
                }
            }
            if (!cell.getDetainees().isEmpty()) {
                addCell(cell);
            }
        }
    }

    //  Decrease sentence duration progressively
    public void updateSentences() {
        for (Cell cell : cells) {
            for (Detainee d : cell.getDetainees()) {
                d.getSentence().decreaseDuration();
            }
        }
    }

    // Display current prison state
    public void displayState() {
        for (Cell cell : cells) {
            System.out.println("Cell " + cell.getNumber() + ":");
            for (Detainee d : cell.getDetainees()) {
                System.out.println(" - " + d.getName() + " (" + d.getSentence().getDurationYears() + " years left)");
            }
        }
    }

}


