import java.util.Arrays;
import java.util.Scanner;

class TrocaVizinhos {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] sequencia = sc.nextLine().split(" ");

        for (int i = 0; i < sequencia.length - 1; i+=2) {
            String aux = sequencia[i];
            sequencia[i] = sequencia[i+1];
            sequencia[i+1] = aux;
        }

        System.out.println(Arrays.toString(sequencia));

    }

}
