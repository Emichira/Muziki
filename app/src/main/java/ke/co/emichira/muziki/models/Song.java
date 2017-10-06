package ke.co.emichira.muziki.models;

/**
 * Created by michira on 10/3/17.
 */

public class Song {


    public long songId;
    public String title;
    public String artist;
    public String album;
    public long albumId;
    public int duration;
    public int year;


    public Song(long songID, String songTitle, String songArtist,String songAlbum,long songalbumId,int songDuration) {
        songId=songID;
        title=songTitle;
        artist=songArtist;
        album=songAlbum;
        albumId=songalbumId;
        duration=songDuration;

    }

    public long getSongID(){return songId;}
    public String getTitle(){return title;}
    public String getArtist(){return artist;}
    public String getAlbum(){return album;}
    public long getAlbumId(){return albumId;}
    public int getDuration(){return duration;}
    public int getYear(){return year;}
}
