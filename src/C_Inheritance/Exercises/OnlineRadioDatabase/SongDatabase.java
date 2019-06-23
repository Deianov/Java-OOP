package C_Inheritance.Exercises.OnlineRadioDatabase;

import java.util.ArrayList;
import java.util.List;

class SongDatabase {
    private static final List<Song> songs = new ArrayList<>();

    SongDatabase() {
    }

    void addSong(Song song) throws InvalidSongLengthException {
        /// ???
        if (song.getLengthInSeconds() < 0 || song.getLengthInSeconds() > 899) {
            throw new InvalidSongLengthException("Invalid song length.");
        }
        SongDatabase.songs.add(song);
        System.out.println("Song added.");
    }
    
    static String getTotalLengthOfSongs() {
        int timeInSeconds = 0;
        for (Song song: SongDatabase.songs) {
            timeInSeconds += song.getLengthInSeconds();
        }
        int hours = timeInSeconds / 3600;
        int minutes = (timeInSeconds % 3600) / 60;
        int seconds = timeInSeconds % 60;

        return String.format("%dh %dm %ds", hours, minutes, seconds);
    }

    static int getSongsCount() {
        return SongDatabase.songs.size();
    }
}
