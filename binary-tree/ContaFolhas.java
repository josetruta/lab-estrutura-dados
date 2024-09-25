import java.util.Scanner;

class ContaFolhas {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");

        BSTCf bst = new BSTCf();
        for (String s : seq) bst.add(Integer.parseInt(s));

        System.out.println(bst.contLeaves());
    }
    
}

class BSTCf {
    
    private Node root;

    public BSTCf() {
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

    public int contLeaves() {
        return this.contLeaves(this.root);
    }

    private int contLeaves(Node node) {
        if (node != null) {
            if (node.isLeaf()) return 1;
            else return this.contLeaves(node.left) + this.contLeaves(node.right);
        }
        return 0;
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

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }
}
