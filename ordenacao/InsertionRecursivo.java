import java.util.Arrays;
import java.util.Scanner;

class InsertionRecursivo {

    private static void sort(int[] v, int idx) {
        if (idx == v.length - 1) return;

        int j = idx + 1;
        while ((j > 0) && (v[j] < v[j-1])) {
            int aux = v[j];
            v[j] = v[j-1];
            v[j-1] = aux;
            j -= 1;
        }

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
