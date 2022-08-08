import java.util.Random;

public class Team {
    
    private String name;
    private People[] players;

    public Team(String name, String[] playersNames) {
        Random rnd = new Random(System.currentTimeMillis());
        this.name = name;
        People[] members = new People[playersNames.length];
        for (int i = 0; i < members.length; i++) {
            members[i] = new People(playersNames[i], rnd.nextInt(11), 1 + rnd.nextInt(3), rnd.nextInt(4));        
        } 
        this.players = members;    
        }

    public String getName() {
        return name;
    }

    public People[] getPlayers() {
        return players;
    }

    public void printInfo() {
        System.out.println("Состав команды: " + name);
        for (People player : players) {
            player.printInfo();
        }
    }
    
    public void printInfoPlayer(int number) {
        players[number].printInfo();
    }
}
