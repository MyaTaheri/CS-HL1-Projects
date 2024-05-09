package NumberCodes;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class QuadraticFormula extends JFrame implements ActionListener
 {
    private JLabel pictureLabel;
    private File file1 = new File("parabola.jpeg");
    private BufferedImage image1 = ImageIO.read(file1);
    private ImageIcon icon1 = new ImageIcon(image1); 
    private JTextField aField, bField, cField;

    public QuadraticFormula() throws IOException
    {
        super ("quadratic formula solver");
        setSize(1000,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE); 

        pictureLabel = new JLabel(icon1);
            pictureLabel.setBounds(1, 1, 200, 113);
            pictureLabel.setVisible(true);
            add(pictureLabel);
        aField = new JTextField(4);
            aField.setBackground(Color.YELLOW);
            aField.setBounds(202,1,40, 20);
            aField.setVisible(true);
            add(aField);
        JTextField x2 = new JTextField("x^2 + ");
            x2.setBounds(242, 1, 45, 20);
            x2.setVisible(true);
            x2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            add(x2);
        bField = new JTextField(4);
            bField.setBackground(Color.YELLOW);
            bField.setBounds(292,1,40, 20);
            bField.setVisible(true);
            add(bField);
        JTextField x = new JTextField("x + ");
            x.setBounds(332, 1, 40, 20);
            x.setVisible(true);
            x.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            add(x);
        cField = new JTextField(4);
            cField.setBackground(Color.YELLOW);
            cField.setBounds(372,1,35, 20);
            cField.setVisible(true);
            add(cField);
    }
   public static void main (String[] args) throws IOException
   {
        QuadraticFormula gui = new QuadraticFormula();
        gui.setVisible(true);
   }
    public void actionPerformed(ActionEvent e)
    {

    }
   
}
