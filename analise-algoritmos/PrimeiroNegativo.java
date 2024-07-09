import java.util.Scanner;

class PrimeiroNegativo {

    public static String busca_negativo(String[] sequencia, int idx) {
        if (idx == sequencia.length) return "-";
        if (Integer.parseInt(sequencia[idx]) < 0) return sequencia[idx];
        return busca_negativo(sequencia, ++idx);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] sequencia = sc.nextLine().split(" ");

        System.out.println(PrimeiroNegativo.busca_negativo(sequencia, 0));

    }

}