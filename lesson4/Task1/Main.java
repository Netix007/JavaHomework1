public class Main {

    public static void main(String[] args) {        
        String[] names = {"Ivan", "Sergey", "Alex", "Vasiliy"};
        Team comand1 = new Team("Loosers", names);
        comand1.printInfo();
        obstacleCourse heroes = new obstacleCourse();
        heroes.printInfo();
        //comand1.printInfoPlayer(0);
        heroes.letsStart(comand1);
    }
}