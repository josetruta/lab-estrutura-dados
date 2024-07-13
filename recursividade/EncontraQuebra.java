import java.util.Scanner;

class EncontraQuebra {

    private static int busca(String[] arr, int idx) {
        if (idx == arr.length - 1) return -1;
        if (Integer.parseInt(arr[idx]) >= Integer.parseInt(arr[idx + 1])) return idx + 1;
        return busca(arr, idx + 1);
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split(" ");

        System.out.println(busca(arr, 0));
    }
    
}
