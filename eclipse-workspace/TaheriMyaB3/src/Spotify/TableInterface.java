package Spotify;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Title, artists, length, genre

public class TableInterface extends JFrame implements ActionListener
{
    JTable dataTable;
    static Scanner scnr = null;
    File file = new File("/Users/mt25190/Desktop/CS-HL1-Projects/college.txt");

    String[] col = {"Title", "Artists", "Length", "Genre"};
    Object[][] data = {{"Title1", "Artist1", "Length1", "Genre1"}, 
                        {"Title2", "Artist2", "Length2", "Genre2"},
                        {"Title3", "Artist3", "Length3", "Genre3"}};

    public TableInterface()
    {
        setTitle("Spotify");
        setSize(800,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        dataTable = new JTable(data, col);
            JScrollPane scrollPane = new JScrollPane(dataTable);
            // dataTable.setBounds(10,10,500,100);
            dataTable.setBackground(new Color (224, 245, 218));
            dataTable.setGridColor(Color.black);
            scrollPane.setBounds(10,10,500,100);
            add (scrollPane);
            // add(dataTable);
        JButton songButton = new JButton("Enter New Song");
            songButton.addActionListener(this);
            songButton.setBounds(10,150,200,50);
            add(songButton);
        JButton saveButton = new JButton("Save");
            saveButton.addActionListener(this);
            saveButton.setBounds(10,200,200,50);
            add(saveButton);
        JButton playlistButton = new JButton("Create a Playlist");
            playlistButton.addActionListener(this);
            playlistButton.setBounds(10,250,200,50);
            add(playlistButton);
    }

    public static void main (String[] args)
    {
        TableInterface gui = new TableInterface();
        gui.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("Enter New Song"))
		{
            System.out.println("Enter a new song");
            String title = "title";
            String artist = "artist";
            String length = "length";
            String genre = "genre";
            Song newSong = new Song(title, artist, length, genre);
        }
        if(e.getActionCommand().equals("Save"))
		{
            System.out.println("Save");
        }
        if(e.getActionCommand().equals("Create a Playlist"))
		{
            System.out.println("Create a Playlist");

        }
       
        
    }
    
}
