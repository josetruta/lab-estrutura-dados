import java.util.Scanner;

class FrequenciaElemento {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String n = sc.nextLine();
        String[] sequencia = sc.nextLine().split(" ");
        int cont = 0;
        
        for (int i = 0; i < sequencia.length; i++) {
            if (sequencia[i].equals(n)) cont++;
        }

        System.out.println(cont);

    }

}