import java.util.Scanner;

class BuscaBinaria {

    private static int busca(String[] arr, String target, int inicio, int fim) {
        
        if (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (arr[meio].equals(target)) return meio;

            System.out.println(meio);

            if (Integer.parseInt(arr[meio]) > Integer.parseInt(target))
                return busca(arr, target, inicio, meio - 1);

            else return busca(arr, target, meio + 1, fim);
        }
        else return -1;
        
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split(" ");
        String target = sc.nextLine();

        System.out.println(busca(arr, target, 0 , arr.length - 1));
    }
    
}
