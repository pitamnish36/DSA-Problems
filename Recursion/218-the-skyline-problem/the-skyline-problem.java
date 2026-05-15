class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n=buildings.length;
        int[][] coordinate=new int[2*n][2];
        int j=0;

        for(int i=0;i<n;i++){
            coordinate[i][0]=buildings[i][0];
            coordinate[i][1]=-(buildings[i][2]);
            coordinate[n+i][0]=buildings[i][1];
            coordinate[n+i][1]=buildings[i][2];
        }
        Arrays.sort(coordinate,(a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });
        
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Comparator.reverseOrder());
        List<List<Integer>> skyline=new ArrayList<>();
        int prevHeight=0;
        maxHeap.offer(0);
        for(int i=0;i<coordinate.length;i++){
            int height=coordinate[i][1];
            int x=coordinate[i][0];
            if(height<0){
                maxHeap.add(Math.abs(height));
            }
            else{
                maxHeap.remove(Math.abs(height));
            }
            height=maxHeap.peek();
            if(height!=prevHeight){
                List<Integer> res=new ArrayList<>();
                res.add(x);
                res.add(height);
                skyline.add(res);
                prevHeight=height;
            }
        }
        return skyline;
    }
}