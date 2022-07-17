import java.util.ArrayList;
import java.util.List;

public class task5 {
    
    public static String stringCut(int start, int end, String s) {
        char[] dst = new char[end-start];
        s.getChars(start, end, dst, 0);
        String str = String.valueOf(dst);
        return str;
    }

    public static List<String> numbers(List<String> num, String s) {
        String numStart = "";
        int n = s.indexOf("?");
        if (n == -1) {
            num.add(s);
            return num;
        }
        int a = 0;
        if (n == 0) {
            a = 1;
            numStart = "";
        } else {
            numStart = stringCut(0, n, s);
        }
        String m = stringCut(n+1, s.length(), s);
        for (int j = a; j < 10; j++) {
            numbers(num, numStart + Integer.toString(j) + m);
        }
        return num;
    }

    public static void main(String[] args) {
        String s = "?1 + ? = 1?";
        System.out.println("Дано уравнение: " + s);
        String temp = stringCut(0, s.indexOf("+")-1, s);
        List<String> q = numbers(new ArrayList<>(), temp);
        temp = stringCut(s.indexOf("+")+2, s.indexOf("=")-1, s);
        List<String> w = numbers(new ArrayList<>(), temp);
        temp = stringCut(s.indexOf("=")+2, s.length(), s);
        List<String> v = numbers(new ArrayList<>(), temp);
        String sum = "";
        Boolean flag = true;
        for (int i = 0; i < q.size(); i++) {
            for (int j = 0; j < w.size(); j++) {
                sum = Integer.toString(Integer.parseInt(q.get(i)) + Integer.parseInt(w.get(j)));
                if (v.contains(sum)) {
                    if (flag) {
                        System.out.println("Возможные решения: ");
                    }
                    System.out.println(q.get(i)+ " + " + w.get(j) + " = " + sum);
                    flag = false;
                }
            }
        }
        if (flag) {
            System.out.println("Решений нет");
        }
    }
}
