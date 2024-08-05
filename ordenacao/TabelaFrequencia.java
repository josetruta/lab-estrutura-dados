import java.util.Scanner;

class TabelaFrequencia {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");
        int[] v = new int[seq.length];
        int max = 0;
        for (int i = 0; i < seq.length; i++) {
            v[i] = Integer.parseInt(seq[i]);
            if (v[i] > max) max = v[i];
        } 
    

        boolean[] item = new boolean[max + 1];
        int[] freq = new int[max + 1];

        for (int i = 0; i < v.length; i++) {
            item[v[i]] = true;
            freq[v[i]] += 1;
        }

        String out = "";
        for (int i = 0; i < v.length; i++) {
            if (item[v[i]]) {
                out = out + v[i] + "," + freq[v[i]] + " ";
                item[v[i]] = false;
            }
        }

        System.out.println(out.trim());
    }
    
}
