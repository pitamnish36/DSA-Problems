import java.util.*;
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        List<List<Integer>> distMap=new ArrayList<>();
        PriorityQueue<List<Integer>> maxHeap=new PriorityQueue<>((d1,d2)->{
            return d2.get(0)-d1.get(0);
        }); 
        for(int i=0;i<points.length;i++){
            Integer dist=(int)Math.pow((points[i][0]+points[i][1]),2)-(2*points[i][0]*points[i][1]);
            maxHeap.offer(Arrays.asList(dist,i));
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        int [][]res=new int[k][2];
        for(int i=k-1;i>=0;i--){
            int idx=maxHeap.poll().get(1);
            res[i][0]=points[idx][0];
            res[i][1]=points[idx][1];
        }
        return res;
    }
}