import java.util.Arrays;
import java.util.Scanner;

class CountingSort {

    private static int[] sort(int[] v, int k) {
        int[] c = new int[k + 1];
        
        for (int i = 0; i < v.length; i++) {
            c[v[i]] += 1;
            System.out.println(Arrays.toString(c).replace("[", "").replace("]", "").replace(",", ""));
        }

        for (int i = 1; i < c.length; i++) c[i] += c[i-1];
        System.out.printf("Cumulativa do vetor de contagem - %s%n", Arrays.toString(c).replace("[", "").replace("]", "").replace(",", ""));

        int[] b = new int[v.length];

        for (int i = v.length - 1; i >= 0; i--) {
            b[c[v[i]] - 1] = v[i];
            c[v[i]] -= 1;
        }

        System.out.println(Arrays.toString(c).replace("[", "").replace("]", "").replace(",", ""));

        return b;
        
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String[] seq = sc.nextLine().split(" ");
        int[] v = new int[seq.length];
        for (int i = 0; i < seq.length; i++) v[i] = Integer.parseInt(seq[i]);

        int k = sc.nextInt();

        int[] b = sort(v, k);
        System.out.println(Arrays.toString(b).replace("[", "").replace("]", "").replace(",", ""));
    }
}