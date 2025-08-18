class Solution {
    long modulo=100_000_000_7;
    public int countGoodNumbers(long n) {
        long even=count(5,(n+1)/2);
        long odd=count(4,n/2);
        return (int)((even*odd)%modulo);
    }
    public long count(int base,long n){
        if(n==0){
            return 1;
        }
        long half=count(base,n/2);
        if(n%2!=0){
            return (base*half*half)%modulo;
        }
        else{
            return (half*half)%modulo;
        }
    }
}