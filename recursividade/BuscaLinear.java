import java.util.Scanner;

class BuscaLinear {

    private static int busca(String[] v, String target, int idx) {
        if (idx >= v.length) return -1;
        if (v[idx].equals(target)) return idx;
        return busca(v, target, idx + 1);
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] v = sc.nextLine().split(" ");
        String target = sc.nextLine();

        System.out.println(busca(v, target, 0));
        
    }
    
}
