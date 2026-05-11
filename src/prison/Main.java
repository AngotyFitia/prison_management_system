package prison;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            Sentence s1 = new Sentence(4, LocalDate.of(2022, 1, 1));
            Sentence s2 = new Sentence(8, LocalDate.of(2023, 1, 1));
            Sentence s3 = new Sentence(12, LocalDate.of(2021, 1, 1));
            Sentence s4 = new Sentence(18, LocalDate.of(2020, 1, 1));

            Detainee d1 = new Detainee("John", 0, 0, "M", LocalDate.of(1990, 5, 10), s1, 0);
            Detainee d2 = new Detainee("Paul", 0, 0, "M", LocalDate.of(1985, 3, 20), s2, 0);
            Detainee d3 = new Detainee("Mike", 0, 0, "M", LocalDate.of(1992, 7, 15), s3, 0);
            Detainee d4 = new Detainee("Alex", 0, 0, "M", LocalDate.of(1988, 9, 25), s4, 0);

            List<Detainee> detainees = Arrays.asList(d1, d2, d3, d4);

            Prison prison = new Prison();
            List<List<Detainee>> groups = prison.groupDetainees(detainees);
            prison.assignToCells(groups);

            // Créer la fenêtre
            JFrame frame = new JFrame("Prison Management System");
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            // Ajouter le panneau personnalisé
            PrisonPanel panel = new PrisonPanel(prison);
            frame.add(panel);

            frame.setVisible(true);
        });
    }
}
