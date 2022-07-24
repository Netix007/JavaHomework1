import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Song> songs = new ArrayList<Song>();
        songs = Song.importData("music2.csv");
        Playlist allSongs = new Playlist("Все песни", songs);
        String[] temp = {"хип-хоп", "классика"};
        //allSongs.newPlaylist(temp).printInfo();
        allSongs.newPlaylist(temp).play();
        System.out.println();
        allSongs.newPlaylist(temp).playRandom();
    }
}