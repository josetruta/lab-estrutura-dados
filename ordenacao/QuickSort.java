import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class QuickSort {
    
    private static int particionamento(int[] v, int left, int right) {

        int pivot = v[left];
        int i = left;
        
        for (int j = i + 1; j <= right; j++) {
            if (v[j] <= pivot) {
                i += 1;
                int aux = v[i];
                v[i] = v[j];
                v[j] = aux;
            }
        }

        int aux = v[i];
        v[i] = v[left];
        v[left] = aux;

        return i;
    }

    private static void quick_sort(int[] v, int left, int right, List<String> out) {        
        if (left < right) {
            int index_pivot = particionamento(v, left, right);
            out.add(Arrays.toString(v));
            quick_sort(v, left, index_pivot - 1, out);
            quick_sort(v, index_pivot + 1, right, out);
        }
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String[] seq = sc.nextLine().split(" ");
        int[] v = new int[seq.length];
        for (int i = 0; i < seq.length; i++) v[i] = Integer.parseInt(seq[i]);

        List<String> out = new ArrayList<String>();

        quick_sort(v, 0, v.length - 1, out);
        
        for (int i = 0; i < out.size(); i++) {
            System.out.println(out.get(i).replace("[", "").replace("]", "").replace(",", ""));
        }
    }
    
}
