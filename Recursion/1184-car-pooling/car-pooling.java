class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int diff[]=new int[1001];
        for(int[] trip:trips){
            diff[trip[1]]+=trip[0];
            diff[trip[2]]-=trip[0];
        }

        int passenger=0;
        for(int i=0;i<=1000;i++){
            passenger+=diff[i];
            if(passenger>capacity)
            return false;
        }
        return true;
    }
}