import java.util.Arrays;
import java.util.Scanner;

class InserePrimeiro {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");
        int[] v = new int[seq.length];
        for (int i = 0; i < seq.length; i++) v[i] = Integer.parseInt(seq[i]);

        int i = 0;
        while ((i < v.length - 1) && (v[i] > v[i+1])) {
            int aux = v[i];
            v[i] = v[i+1];
            v[i+1] = aux;
            i += 1;
        }

        System.out.println(Arrays.toString(v));
    }
    
}
