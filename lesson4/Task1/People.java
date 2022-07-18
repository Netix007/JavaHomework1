public class People {
    
    private String name;
    private int accuracy;
    private int speedRun;
    private int speedSwim;

    public People(String name, int accuracy, int speedRun, int speedSwim) {
        
        this.name = name;
        
        this.accuracy = accuracy;
        this.speedRun = speedRun;
        this.speedSwim = speedSwim;
    }

    public String getName() {
        return name;
    }
    
    public int getAccuracy() {
        return accuracy;
    }

    public int getSpeedRun() {
        return speedRun;
    }

    public int getSpeedSwim() {
        return speedSwim;
    }

    public void printInfo() {
        System.out.println("Имя: " + name);
        System.out.println("Меткость: " + accuracy);
        System.out.println("Скорость бега: " + speedRun);
        System.out.println("Скорость плавания: " + speedSwim);
        System.out.println();
    }

    public void nothing() {
        return;
    }

}