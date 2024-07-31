import java.util.Arrays;
import java.util.Scanner;

class MarianaELivros {

    private static void sort(String[] v, int idx) {
        if (idx == v.length - 1) return;

        int j = idx + 1;
        while ((j > 0) && (v[j].compareTo(v[j-1]) < 0)) {
            String aux = v[j];
            v[j] = v[j-1];
            v[j-1] = aux;
            j -= 1;
        }

        System.out.println(Arrays.toString(v).replace("[", "").replace("]", ""));
        sort(v, ++idx);
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(",");
        System.out.println(Arrays.toString(seq).replace("[", "").replace("]", ""));

        sort(seq, 0);
    }
    
}
