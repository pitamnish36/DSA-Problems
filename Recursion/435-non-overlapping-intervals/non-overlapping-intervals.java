class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==1){
            return 0;
        }
        Arrays.sort(intervals,(a,b) -> {
            if(b[1]==a[1])
            return a[0]-b[0];
            else
            return a[1]-b[1];
        });
        // Arrays.stream(intervals).forEach(x->{
        //     System.out.println(x[0]+" "+x[1]);
        // });
        int removeCount=0;
        int end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=end){
                end=intervals[i][1];
            }
            else{
                removeCount++;
            }
        }
        return removeCount;
    }
}