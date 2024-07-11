import java.util.Arrays;
import java.util.Scanner;

class MoveImpostor {

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

        for (int i = idx; i > 0; i--) {
            if ((Integer.parseInt(sequencia[i]) > Integer.parseInt(sequencia[i - 1]))) break;
            String aux = sequencia[i];
            sequencia[i] = sequencia[i - 1];
            sequencia[i - 1] = aux;
        }

        System.out.println(Arrays.toString(sequencia));

    }

}