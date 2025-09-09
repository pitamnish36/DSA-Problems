class Solution {
    public int maxChunksToSorted(int[] arr) {
        int cnt=0;
        int curSum=0;
        int expSum=0;
        for(int i=0;i<arr.length;i++){
            curSum+=arr[i];
            expSum+=i;
            if(curSum==expSum){
                cnt++;
            }
        }
        return cnt;
    }
}