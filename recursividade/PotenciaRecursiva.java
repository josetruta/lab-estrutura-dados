import java.util.Scanner;

class PotenciaRecursiva {

    private static int potencia(int i, int j, int atual) {
        if (atual >= j) return 1;
        return i * potencia(i, j, atual + 1);
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int i = sc.nextInt();
        int j = sc.nextInt();

        System.out.println(potencia(i, j, 0));
    }
    
}
