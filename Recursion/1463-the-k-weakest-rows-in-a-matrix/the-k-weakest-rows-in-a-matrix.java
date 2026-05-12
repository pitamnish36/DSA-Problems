class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Row> maxHeap=new PriorityQueue<>((r1,r2)->{
            if(r1.power==r2.power){
                return r2.idx-r1.idx;
            }
            return r2.power-r1.power;
        });
        for(int i=0;i<mat.length;i++){
            int cnt=0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0)
                break;
                cnt++;
            }
            maxHeap.offer(new Row(i,cnt));
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        } 
        int res[]=new int[k];
        for(int i=k-1;i>=0;i--){
            res[i]=maxHeap.poll().idx;
        }
        return res;
    }
}
class Row{
    int idx;
    int power;
    Row(int idx,int power){
        this.idx=idx;
        this.power=power;
    }
}