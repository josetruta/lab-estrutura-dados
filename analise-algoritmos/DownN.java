import java.util.Scanner;

class DownN {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] sequencia = sc.nextLine().split(" ");
        int[] numeros = new int[sequencia.length];

        for (int i = 0; i < sequencia.length; i++) {
            numeros[i] = Integer.parseInt(sequencia[i]);
        }

        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros.length - 1 - i; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    int var = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = var;
                }
            }
        }

        int n = sc.nextInt();
        String out = "";

        for (int i = 0; i < n; i++) {
            out += (numeros[i] + " ");
        }

        System.out.println(out.trim());

    }
    
}
