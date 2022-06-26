public class task2 {
    public static int SumDig(int n) {
        int res = 0;
        while (n != 0) {
            res += n % 10;
            n = n / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int a = 103; // [a, b] - диапазон в котором ищем число удовлетворяющее условию
        int b = 109;
        int result = 0;
        boolean flag = false;
        for (int i = a; i <= b; i++) {
            if (i % SumDig(i) == 0) {
                result = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println(String.format("Число %s без остатка делится на сумму его цифр", result));
        } else {
            System.out.println(String.format("В диапазоне [%s, %s] числа удовлетворяющего условию нет", a, b));
        }
    }
}
