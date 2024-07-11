import java.util.HashSet;
import java.util.Scanner;

class ChecaDuplicados {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] sequencia = sc.nextLine().split(" ");
        HashSet<String> set = new HashSet<String>();
        boolean flag = false;
        
        for (int i = 0; i < sequencia.length; i++) {
            if (set.contains(sequencia[i])) {
                flag = true;
                break;
            }
            set.add(sequencia[i]);
        }
        
        System.out.println(flag);
        
    }
    
}
