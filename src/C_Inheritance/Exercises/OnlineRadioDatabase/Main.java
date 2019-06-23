// 05. Online Radio Database
package C_Inheritance.Exercises.OnlineRadioDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());

        while (lines-- > 0) {

            String[] data = reader.readLine().split(";");

            try {
                new Song(data[0], data[1], data[2]);

            } catch (InvalidSongException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(String.format("Songs added: %d", SongDatabase.getSongsCount()));
        System.out.println(String.format("Playlist length: %s", SongDatabase.getTotalLengthOfSongs()));
    }
}
