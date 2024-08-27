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

        int menores_i = 0;
		int menores_j = 0;
		int maiores_i = 0;
		int maiores_j = 0;

		for (int k = 0; k < v.length; k++){
			if (k != i) {
				if (v[k] > v[i]) maiores_i += 1;
				else menores_i += 1;
			}
			if (k != j) {
				if (v[k] > v[j]) maiores_j += 1;
				else menores_j += 1;
			}
			
		}

		int diff_i = Math.abs(maiores_i - menores_i);
		int diff_j = Math.abs(maiores_j - menores_j);

		if (diff_i <= diff_j) System.out.println(i);
		else System.out.println(j);
        
    }
    
}
