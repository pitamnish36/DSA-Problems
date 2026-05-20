class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        List<Worker> workerList=new ArrayList<>();
        for(int i=0;i<quality.length;i++){
            workerList.add(new Worker((double)wage[i]/quality[i],quality[i]));
        }
        
        workerList.sort((a,b)->Double.compare(a.ratio,b.ratio));

        PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(Comparator.reverseOrder());
        int qualitySum=0;
        double minWage=Double.MAX_VALUE;
        for(int i=0;i<quality.length;i++){
            Worker worker=workerList.get(i);
            double currRatio=worker.ratio;
            int currQuality=worker.quality;
            maxHeap.offer(currQuality);
            qualitySum+=currQuality;
            if(maxHeap.size()>k){
                qualitySum-=maxHeap.poll();
            }
            if(maxHeap.size()==k){
                double totalWage=qualitySum*currRatio;
                minWage=Math.min(minWage,totalWage); 
            }
        }
        return minWage;
    }
}
class Worker{
    double ratio;
    int quality;
    Worker(double ratio,int quality){
        this.ratio=ratio;
        this.quality=quality;
    }
}