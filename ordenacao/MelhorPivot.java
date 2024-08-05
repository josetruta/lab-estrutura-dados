// SOLUÇÃO EM ANDAMENTO

import java.util.Scanner;

class MelhorPivot {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");
        int[] v = new int[seq.length];
        for (int i = 0; i < seq.length; i++) v[i] = Integer.parseInt(seq[i]);

        int i = sc.nextInt();
        int j = sc.nextInt();

        int menor_i = 0;
        int maior_i = 0;
        int menor_j = 0;
        int maior_j = 0;
        for (int k = 0; k < v.length; k++) {
            if (k != i) {
                if (v[k] < v[i]) menor_i += 1;
                else maior_i += 1;
            }
            if (k != j) {
                if (v[k] < v[j]) menor_j += 1;
                else maior_j += 1;
            }   
        }

        if (menor_i == 0 || maior_i == 0) System.out.println(j);
        else if (menor_j == 0 || maior_j == 0) System.out.println(i);
        else {
            int diff_i = Math.abs(menor_i - maior_i);
            int diff_j = Math.abs(menor_j - maior_j);
            if (diff_i <= diff_j) System.out.println(i);
            else System.out.println(j);
        }
        
    }
    
}
