import java.util.Arrays;
import java.util.Scanner;

class RadixTresDigitos {

    private static int extract_digit(int num, int d) {
        double n = num % Math.pow(10, d + 3);
        n = n / Math.pow(10, d);
        return (int) n;
    }

    private static int[] sort(int[] v, int d) {
        int[] c = new int[1000];

        for (int i = 0; i < v.length; i++) {
            c[extract_digit(v[i], d)] += 1;
        }

        for (int i = 1; i < c.length; i++) c[i] += c[i-1];

        int[] b = new int[v.length];
        for (int i = v.length - 1; i >= 0; i--) {
            b[c[extract_digit(v[i], d)] - 1] = v[i];
            c[extract_digit(v[i], d)] -= 1;
        }

        return b;
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");
        int[] v = new int[seq.length];
        for (int i = 0; i < seq.length; i++) v[i] = Integer.parseInt(seq[i]);

        int d = sc.nextInt();

        for (int i = 0; i < d; i+=3) {
            v = sort(v, i);
            System.out.println(Arrays.toString(v));
        }
    }
    
}
