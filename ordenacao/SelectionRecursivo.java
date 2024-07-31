import java.util.Arrays;
import java.util.Scanner;

class SelectionRecursivo {
    
    private static boolean is_sorted(int[] v) {
        for (int i = 0; i < v.length - 1; i++) {
            if (v[i] > v[i+1]) return false;
        }
        return true;
    }
    
    private static void sort(int[] v, int idx) {
        if (idx == v.length - 1) return;
        if (is_sorted(v)) return;

        int idx_menor = idx;
        for (int i = idx + 1; i < v.length; i++) {
            if (v[idx_menor] > v[i]) idx_menor = i;
        }

        int aux = v[idx_menor];
        v[idx_menor] = v[idx];
        v[idx] = aux;

        System.out.println(Arrays.toString(v));

        sort(v, ++idx);
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");
        int[] v = new int[seq.length];
        for (int i = 0; i < seq.length; i++) v[i] = Integer.parseInt(seq[i]);

        sort(v, 0);
    }
}
