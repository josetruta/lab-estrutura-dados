public class Heap {
    
    private int[] heap;
    private int tail;

    public Heap(int capacidade) {
        this.heap = new int[capacidade];
        this.tail = -1;
    }

    public Heap(int[] heap) {
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

    public void add(int element) {
        if (this.tail + 1 >= this.heap.length) this.resize();

        this.heap[++this.tail] = element;

        int i = tail;
        while (i > 0 && this.heap[this.parent(i)] < this.heap[i]) {
            int aux = this.heap[i];
            this.heap[i] = this.heap[this.parent(i)];
            this.heap[this.parent(i)] = aux;
            i = this.parent(i);
        }
    }

    private void resize() {
        int[] newHeap = new int[this.heap.length * 2];

        for (int i = 0; i < this.heap.length; i++) newHeap[i] = this.heap[i];

        this.heap = newHeap;
    }

    public int remove() {
        if (this.isEmpty()) throw new RuntimeException("Empty");

        int element = this.heap[0];
        this.heap[0] = this.heap[this.tail];
        this.tail--;

        this.heapify(0);

        return element;
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
                if (this.heap[right] > this.heap[index]) return right;
            }
            return left;
        }
    }

    private void buildHeap() {
        for (int i = this.parent(this.tail); i >= 0; i--) this.heapify(i);
    }
}
