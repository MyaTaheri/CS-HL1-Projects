import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DigitalClock extends JFrame {

    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;

    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;
    
    DigitalClock() 
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Digital Clock");
        this.setLayout(new FlowLayout());
        this.setSize(375, 220);
        this.setResizable(false);

        Color backgroundColor = new Color(87, 89, 130);
        Color backgroundColor2 = new Color (172, 202, 242);
        Color fontColor2 = new Color(5, 22, 92);
        Color fontColor = new Color(213, 219, 245);


        getContentPane().setBackground(backgroundColor2);

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("dd MMMMM, yyyy");
       
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Ink Free", Font.PLAIN, 59));
        timeLabel.setBackground(backgroundColor);
        timeLabel.setForeground(fontColor);
        timeLabel.setOpaque(true);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Ink Free",Font.BOLD,34));
        dayLabel.setForeground(fontColor2);

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Ink Free",Font.BOLD,30));
        dateLabel.setForeground(fontColor2);

        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);

        setTimer();
    }

    public void setTimer() 
    {
        while (true) 
        {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            try 
            {
                Thread.sleep(1000);
            } 
            catch (Exception e) 
            {
                e.getStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new DigitalClock();
    }
}