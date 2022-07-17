import java.util.InputMismatchException;
import java.util.Scanner;

// Написать метод, который проверяет валидность логина и пароля (где нибудь в переменных сохраните)
// и при помощи конструкции try-catch рекурсивно принимайте данные (нужно ограничить колиичество попыток 
// до 6 и после 3 попытки должно быть сообщение, мол вы привысили количество попыток, немного пододождите 
// тут можете поток заслипить на некоторое время. А когда попытки кончатся - выйти)

public class lesson3task2 {

    public static Integer userLogin(Integer count) {
        String validUserName = "Ivanov78";
        String validUserPass = "qwerty";        
        if (count < 6) {
            if (count > 2) {
                try {
                    System.out.println("Вы привысили количество попыток. Подождите 10с.");
                    Thread.sleep(10000);
                } catch (Exception e) {}
            }
            Scanner sc = new Scanner(System.in);
            try {
                System.out.print("Введите Login: ");
                String userName = sc.nextLine();
                System.out.print("Введите Password: ");
                String userPass = sc.nextLine();
                count += 1;
                if (userName.equals(validUserName) && userPass.equals(validUserPass)) {
                    System.out.println("Успешная аутентификация");
                } else {
                    throw new InputMismatchException("Ошибка авторизации");
                }
            }
            catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                count = userLogin(count);
            }
            finally {sc.close();}
        }
        return count;
    }

    public static void main(String[] args) {
        userLogin(0);
    }
}
