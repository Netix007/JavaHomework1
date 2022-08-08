public class Obstacle {
    
    private String name;
    private int targets;
    private int distanceRun;
    private int distanceSwim;
    
    public Obstacle(String name, int value) {
        this.name = name;
        if (name.equals("Тир")) {
            this.targets = value;
        }
        else if (name.equals("Кросс")) {
            this.distanceRun = value;
        }
        else if (name.equals("Бассейн")) {
            this.distanceSwim = value;
        }
    }

    public String getName() {
        return name;
    }

    public int getTargets() {
        return targets;
    }

    public int getDistanceRun() {
        return distanceRun;
    }

    public void printInfo() {
        System.out.println(name);
        if (name.equals("Тир")) {
            System.out.println("Количество мишеней: " + targets);
        }
        else if (name.equals("Кросс")) {
            System.out.println("Длина дистанции: " + distanceRun);
        }
        else if (name.equals("Бассейн")) {
            System.out.println("Длина дистанции: " + distanceSwim);
        }
    }
}
