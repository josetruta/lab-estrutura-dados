import java.util.Scanner;

class Parenteses {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split("");
        
        Pilha pilha = new Pilha(seq.length);

        for (int i = 0; i < seq.length; i++) {
            int valor = seq[i].equals("(") ? 0 : 1;
            if (valor == 0) pilha.push(valor);
            else {
                if (!pilha.isEmpty() && pilha.peek() == 0) pilha.pop();
                else pilha.push(valor);
            }
        }

        String out = pilha.size() == 0 ? "S" : "N";
        System.out.println(out);
    }
   
}

class Pilha {

    private int[] pilha;
    private int topo;

    public Pilha(int capacidade) {
        this.pilha = new int[capacidade];
        this.topo = -1;
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    private boolean isFull() {
        return this.topo + 1 == this.pilha.length;
    }

    public int peek() {
        if (this.isEmpty()) throw new RuntimeException("Pilha vazia.");
        return this.pilha[this.topo];
    }

    public void push(int valor) {
        if (this.isFull()) throw new RuntimeException("Pilha cheia.");
        this.pilha[++this.topo] = valor;
    }

    public int pop() {
        if (this.isEmpty()) throw new RuntimeException("Pilha vazia.");
        return this.pilha[this.topo--];
    }

    public int size() {
        return this.topo + 1;
    }

}
