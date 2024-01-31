package sort;

public class Sort {

    public static void insertionSort(char[] data) {
        int n = data.length;
        for (int i = 1; i < n; i++) {
            char curr = data[i];
            int j = i;
            while (j > 0 && data[j-1] > curr) {
                data[j] = data[j-1];
                j--;
            }
            data[j] = curr;
        }
    }

    public static void main(String[] args) {
        char[] data = new char[]{'a','b', 'z', 'y', 'x'};
        Sort.insertionSort(data);
        System.out.println(data);
    }
}
