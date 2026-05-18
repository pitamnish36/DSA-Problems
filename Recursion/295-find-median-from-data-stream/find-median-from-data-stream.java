class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>(Comparator.reverseOrder());
    }
    
    public void addNum(int num) {
        this.maxHeap.offer(num);
        int largest=this.maxHeap.poll();
        this.minHeap.offer(largest);
        while(this.minHeap.size()>this.maxHeap.size()){
            this.maxHeap.offer(this.minHeap.poll());
        }
    }
    
    public double findMedian() {
        int total=this.minHeap.size()+this.maxHeap.size();
        if(total%2==0)
        return ((double)this.maxHeap.peek()+this.minHeap.peek())/2.0;
        else
        return (double)this.maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */