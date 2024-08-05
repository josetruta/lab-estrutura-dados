import java.util.Arrays;
import java.util.Scanner;

class LomutoUltimo {

    private static int particionamento(int[] v, int left, int right) {

        int pivot = v[right];
        int i = right;
        
        for (int j = right - 1; j >= 0; j--) {
            if (v[j] >= pivot) {
                i -= 1;
                int aux = v[i];
                v[i] = v[j];
                v[j] = aux;
                System.out.println(Arrays.toString(v));
            }
        }

        int aux = v[i];
        v[i] = v[right];
        v[right] = aux;

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
