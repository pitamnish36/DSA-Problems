class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum=0;
        int n=cardPoints.length;
        int wSum=0;
        k=n-k; 
        for(int i=0;i<n;i++){
            if(i<k){
                wSum+=cardPoints[i];
            }
            sum+=cardPoints[i];
        }
        int j=k;
        int curScore=wSum;
        int minScore=wSum;
        while(j<n){
            curScore+=cardPoints[j];
            curScore-=cardPoints[j-k];
            minScore=Math.min(minScore,curScore);
            j++;  
        }
        return sum-minScore;
    }
}