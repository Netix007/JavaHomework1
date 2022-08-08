
public class Main {
    
    public static void main(String[] args) {
        AppData data = new AppData();
        //data.loadFromCSV("data.csv");
        data.addRandom(4, 10);
        System.err.println(data.getMap());
        data.save("test.csv");
    }
}