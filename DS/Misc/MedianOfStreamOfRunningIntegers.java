// https://leetcode.com/problems/find-median-from-data-stream/

class MedianFinder {

    PriorityQueue<Integer> maxHeap, minHeap;

    /** initialize your data structure here. */
    public MedianFinder() {

        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        double median = (int) findMedian();

        if (num > median) minHeap.add(num);
        else maxHeap.add(num);

        balanceHeap();
    }

    public double findMedian() {

        int minSize = minHeap.size();
        int maxSize = maxHeap.size();

        if (minSize == maxSize && minSize > 0) return (maxHeap.peek() + minHeap.peek()) / 2.0;
        else if (minSize > maxSize) return minHeap.peek();
        else if (maxSize > 0) return maxHeap.peek();
        return 0;
    }


    private void balanceHeap() {

        int minSize, maxSize;

        while (Math.abs((minSize = minHeap.size()) - (maxSize = maxHeap.size())) > 1) {

            if (minSize > maxSize) maxHeap.add(minHeap.remove());
            else minHeap.add(maxHeap.remove());
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */