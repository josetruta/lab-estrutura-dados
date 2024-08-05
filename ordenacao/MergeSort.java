import java.util.Arrays;
import java.util.Scanner;

class MergeSort {

    private static void merge(int[] v, int left, int mid, int right) {
        int[] helper = new int[v.length];
        for (int i = 0; i < v.length; i++) helper[i] = v[i];

        int i = left;
        int j = mid + 1;
        int k = left;

        while ((i <= mid) && (j <= right)) {
            if (helper[i] <= helper[j]) v[k++] = helper[i++];
            else v[k++] = helper[j++];
        }

        while (i <= mid) v[k++] = helper[i++];

        int[] out = new int[right - left + 1];
        int m = 0;
        for (int n = left; n <= right; n++) {
            out[m++] = v[n];
        }
        System.out.println(Arrays.toString(out));
    }

    private static void merge_sort(int[] v, int left, int right) {
        if (left <= right) {
            int[] out = new int[right - left + 1];
            int j = 0;
            for (int i = left; i <= right; i++) {
                out[j++] = v[i];
            }
            System.out.println(Arrays.toString(out));
        }        
        
        if (left < right) {
            int mid = (right + left) / 2;
            merge_sort(v, left, mid);
            merge_sort(v, mid + 1, right);
            merge(v, left, mid, right);
        }
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String[] seq = sc.nextLine().split(" ");
        int[] v = new int[seq.length];
        for (int i = 0; i < seq.length; i++) v[i] = Integer.parseInt(seq[i]);

        merge_sort(v, 0, v.length - 1);
    }
}