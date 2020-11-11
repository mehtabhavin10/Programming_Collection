class KthLargest {

    PriorityQueue<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {

        heap = new PriorityQueue<>();
        this.k = k;

        for (int i : nums) add(i);
    }

    public int add(int val) {

        if (heap.size() < k) heap.add(val);
        else if (heap.peek() < val) {
            heap.poll();
            heap.add(val);
        }

        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */