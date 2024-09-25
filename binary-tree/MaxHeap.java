import java.util.Scanner;

class MaxHeap {

    public static int left(int index) {
        return 2 * index + 1;
    }

    public static int right(int index) {
        return 2 * (index + 1);
    }

    public static boolean isValidIndex(int index, int[] heap) {
        return index >= 0 && index < heap.length;
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");
        int[] v = new int[seq.length];
        for (int i = 0; i < seq.length; i++) v[i] = Integer.parseInt(seq[i]);

        boolean flag = true;
        for (int i = 0; i < v.length; i++) {
            if (isValidIndex(left(i), v)) {
                if (v[left(i)] >= v[i]) {
                    flag = false;
                    break;
                }
            }
            if (isValidIndex(right(i), v)) {
                if (v[right(i)] >= v[i]) {
                    flag = false;
                    break;
                }
            }
        }

        System.out.println(flag);
        
    }
    
}
