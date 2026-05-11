package prison;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class PrisonPanel extends JPanel {
    private Prison prison;

    public PrisonPanel(Prison prison) {
        this.prison = prison;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = 50;
        int y = 50;
        int cellWidth = 150;
        int cellHeight = 100;

        for (Cell cell : prison.getCells()) {
            
            // Dessiner la cellule
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(x, y, cellWidth, cellHeight);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, cellWidth, cellHeight);
            g.drawString("Cell " + cell.getNumber(), x + 10, y + 20);

            // Afficher les détenus
            int offsetY = 40;
            for (Detainee d : cell.getDetainees()) {
                g.drawString(d.getName() + " (" + d.getSentence().getDurationYears() + "y)", x + 10, y + offsetY);
                offsetY += 20;
            }

            // Position suivante
            x += cellWidth + 50;
            if (x > getWidth() - cellWidth) {
                x = 50;
                y += cellHeight + 50;
            }
        }
    }
}
