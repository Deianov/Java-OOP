package F_SOLID.Lab.p02_OpenClosedPrinciple.p01_FileStream;

public class Music extends Entity {

    private String Artist;
    private String Album;

    public String getArtist() {
        return this.Artist;
    }
    public String getAlbum() {
        return this.Album;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }
    public void setAlbum(String album) {
        Album = album;
    }
}
