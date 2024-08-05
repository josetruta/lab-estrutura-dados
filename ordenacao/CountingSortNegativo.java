import java.util.Arrays;
import java.util.Scanner;

class CountingSortNegativo {
    
    private static int[] sort(int[] v, int k, int m) {
        int[] c = new int[k - m + 1];
        
        for (int i = 0; i < v.length; i++) {
            c[v[i] - m] += 1;
            System.out.println(Arrays.toString(c));
        }

        for (int i = 1; i < c.length; i++) c[i] += c[i-1];
        System.out.printf("Cumulativa do vetor de contagem - %s%n", Arrays.toString(c));

        int[] b = new int[v.length];

        for (int i = v.length - 1; i >= 0; i--) {
            b[c[v[i] - m] - 1] = v[i];
            c[v[i] - m] -= 1;
        }

        System.out.println(Arrays.toString(c));

        return b;
        
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String[] seq = sc.nextLine().split(" ");
        int[] v = new int[seq.length];
        for (int i = 0; i < seq.length; i++) v[i] = Integer.parseInt(seq[i]);

        int k = sc.nextInt();
        int m = sc.nextInt();

        int[] b = sort(v, k, m);
        System.out.println(Arrays.toString(b));
    }
}
