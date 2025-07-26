class Solution {
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