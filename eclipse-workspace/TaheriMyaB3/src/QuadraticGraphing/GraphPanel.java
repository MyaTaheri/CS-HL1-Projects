package QuadraticGraphing;

import java.awt.*;

import javax.swing.JPanel;

public class GraphPanel extends JPanel {
    int h = 500;
    int w = 500;

    int originX = w/2;
    int originY = h/2;

    double a,b,c;

    GraphPanel(double a, double b, double c) {
        this.setPreferredSize(new Dimension(h, w));
        
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void paintComponent(Graphics g) {
        double scale = 2;

        // Creates the x and y axis
        Graphics2D g1 = (Graphics2D) g;

        g1.drawLine(0, h/2, w, h/2);
        g1.drawLine(w/2, 0, w/2, h);

        // Draws function
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.red);

        Polygon p1 = new Polygon();
        for (double x = -w; x <= w; x += 0.1)
        {
            p1.addPoint((int)(originX + x*scale), (int)(originY - scale * ((int) Math.round(a*(x*x)+b*x+c))));
        }
    
        g2.drawPolyline(p1.xpoints, p1.ypoints, p1.npoints);
    }
}