class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=barcodes.length;
        for(int barcode : barcodes){
            map.put(barcode,map.getOrDefault(barcode,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap=new PriorityQueue<>((a,b)->{
            return b.getValue()-a.getValue();
        });
        int []res=new int[n];
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.offer(entry);
        }
        int idx=0;
        while(!maxHeap.isEmpty()){
            Map.Entry<Integer,Integer> freq=maxHeap.poll();
            int value=freq.getKey();
            int count=freq.getValue();
            while(count>0){
                if(idx>=n){
                    idx=1;
                }
                res[idx]=value;
                idx=idx+2;
                count--;
            }
        }
        return res;   
    }
}