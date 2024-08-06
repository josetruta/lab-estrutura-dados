import java.util.Arrays;
import java.util.Scanner;

class Particionamento {

    
    private static int[] particionamento(int[] v, int left, int right) {

        int[] ans = new int[v.length];
        int i = 0;
        
        int idx_pivot = left;
        
        for (int j = 1; j <= right; j++) {
            if (v[j] <= v[idx_pivot]) {
                ans[i] = v[j];
                i += 1;
            }
        }

        ans[i++] = v[idx_pivot];

        for (int j = 1; j <= right; j++) {
            if (v[j] > v[idx_pivot]) {
                ans[i] = v[j];
                i += 1;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");
        int[] v = new int[seq.length];
        for (int i = 0; i < seq.length; i++) v[i] = Integer.parseInt(seq[i]);

        v = particionamento(v, 0, v.length - 1);

        System.out.println(Arrays.toString(v));
    }
    
}
