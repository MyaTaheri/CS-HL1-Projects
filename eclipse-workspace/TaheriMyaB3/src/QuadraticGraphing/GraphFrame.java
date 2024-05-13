package QuadraticGraphing;

import javax.swing.JFrame;

public class GraphFrame extends JFrame {
    GraphPanel panel;

    public GraphFrame(double a, double b, double c) {
        panel = new GraphPanel(a, b, c);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);

    }
}
