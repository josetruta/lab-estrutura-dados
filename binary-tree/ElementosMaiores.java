import java.util.ArrayList;
import java.util.Scanner;

class ElementosMaiores {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");

        BSTEM bst = new BSTEM();
        for (String s : seq) bst.add(Integer.parseInt(s));

        int target = Integer.parseInt(sc.nextLine());
    
        ArrayList<Integer> arr = bst.preOrder();
        int count = 0;

        String order = "";
        for (int i = 0; i < arr.size(); i++) {
            if (i == 0) order += "[";
            if (i != arr.size() - 1) order += Integer.toString(arr.get(i)) + ", ";
            else order += Integer.toString(arr.get(i)) + "]";
            if (arr.get(i) > target) count += 1;
        }

        System.out.println(order);
        System.out.println(count);
    }
    
}

class BSTEM {
    
    private Node root;

    public BSTEM() {
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

    public ArrayList<Integer> preOrder() {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        this.preOrder(this.root, ans);
        return ans;
    }

    private void preOrder(Node node, ArrayList<Integer> arr) {
        if (node != null) {
            arr.add(node.value);
            this.preOrder(node.left, arr);
            this.preOrder(node.right, arr);
        }
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

