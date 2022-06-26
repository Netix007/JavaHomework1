import java.util.InputMismatchException;
import java.util.Scanner;

public class task1 {
    public static int inputNum() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число n = ");
        int n = 0;
        try {
            n = sc.nextInt();
            sc.close();
        } 
        catch (InputMismatchException e) {
            System.out.println("Вы ввели не число");
            return inputNum();
        }
        return n;
    }
    public static void main(String[] args) {
        int n = inputNum();
        int res = n * (n + 1) / 2;
        System.out.println(String.format("%s-ое треугольное число: %s", n, res));
    }

}
