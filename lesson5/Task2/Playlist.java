import java.util.*;

public class Playlist {
    
    private String name;
    private List<Song> songs;

    public Playlist(String name, List<Song> songs) {
        this.name = name;
        this.songs = songs;
    }

    public List<Song> getPlaylist() {
        return songs;
    }

    public String getName() {
        return name;
    }

    public List<String> getStyles() {
        List<String> styles = new ArrayList<>();
        for (Song item : songs) {
            if (!styles.contains(item.getStyle())) {
                styles.add(item.getStyle());
            }
        }
        return styles;
    }

    public void printInfo() {
        System.out.println("Название: " + name);
        System.out.println("Плейлист содержит " + getStyles());
        System.out.println("Информация о песнях:");
        for (Song song : songs) {
            System.out.println(String.format("Стиль: %s, Название: %s, Количество прослушиваний: %d", 
                                                    song.getStyle(), song.getName(), song.getListenning()));
        }
    }

    public Playlist newPlaylist(String[] styles) {
        List<Song> playlistSong = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            playlistSong.add(Song.findstyle(styles[0], songs).get(i));
            playlistSong.add(Song.findstyle(styles[1], songs).get(i));
        }
        Playlist result = new Playlist("Плейлист " + styles[0] + " " + styles[1], Song.sortbylistenning(playlistSong));
        return result;
    }

    public void play() {
        System.out.println(name);
        for (Song song : songs) {
            System.out.println("Сейчас играет: " + song.getName());
            try {    
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("got interrupted!");
            }
        }
    } 

    public void playRandom() {
        Random rnd = new Random();
        List<Song> temp = new ArrayList<Song>();
        for (Song item : songs) {
            temp.add(item);
        }
        System.out.println(name + "(воспроизводится в случайном порядке)");
        for (int i = 0; i < songs.size(); i++) {
            int index = rnd.nextInt(temp.size());
            System.out.println("Сейчас играет: " + temp.get(index).getName());
            temp.remove(index);
            try {    
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("got interrupted!");
            }
        }
    }

}
