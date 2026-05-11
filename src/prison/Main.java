package prison;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create detainees for testing
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

            // Create main frame
            JFrame frame = new JFrame("Prison Management System");
            frame.setSize(900, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            // Layout: BorderLayout (center = prison panel, south = buttons)
            frame.setLayout(new BorderLayout());

            // Prison panel
            PrisonPanel panel = new PrisonPanel(prison);
            frame.add(panel, BorderLayout.CENTER);

            // Buttons panel
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout());

            JButton exitButton = new JButton("Exit");
            JButton enterButton = new JButton("Enter");
            JButton patrolButton = new JButton("Patrol");
            JButton releaseButton = new JButton("Release");
            JButton visitButton = new JButton("Visit");

            // Add actions (for now, just print messages)
            exitButton.addActionListener(e -> System.out.println("Exit action triggered"));
            enterButton.addActionListener(e -> System.out.println("Enter action triggered"));
            patrolButton.addActionListener(e -> System.out.println("Patrol action triggered"));
            releaseButton.addActionListener(e -> System.out.println("Release action triggered"));
            visitButton.addActionListener(e -> System.out.println("Visit action triggered"));

            // Add buttons to panel
            buttonPanel.add(exitButton);
            buttonPanel.add(enterButton);
            buttonPanel.add(patrolButton);
            buttonPanel.add(releaseButton);
            buttonPanel.add(visitButton);

            frame.add(buttonPanel, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }
}
