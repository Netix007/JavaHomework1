// Написать программу, показывающую последовательность действий для игры “Ханойская башня”

public class lesson3task3 {

    public static int igra(String towerL, String towerC, String towerR, int n, int hod) {
        if (n !=0) {
            hod = igra(towerL, towerR, towerC, n-1, hod);
            hod += 1;
            System.out.println("Ход №" + hod + " Передвигаем диск №" + n + " c " + towerL + " на " + towerR);
            hod = igra(towerC, towerL, towerR, n-1, hod);
        }
        return hod;
    }
    public static void main(String[] args) {
        int n = 8;
        int hod = 0;
        String towerL = "1";
        String towerC = "2";
        String towerR = "3";
        igra(towerL, towerC, towerR, n, hod); 
    }
}
