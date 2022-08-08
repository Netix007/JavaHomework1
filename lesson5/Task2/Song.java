import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Song {
    
    private String style;
    private String name;
    private Integer listenning;

    public Song(String style, String name, Integer listenning) {
        this.style = style;
        this.name = name;
        this.listenning = listenning;
    }

    public String getStyle() {
        return style;
    }

    public String getName() {
        return name;
    }

    public Integer getListenning() {
        return listenning;
    }

    public static List<Song> importData(String file) {
        List<Song> result = new ArrayList<Song>();
        File newFile = new File(file);
        try (FileReader reader = new FileReader(newFile)) {
            Scanner scanner = new Scanner(newFile, "UTF-8");
            while (scanner.hasNextLine()) {
                String temp = scanner.nextLine();
                String songName = temp.substring(0, temp.indexOf(";"));
                Integer lissening = Integer.parseInt(temp.substring(temp.indexOf(";")+1, temp.indexOf(";", temp.indexOf(";")+1)));
                String styleName = temp.substring(temp.lastIndexOf(";")+1);
                result.add(new Song(styleName, songName, lissening));
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sortbylistenning(result);
    }

    public static List<Song> sortbylistenning(List<Song> songs) {
        List<Song> result = new ArrayList<>();
        while (!songs.isEmpty()) {
            int max = songs.get(0).getListenning();
            Song temp = songs.get(0);
            int maxIndex = 0;
            for (int i = 1; i < songs.size(); i++) {
                if (max<songs.get(i).getListenning()) {
                    max = songs.get(i).getListenning();
                    temp = songs.get(i);
                    maxIndex = i;
                }
            }
            result.add(temp);
            songs.remove(maxIndex);
        }
        return result;
    }
    
    public static List<Song> findstyle(String style, List<Song> songs) {
        List<Song> result = new ArrayList<>();
        for (Song item : songs) {
            if (item.style.equals(style)) {
                result.add(item);
            }
        }
        return result;
    }
    
    @Override
    public String toString() {
        //System.out.println(String.format("%s %s %d", style, name, listenning));
        return String.format("Стиль: %s, Название: %s, Количество прослушиваний: %d;", style, name, listenning);
    }

}
