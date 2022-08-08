import java.util.*;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AppData {
    
    private Map<String,List<Integer>> csv;

    public AppData() {
        
        this.csv = new TreeMap<String,List<Integer>>();
    }

    public void addRandom(int countName, int countValue) {
        Random rnd = new Random();
        for (int i = 1; i <= countName; i++) {
            List<Integer> values = new ArrayList<>();
            for (int j = 0; j < countValue; j++) {
                values.add(1 + rnd.nextInt(101));
            }
            csv.put("Value"+Integer.toString(i), values);            
        }
    }

    public void loadFromCSV(String path) {
        
        File newFile = new File(path);
        try (FileReader reader = new FileReader(newFile)) {
            Scanner scanner = new Scanner(newFile, "UTF-8");
            String temp = scanner.nextLine();
            List<String> names = addValue(temp);
            
            while (scanner.hasNextLine()) {
                temp = scanner.nextLine();
                String[] values = temp.split(";");
                for (int i = 0; i < names.size(); i++) {
                    if (csv.containsKey(names.get(i))) {
                        csv.get(names.get(i)).add(Integer.valueOf(values[i]));
                    } else {
                        List<Integer> newValues = new ArrayList<>();
                        newValues.add(Integer.valueOf(values[i]));
                        csv.put(names.get(i), newValues);
                    }
                }
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String,List<Integer>> getMap() {
        return csv;
    }

    private List<String> addValue(String temp) {
        List<String> value = new ArrayList<String>();
        while (temp.indexOf(";") != -1) {
            value.add(temp.substring(0, temp.indexOf(";")));
            temp = temp.substring(temp.indexOf(";")+1);
        }
        value.add(temp);
        return value;
    }

    public void save(String path) {
        File newFile = new File(path);
        Set<String> names = csv.keySet();
        try (FileWriter write = new FileWriter(newFile)) {
            names.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        

    }

}
