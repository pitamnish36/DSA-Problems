class Solution {
    //calculate once use twice
    //O(n) to O(logn)
    //handling cases conditionally inside recursion
    //divide and conquer recurrence relation
    //solve task seperately then combine

    //challenges faced 
    //find relation for neagtive pow
    //TLE with linear recursion approach
    //TLE when dividing problem and finding soltion for both half
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        if(n%2!=0){
            if(n>0)
            return x*myPow(x,n-1);
            else
            return myPow(x,n+1)/x;
        }
        else{
            if(n>0){
                double half=myPow(x,n/2);
                return half*half;
            }
            else{
                double half=myPow(x,n/2);
                return half*half;
            }
        }
    }
}