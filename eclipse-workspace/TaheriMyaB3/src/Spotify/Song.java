package Spotify;

public class Song 
{
    String title;
    String artist;
    String length;
    String genre;

    public Song (String title, String artist, String length, String genre)
    {
        this.title = title;
        this.artist = artist;
        this.length = length;
        this.genre = genre;
    }
    
    public String getTitle()
    {
        return title;
    }

    public String getArtist()
    {
        return artist;
    }

    public String getLength()
    {
        return length;
    }

    public String getGenre()
    {
        return genre;
    }
}
