import java.util.Random;

public class obstacleCourse {

    private Obstacle[] obstacleNames;

    public obstacleCourse() {
        Random rnd = new Random(System.currentTimeMillis());
        String[] variants= {"Тир","Кросс","Бассейн"};
        Obstacle[] obstracles = new Obstacle[3];
        for (int i = 0; i < 3; i++) {
            String name = variants[rnd.nextInt(variants.length)];
            if (name.equals("Тир")) {
                obstracles[i] = new Obstacle(name, 1 + rnd.nextInt(10));
            }
            else {
                obstracles[i] = new Obstacle(name, 1 + rnd.nextInt(3));
            }
            
        }
        this.obstacleNames = obstracles;
    }

    public void printInfo() {
        System.out.println("Полоса препятствий включает: ");
        for (Obstacle obstacle : obstacleNames) {
            obstacle.printInfo();
        }
    }

    public void letsStart(Team heroes) {
        System.out.println("\nУчачтники команды " + heroes.getName() + " приглашаются на старт");
        int scoresTeam = 0;
        int scorePlayer = 0;
        for (People player : heroes.getPlayers()) {
            boolean flag = true;
            for (Obstacle obstacle : obstacleNames) {
                if (flag) {
                    if (obstacle.getName().equals("Тир")) {
                        if (player.getAccuracy() == 0) {
                            System.out.println(player.getName() + " сходит с дистанции - он не умеет стрелять");
                            flag = false;
                        }
                        else {
                            if (player.getAccuracy() >= obstacle.getTargets()) {
                                scorePlayer += obstacle.getTargets();
                            }
                            else {
                                scorePlayer += player.getAccuracy();
                            }
                        }
                        //System.out.println("В тире " + scorePlayer + " очков");
                    }
                    else if (obstacle.getName().equals("Кросс")) {
                        scorePlayer += player.getSpeedRun() * 3;
                        //System.out.println("На кроссе " + scorePlayer + " очков");
                    }
                    else if (obstacle.getName().equals("Бассейн")) {
                        if (player.getSpeedSwim() == 0) {
                            System.out.println(player.getName() + " сходит с дистанции - он не умеет плавать");
                            flag = false;
                        }
                        else {
                            scorePlayer += player.getSpeedSwim() * 3;
                            //System.out.println("В бассейне " + scorePlayer + " очков");
                        }
                    }
                }
            }
            if (flag) {
                scoresTeam += scorePlayer;
                System.out.println(player.getName() + " прошел полосу!!! Результат - " + scorePlayer + " очков");
            }
            scorePlayer = 0;
        }
        System.out.println("\nКоманда набрала " + scoresTeam + " очков");
    }
}
