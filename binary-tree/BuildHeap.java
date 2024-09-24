import java.util.Arrays;
import java.util.Scanner;

class BuildHeap {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] seq = sc.nextLine().split(" ");
        
        int[] v = new int[seq.length];
        for (int i = 0; i < seq.length; i++) v[i] = Integer.parseInt(seq[i]);

        HeapBH heap = new HeapBH(v);

        System.out.println(heap.toString());
    }
    
}

class HeapBH {
    
    private int[] heap;
    private int tail;

    public HeapBH(int capacidade) {
        this.heap = new int[capacidade];
        this.tail = -1;
    }

    public HeapBH(int[] heap) {
        this.heap = heap;
        this.tail = this.heap.length - 1;
        this.buildHeap();
    }

    public boolean isEmpty() {
        return this.tail == -1;
    }

    public int left(int index) {
        return 2 * index + 1;
    }

    public int right(int index) {
        return 2 * (index + 1);
    }

    public int parent(int index) {
        return Math.floorDiv(index - 1, 2);
    }

    private void heapify(int index) {
        if (this.isLeaf(index) || !this.isValidIndex(index)) return;

        int index_max = this.max_index(index, this.left(index), this.right(index));

        if (index_max != index) {
            int aux = this.heap[index];
            this.heap[index] = this.heap[index_max];
            this.heap[index_max] = aux;
            this.heapify(index_max);
        }
    }

    private boolean isLeaf(int index) {
        return index > this.parent(this.tail) && index <= this.tail;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= this.tail;
    }

    private int max_index(int index, int left, int right) {
        if (this.heap[index] > this.heap[left]) {
            if (this.isValidIndex(right)) {
                if (this.heap[right] > this.heap[index]) return right;
            }
            return index;
        } else {
            if (this.isValidIndex(right)) {
                if (this.heap[right] > this.heap[left]) return right;
            }
            return left;
        }
    }

    private void buildHeap() {
        for (int i = this.parent(this.tail); i >= 0; i--) this.heapify(i);
    }

    public String toString() {
        return Arrays.toString(this.heap);
    }
}
