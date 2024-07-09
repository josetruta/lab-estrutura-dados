import java.util.Scanner;

class PosicaoElementos {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String n = sc.nextLine();
        String[] numeros = sc.nextLine().split(" ");
        String out = "";

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i].equals(n)) out += (i + " ");
        }

        if (out.equals("")) out = "-1";

        System.out.println(out.trim());

    }
    
}
