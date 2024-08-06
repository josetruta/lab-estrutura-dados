import java.util.Arrays;
import java.util.Scanner;

class Cormen {

    private static void swap(int v[], int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

    private static int particionamento(int v[], int left, int right) {

        int pivot = v[right];
        int i = left;

        for (int j = i; j <= right - 1; j++) {
            if (v[j] <= pivot) {
                swap(v, i, j);
                i += 1;
            }
        }

        swap(v, i++, right);
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