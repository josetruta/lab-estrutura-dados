import java.util.Arrays;
import java.util.Scanner;

class Lomuto {

    private static int particionamento(int[] v, int left, int right) {

        int pivot = v[left];
        int i = left;
        
        for (int j = i + 1; j <= right; j++) {
            if (v[j] < pivot) {
                i += 1;
                int aux = v[i];
                v[i] = v[j];
                v[j] = aux;
                System.out.println(Arrays.toString(v));
            }
        }

        int aux = v[i];
        v[i] = v[left];
        v[left] = aux;

        System.out.println(Arrays.toString(v));

        return i;
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");
        int[] v = new int[seq.length];
        for (int i = 0; i < seq.length; i++) v[i] = Integer.parseInt(seq[i]);

        particionamento(v, 0, v.length - 1);

        System.out.println(Arrays.toString(v));
    }
    
}
