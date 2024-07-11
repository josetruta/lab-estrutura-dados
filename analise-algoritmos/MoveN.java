import java.util.Arrays;
import java.util.Scanner;

class MoveN {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] sequencia = sc.nextLine().split(" ");
        int idx = 0;

        for (int i = 1; i < sequencia.length; i++) {
            if (Integer.parseInt(sequencia[i]) <= Integer.parseInt(sequencia[i - 1])) {
                idx = i;
                break;
            } 
        }

        int n = sequencia.length - idx;

        for (int i = 0; i < n; i++) {
            for (int j = idx; j > 0; j--) {
                if ((Integer.parseInt(sequencia[j]) > Integer.parseInt(sequencia[j - 1]))) break;
                String aux = sequencia[j];
                sequencia[j] = sequencia[j - 1];
                sequencia[j - 1] = aux;
                System.out.println(Arrays.toString(sequencia));
            }
            idx++;
        }
    }
    
}