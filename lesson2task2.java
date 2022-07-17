public class lesson2task2 {
    
    public static int[] dinamicArray(int[] arr, int elem) {
        int[] result = new int[arr.length + 1]; 
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i]; 
        }
        result[arr.length] = elem;
        return result;
    }

    public static void printArr(int[] arr) {
        System.out.print(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            System.out.print(" " + arr[i]);           
        }
        System.out.println();            
    }

    public static void main(String[] args) {
        int n = 6;
        int[] result = new int[0];
        for (int i = 1; i <= n; i++) {
            int num = i * (i+1) / 2;
            result = dinamicArray(result, num);
            printArr(result);
        }
    }
}
