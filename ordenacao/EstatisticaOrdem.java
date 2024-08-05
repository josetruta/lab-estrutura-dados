import java.util.Scanner;

class EstatisticaOrdem {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");
        int[] v = new int[seq.length];
        for (int i = 0; i < seq.length; i++) v[i] = Integer.parseInt(seq[i]);

        int token = v[0];
        int cont = 0;
        for (int i = 1; i < v.length; i++) {
            if (v[i] < token) cont += 1;
        }

        System.out.println(cont + 1);
    }
    
}
