import java.util.Scanner;

class InverteFrase {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String seq = sc.nextLine();
        PilhaS pilha = new PilhaS(seq.length());

        String palavra = "";
        for (int i = 0; i < seq.length(); i++) {
            if (seq.substring(i, i+1).equals(" ")) {
                pilha.push(palavra);
                palavra = "";
            } else {
                palavra += seq.substring(i, i+1);
            }
        }
        pilha.push(palavra);

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

}