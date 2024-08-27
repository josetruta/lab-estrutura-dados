import java.util.Scanner;

class InverteFrase {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");
        PilhaS pilha = new PilhaS(seq.length);
        for (int i = 0; i < seq.length; i++) pilha.push(seq[i]);

        String out = "";
        while (!pilha.isEmpty()) {
            out += pilha.pop() + " ";
        }

        System.out.println(out.trim());

    }
    
}

class PilhaS {

    private String[] pilha;
    private int topo;

    public PilhaS(int capacidade) {
        this.pilha = new String[capacidade];
        this.topo = -1;
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    private boolean isFull() {
        return this.topo + 1 == this.pilha.length;
    }

    public String peek() {
        if (this.isEmpty()) throw new RuntimeException("Pilha vazia.");
        return this.pilha[this.topo];
    }

    public void push(String valor) {
        if (this.isFull()) throw new RuntimeException("Pilha cheia.");
        this.pilha[++this.topo] = valor;
    }

    public String pop() {
        if (this.isEmpty()) throw new RuntimeException("Pilha vazia.");
        return this.pilha[this.topo--];
    }

    public int size() {
        return this.topo + 1;
    }

    public void inverte() {
        PilhaS primeiro = new PilhaS(this.size());

        while (!this.isEmpty()) {
            primeiro.push(this.pop());
        }

        PilhaS segundo = new PilhaS(primeiro.size());
        
        while (!primeiro.isEmpty()) {
            segundo.push(primeiro.pop());
        }

        while (!segundo.isEmpty()) {
            this.push(segundo.pop());
        }

    }

}
