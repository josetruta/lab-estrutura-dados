import java.util.Scanner;

class ExpressaoMatematica {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split("");
        PilhaS pilha = new PilhaS(seq.length);

        for (int i = 0; i < seq.length; i++) {
            pilha.push(seq[i]);
            if (pilha.peek().equals(")")) {
                pilha.pop();
                String operacao = "";
                while (!pilha.peek().equals("(")) {
                    operacao += pilha.pop();
                }
                pilha.pop();
                pilha.push(Integer.toString(traduzirExpressao(operacao)));
            }
        }

        if (pilha.size() > 1) {
            String operacao = "";
            while (!pilha.isEmpty()) {
              operacao += pilha.pop();
            }
            System.out.println(traduzirExpressao(operacao));
        } else {
            System.out.println(pilha.peek()); 
        }

    }

    private static int traduzirExpressao(String exp) {
        int idx_op = 0;
        for (int i = 1; i < exp.length(); i++) {
            if(!isNumeric(exp.substring(i, i+1))) {
                idx_op = i;
                break;
            }
        }
        if (idx_op == 0) return - Integer.parseInt(exp.substring(1));
        String op = exp.substring(idx_op, idx_op+1);
        int valor_1 = Integer.parseInt(exp.substring(0, idx_op));
        int valor_2 = Integer.parseInt(exp.substring(idx_op+1, exp.length()));
        if (op.equals("+")) return valor_1 + valor_2;
        if (op.equals("-")) return valor_2 - valor_1;
        if (op.equals("*")) return valor_1 * valor_2;
        if (op.equals("/")) return valor_2 / valor_1;
        return -1;
    }
    
    private static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
          return false;
        }
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
