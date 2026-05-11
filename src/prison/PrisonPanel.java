package prison;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PrisonPanel extends JPanel {
    private Prison prison;
    private Detainee selectedDetainee;

    public PrisonPanel(Prison prison) {
        this.prison = prison;

        // Mouse listener for selection
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int clickX = e.getX();
                int clickY = e.getY();

                // Check if click is inside a detainee area
                int x = 50;
                int y = 50;
                int cellWidth = 150;
                int cellHeight = 100;

                for (Cell cell : prison.getCells()) {
                    int offsetY = 40;
                    for (Detainee d : cell.getDetainees()) {
                        Rectangle rect = new Rectangle(x + 10, y + offsetY - 15, 120, 20);
                        if (rect.contains(clickX, clickY)) {
                            selectedDetainee = d;
                            System.out.println("Selected detainee: " + d.getName());
                            repaint();
                            return;
                        }
                        offsetY += 20;
                    }

                    // Next cell position
                    x += cellWidth + 50;
                    if (x > getWidth() - cellWidth) {
                        x = 50;
                        y += cellHeight + 50;
                    }
                }
            }
        });
    }

    public Detainee getSelectedDetainee() {
        return selectedDetainee;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = 50;
        int y = 50;
        int cellWidth = 150;
        int cellHeight = 100;

        for (Cell cell : prison.getCells()) {
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(x, y, cellWidth, cellHeight);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, cellWidth, cellHeight);
            g.drawString("Cell " + cell.getNumber(), x + 10, y + 20);

            int offsetY = 40;
            for (Detainee d : cell.getDetainees()) {
                if (d == selectedDetainee) {
                    g.setColor(Color.YELLOW); // highlight selected detainee
                } else {
                    g.setColor(Color.BLACK);
                }
                g.drawString(d.getName() + " (" + d.getSentence().getDurationYears() + "y)", x + 10, y + offsetY);
                offsetY += 20;
            }

            x += cellWidth + 50;
            if (x > getWidth() - cellWidth) {
                x = 50;
                y += cellHeight + 50;
            }
        }
    }
}
