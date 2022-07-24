import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
//import java.util.Random;

//Вам необходимо создать плейлисты, объеденённых одним названием(настроением) 
//из разных музыкальных жанров, треки в этих плелистах должны быть отсоритрованы 
//по популярности (колличеству прослушиваний).

public class Main {

    public static Map<String, Map<String, Integer>> importData() {
        Map<String, Map<String, Integer>> result = new LinkedHashMap<>();
        File newFile = new File("music2.csv");
        try (FileReader reader = new FileReader(newFile)) {
            Scanner scanner = new Scanner(newFile, "UTF-8");
            while (scanner.hasNextLine()) {
                String temp = scanner.nextLine();
                String songName = temp.substring(0, temp.indexOf(";"));
                Integer lissening = Integer.parseInt(temp.substring(temp.indexOf(";")+1, temp.indexOf(";", temp.indexOf(";")+1)));
                String styleName = temp.substring(temp.lastIndexOf(";")+1);
                if (result.containsKey(styleName)) {
                    result.get(styleName).put(songName, lissening);
                } else {
                    result.put(styleName, new LinkedHashMap<>());
                    result.get(styleName).put(songName, lissening);
                }
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static Map<String, Map<String, Integer>> sortCollection(Map<String, Map<String, Integer>> allSongs) {
        Map<String, Map<String, Integer>> result = new LinkedHashMap<>();
        for (Map.Entry<String, Map<String, Integer>> iterable_element : allSongs.entrySet()) {
            result.put(iterable_element.getKey(), sortMusic(iterable_element.getValue()));
        }
        return result;
    }

    public static Map<String, Integer> sortMusic(Map<String, Integer> music) {
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        while (music.size() != 0) {
            int maxValue = 0;
            String tempName = "";
            for (Map.Entry<String, Integer> item : music.entrySet()) {
                if (item.getValue() > maxValue) {
                    maxValue = item.getValue();
                    tempName = item.getKey();
                }
            }
            sortedMap.put(tempName, maxValue);
            music.remove(tempName);
        }
        return sortedMap;
    }

    public static Map<String, Integer> playList(String style1, String style2, 
                                                            Map<String, Map<String, Integer>> allSongs) {
        
        Map<String, Integer> result = new LinkedHashMap<>();
        System.out.println("Плей лист " + style1 + " + " + style2);
        Iterator<Map.Entry<String, Integer>> entries1 = allSongs.get(style1).entrySet().iterator();
        Iterator<Map.Entry<String, Integer>> entries2 = allSongs.get(style2).entrySet().iterator();
        int count = 0;
        while (count < 5) {
            Map.Entry<String, Integer> entry1 = entries1.next();
            Map.Entry<String, Integer> entry2 = entries2.next();
            result.put(entry1.getKey(), entry1.getValue());
            result.put(entry2.getKey(), entry2.getValue());
            //System.out.println("ID = " + entry1.getKey() + " День недели = " + entry1.getValue());
            count ++;
        }
        return sortMusic(result);
    }

    public static void playNow(Map<String, Integer> songs) {
        for (Map.Entry<String, Integer> iterable_element : songs.entrySet()) {
            System.out.println("Сейчас играет: " + iterable_element.getKey());
        }
    }

    public static void playRandom(Map<String, Integer> songs) {
        Random rnd = new Random();
        while (!songs.isEmpty()) {
            int number = rnd.nextInt(songs.size());
            System.out.println("Сейчас играет: " + songs.keySet().toArray()[number]);
            songs.remove(songs.keySet().toArray()[number]);
        }
    }

    public static void main(String[] args) {
        playNow(playList("рок", "поп", sortCollection(importData())));
        playRandom(playList("хип-хоп", "поп", sortCollection(importData())));

    }
}