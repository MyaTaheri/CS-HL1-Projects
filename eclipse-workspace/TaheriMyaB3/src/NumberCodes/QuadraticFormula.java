package NumberCodes;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class QuadraticFormula extends JFrame implements ActionListener
 {
    private JLabel pictureLabel, rootsLabel;
    private File file1 = new File("parabola.jpeg");
    private BufferedImage image1 = ImageIO.read(file1);
    private ImageIcon icon1 = new ImageIcon(image1); 
    private JTextField aField, bField, cField;

    public QuadraticFormula() throws IOException
    {
        super ("quadratic formula solver");
        setSize(500,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE); 

        pictureLabel = new JLabel(icon1);
            pictureLabel.setBounds(1, 4, 200, 113);
            pictureLabel.setVisible(true);
            add(pictureLabel);
        aField = new JTextField(4);
            aField.setBackground(Color.YELLOW);
            aField.setBounds(202,4,40, 20);
            aField.setVisible(true);
            add(aField);
        JLabel x2 = new JLabel("x^2 + ");
            x2.setBounds(242, 4, 45, 20);
            x2.setVisible(true);
            x2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            add(x2);
        bField = new JTextField(4);
            bField.setBackground(Color.YELLOW);
            bField.setBounds(292,1,40, 20);
            bField.setVisible(true);
            add(bField);
        JLabel x = new JLabel("x + ");
            x.setBounds(332, 4, 40, 20);
            x.setVisible(true);
            x.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            add(x);
        cField = new JTextField(4);
            cField.setBackground(Color.YELLOW);
            cField.setBounds(372,4,35, 20);
            cField.setVisible(true);
            add(cField);
        JButton solveButton = new JButton("Solve");
            solveButton.setBounds(415, 4,50,20);
            solveButton.addActionListener(this);
            // Color lightYellow = new Color (252, 240, 184);
            // solveButton.setOpaque(true);
            // solveButton.setContentAreaFilled(true);
            // solveButton.setBorderPainted(false);
            // solveButton.setFocusPainted(false);
            solveButton.setBackground(Color.red);
            add(solveButton);
        rootsLabel = new JLabel("Roots will appear here");
            rootsLabel.setForeground(Color.blue);
            rootsLabel.setBounds (202, 30, 300, 20);
            add(rootsLabel);
    }
   public static void main (String[] args) throws IOException
   {
        QuadraticFormula gui = new QuadraticFormula();
        gui.setVisible(true);
   }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Solve"))
		{
            int a = Integer.parseInt(aField.getText());
            int b = Integer.parseInt(bField.getText());
            int c = Integer.parseInt(cField.getText());

            double discrimant = Math.pow(b,2) - (4*a*c);
            System.out.println(discrimant);

            if (a == 0)
            {
                rootsLabel.setText("a can't eqaul 0");
            }
            else if (discrimant < 0)
            {
                rootsLabel.setText("No real roots");
            }
            else if (discrimant == 0)
            {
                double root = (-b + Math.sqrt(discrimant)) / (2 *a);
                rootsLabel.setText("1 root at " + root);
            }
            else
            {
                double root1 = (-b + Math.sqrt(discrimant)) / (2*a);
                double root2 = (-b - Math.sqrt(discrimant)) / (2*a);
                rootsLabel.setText("2 root at " + root1 + " and " + root2);
            }
        }
    }
}
