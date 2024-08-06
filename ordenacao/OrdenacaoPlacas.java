import java.util.Arrays;
import java.util.Scanner;

class OrdenacaoPlacas {

    private static int extract_digit(int num, int d) {
        double n = num % Math.pow(10, d + 1);
        n = n / Math.pow(10, d);
        return (int) n;
    }

    private static String[] sort(String[] seq, int d) {
        int[] c = new int[10];

        int[] v = new int[seq.length];
        for (int i = 0; i < seq.length; i++) {
            v[i] = Integer.parseInt(seq[i].substring(4));
        }

        for (int i = 0; i < v.length; i++) {
            c[extract_digit(v[i], d)] += 1;
        }

        for (int i = 1; i < c.length; i++) c[i] += c[i-1];

        String[] ans = new String[seq.length];
        for (int i = v.length - 1; i >= 0; i--) {
            ans[c[extract_digit(v[i], d)] - 1] = seq[i];
            c[extract_digit(v[i], d)] -= 1;
        }

        return ans;
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(",");

        for (int i = 0; i < 4; i++) {
            seq = sort(seq, i);
        }

        System.out.println(Arrays.toString(seq).replace("[", "").replace("]", ""));

    }
    
}
