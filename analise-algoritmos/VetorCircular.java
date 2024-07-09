import java.util.Scanner;

class VetorCircular {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] sequencia = sc.nextLine().split(" ");
        int n = sc.nextInt();
        String out = "";
        
        for (int i = 0; i < n; i++) {
            out += (sequencia[i % sequencia.length] + " ");
        }

        System.out.println(out.trim());

    }

}