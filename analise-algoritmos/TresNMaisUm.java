import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class TresNMaisUm {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int i = Integer.parseInt(sc.nextLine());
        int j = Integer.parseInt(sc.nextLine());
        int maior = 0;

        while (i <= j) {
            List<Integer> sequencia = new ArrayList<Integer>();
            int num = i;
            sequencia.add(num);
            while (num != 1) {
                if (num % 2 == 0) num = num/2;
                else num = num * 3 + 1;
                sequencia.add(num);
            }
            if (sequencia.size() > maior) maior = sequencia.size();
            i++;
        }

        System.out.println(maior);

    }
}
