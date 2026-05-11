package prison;

public class Detainee extends Person {
    
    private Sentence sentence;
    private int cellNumber;

    public Detainee(String name, int x, int y, String gender, java.time.LocalDate birthDate,
                    Sentence sentence, int cellNumber) {
        super(name, x, y, gender, birthDate);
        this.sentence = sentence;
        this.cellNumber = cellNumber;
    }

    public Sentence getSentence() { return sentence; }
    public int getCellNumber() { return cellNumber; }
    public void setCellNumber(int cellNumber) { this.cellNumber = cellNumber; }
}
