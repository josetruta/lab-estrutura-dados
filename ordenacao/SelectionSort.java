import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

class SelectionSort {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");
        int[] v = new int[seq.length];
        for (int i = 0; i < seq.length; i++) v[i] = Integer.parseInt(seq[i]);

        Set<String> out = new LinkedHashSet<String>();

        for (int i = 0; i < v.length; i++) {
            int idx_menor = i;
            for (int j = i + 1; j < v.length; j++) {
                if (v[idx_menor] > v[j]) idx_menor = j;
            }
            int aux = v[idx_menor];
            v[idx_menor] = v[i];
            v[i] = aux;

            out.add(Arrays.toString(v));
        }

        for (String s : out) {
            System.out.println(s);
        }

    }
    
}
