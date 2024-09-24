import java.util.LinkedList;
import java.util.Scanner;

class BFS {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");

        BSTBFS bst = new BSTBFS();
        for (String s : seq) bst.add(Integer.parseInt(s));

        System.out.println(bst.BFS());
    }
    
}

class BSTBFS {
    
    private Node root;

    public BSTBFS() {
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

    public String BFS() {
        String ans = "";
        LinkedList<Node> queue = new LinkedList<Node>(); 

        queue.addLast(this.root);

        while (!queue.isEmpty()) {
            Node n = queue.removeFirst();
            ans += n.value + " ";
            if (n.left != null) queue.addLast(n.left);
            if (n.right != null) queue.addLast(n.right);
        }

        return ans.trim();
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

