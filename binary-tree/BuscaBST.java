import java.util.Scanner;
import java.util.ArrayList;

class BuscaBST {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");

        BSTBusca bst = new BSTBusca();
        for (int i = 0; i < seq.length; i++) bst.add(Integer.parseInt(seq[i]));

        int target = Integer.parseInt(sc.nextLine());

        ArrayList<Integer> arr = bst.search(target);

        String ans = "";
        for (int i = 0; i < arr.size(); i++) {
            if (i == 0) ans += "[";
            if (i != arr.size() - 1) ans += Integer.toString(arr.get(i)) + ", ";
            else ans += Integer.toString(arr.get(i)) + "]";
        }

        System.out.println(ans);

    }
}

class BSTBusca {
    
    private Node root;

    public BSTBusca() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void add(int element) {
        if (this.isEmpty()) this.root = new Node(element);
        else {
            Node aux = this.root;

            while (aux != null) {
                if (element < aux.value) {
                    if (aux.left == null) {
                        Node newNode = new Node(element);
                        newNode.parent = aux;
                        aux.left = newNode;
                        return;
                    }
                    aux = aux.left;
                } else {
                    if (aux.right == null) {
                        Node newNode = new Node(element);
                        newNode.parent = aux;
                        aux.right = newNode;
                        return;
                    }
                    aux = aux.right;
                }
            }
        }
    }

    public ArrayList<Integer> search(int element) {
        Node aux = this.root;
        ArrayList<Integer> ans = new ArrayList<Integer>();

        while (aux != null) {
            ans.add(aux.value);
            if (aux.value == element) return ans;
            if (element < aux.value) aux = aux.left;
            else aux = aux.right;
        }

        return ans;
    }
}

class Node {

    int value;
    Node left;
    Node right;
    Node parent;

    public Node(int value) {
        this.value = value;
    }
}
