package ke.co.emichira.muziki.models;

/**
 * Created by michira on 10/3/17.
 */

public class Song {


    public final long id;
    public final String title;
    public final String artist;

    public Song() {
        this.id = -1;
        this.title = "";
        this.artist = "";
    }


    public Song(long songID, String songTitle, String songArtist) {
        id=songID;
        title=songTitle;
        artist=songArtist;
    }

    public long getID(){return id;}
    public String getTitle(){return title;}
    public String getArtist(){return artist;}
}
