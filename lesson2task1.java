import java.util.Random;

public class lesson2task1 {

    public static int[] getArr(int n) {
        Random rnd = new Random(System.currentTimeMillis());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt(101);
        }
        return arr;
    }

    public static int[] quicksort(int[] arr, int start, int end) {
        int len = end - start + 1;
        if (len < 2) {
            return arr;
        } else {
            int temp = 0;
            int n = start + len/2;
            int opp = arr[n];
            for (int i = start + len/2 + 1; i <= end; i++) {
                if (arr[i] < opp) {
                    temp = arr[n+1];
                    arr[n+1] = arr[i];
                    arr[i] = temp;
                    temp = opp;
                    arr[n] = arr[n+1];
                    arr[n+1] = temp;
                    n++;
                }        
            }
            for (int i = -1 + start + len/2; i >= start; i--) {
                if (arr[i] >= opp) {
                    temp = arr[n-1];
                    arr[n-1] = arr[i];
                    arr[i] = temp;
                    temp = opp;
                    arr[n] = arr[n-1];
                    arr[n-1] = temp;
                    n--;
                }            
            }
            quicksort(arr, n + 1, end);
            quicksort(arr, start, n-1);
            return arr;
        }
    }

    public static void search(int[] arr, int start, int end, int num) {
        int len = end - start + 1;
        int n = start + len/2; 
        if (len < 2 & arr[n] != num) {
            System.out.println("Заданного элемент нет в массиве");
            return;
        }
        if (arr[n] == num) {
            System.out.println("Заданный элемент найден");
            return;
        }
        if (num < arr[n]) {
            search(arr, start, n-1, num);
            return;
        }
        if (num > arr[n]) {
            search(arr, n+1, end, num);
            return;
        }
    }

    public static void main(String[] args) {
        int[] result = getArr(10);
        result = quicksort(result, 0, result.length - 1);
        System.out.println("Отсортированный массив");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println("");
        int num = 99;
        System.out.println("Поиск числа: " + num);
        search(result, 0, result.length - 1, num);

    }
}