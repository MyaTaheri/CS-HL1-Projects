package NumberCodes;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import QuadraticGraphing.GraphFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class QuadraticFormula extends JFrame implements ActionListener
 {
    private JLabel pictureLabel, rootsLabel, vertexFormLabel, vertexLabel;
    private File file1 = new File("parabola.jpeg");
    private BufferedImage image1 = ImageIO.read(file1);
    private ImageIcon icon1 = new ImageIcon(image1); 
    private JTextField aField, bField, cField;

    public QuadraticFormula() throws IOException
    {
        super ("quadratic formula solver");
        setSize(600,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        Color backgrounColor = new Color(255, 242, 248);
        getContentPane().setBackground(backgrounColor); 

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
            bField.setBounds(292,4,40, 20);
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
            solveButton.setBounds(415, 30,100,20);
            solveButton.addActionListener(this);
            solveButton.setBackground(Color.red);
            add(solveButton);
        JButton vertexFormButton = new JButton("Vertex Form");
            vertexFormButton.setBounds(415,55,100,20);
            vertexFormButton.addActionListener(this);
            add(vertexFormButton);
        JButton vertexButton = new JButton("Vertex");
            vertexButton.setBounds(415,80,100,20);
            vertexButton.addActionListener(this);
            add(vertexButton);
        JButton allButton = new JButton("Solve All");
            allButton.setBounds(415,105,100,20);
            allButton.addActionListener(this);
            add(allButton);
        rootsLabel = new JLabel("Roots will appear here");
            rootsLabel.setForeground(Color.blue);
            rootsLabel.setBounds (202, 30, 300, 20);
            add(rootsLabel);
        vertexFormLabel = new JLabel("Vertex form will appear here");
            vertexFormLabel.setForeground(Color.blue);
            vertexFormLabel.setBounds (202, 55, 300, 20);
            add(vertexFormLabel);
        vertexLabel = new JLabel("Vertex will appear here");
            vertexLabel.setForeground(Color.blue);
            vertexLabel.setBounds (202, 80, 300, 20);
            add(vertexLabel);
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
            double a = Double.parseDouble(aField.getText());
            double b = Double.parseDouble(bField.getText());
            double c = Double.parseDouble(cField.getText());
            rootSolve(a, b, c);
            new GraphFrame(a, b, c);
        }  
        if(e.getActionCommand().equals("Vertex"))
		{
            double a = Double.parseDouble(aField.getText());
            double b = Double.parseDouble(bField.getText());
            double c = Double.parseDouble(cField.getText());
            vertexSolve(a, b, c);
            new GraphFrame(a, b, c);
        }
        if (e.getActionCommand().equals("Vertex Form"))
        {
            double a = Double.parseDouble(aField.getText());
            double b = Double.parseDouble(bField.getText());
            double c = Double.parseDouble(cField.getText());
            vertexFormSolve(a,b,c);
            new GraphFrame(a, b, c);
        }
        if (e.getActionCommand().equals("Solve All"))
        {
            double a = Double.parseDouble(aField.getText());
            double b = Double.parseDouble(bField.getText());
            double c = Double.parseDouble(cField.getText());
            rootSolve(a,b,c);
            vertexSolve(a,b,c);
            vertexFormSolve(a, b, c);
            new GraphFrame(a, b, c);
        }
    }

    public void rootSolve(double a, double b, double c)
    {
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
            String sRoot = (String) String.format("%.2f", root);
            rootsLabel.setText("1 root at " + sRoot);
        }
        else
        {
            double root1 = (-b - Math.sqrt(discrimant)) / (2*a);
            double root2 = (-b + Math.sqrt(discrimant)) / (2*a);
            String sRoot1 = (String) String.format("%.2f", root1);
            String sRoot2 = (String) String.format("%.2f", root2);
            rootsLabel.setText("2 root at " + sRoot1 + " and " + sRoot2);
        }
    }

    public void vertexSolve(double a, double b, double c)
    {
        double x = (-1 * b) / (2 * a);
        double y = a * Math.pow(x, 2) + (b * x) + c;

        String sX = (String) String.format("%.2f", x);
        String sY = (String) String.format("%.2f", y);

        vertexLabel.setText("Vertex is at (" + sX + ", " + sY + ")");
    }

    public void vertexFormSolve(double a, double b, double c)
    {

        double x = (-1 * b) / (2 * a);
        double y = a * Math.pow(x, 2) + (b * x) + c;

        String sX = (String) String.format("%.2f", x * -1);
        String sY = (String) String.format("%.2f", y);
        
        System.out.println(x);

        String equation = a + "(x + " + sX + ")^2 + (" + sY + ")"; 
    
        vertexFormLabel.setText(equation);
    }
}
