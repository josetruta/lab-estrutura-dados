import java.util.Scanner;

class TorreHanoi {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int pinos = Integer.parseInt(sc.nextLine());

        Pilha A = new Pilha(pinos, "A");
        Pilha B = new Pilha(pinos, "B");
        Pilha C = new Pilha(pinos, "C");

        for (int i = 1; i <= pinos; i++) A.push(i);

        torreHanoi(pinos, A, B, C);
    }

    private static void torreHanoi (int pinos, Pilha origem, Pilha auxiliar, Pilha destino) {
        if (pinos == 1) {
            System.out.printf("Move o disco 1 da haste %s para a haste %s%n", origem.toString(), destino.toString());
        } else {
            torreHanoi(pinos - 1, origem, destino, auxiliar);
            System.out.printf("Move o disco %d da haste %s para a haste %s%n", pinos, origem.toString(), destino.toString());
            torreHanoi(pinos - 1, auxiliar, origem, destino);
        }
    }   
}

class Pilha {

    private int[] pilha;
    private int topo;
    private String rotulo;

    public Pilha(int capacidade, String rotulo) {
        this.pilha = new int[capacidade];
        this.topo = -1;
        this.rotulo = rotulo;
    }

    private boolean isEmpty() {
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

    public String toString() {
        return this.rotulo;
    }
}
