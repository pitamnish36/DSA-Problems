class Solution {
    public int[] plusOne(int[] digits) {
        int i=digits.length-1;
        boolean carry;
        do{
            carry=false;
            digits[i]=digits[i]+1;
            if(digits[i]==10){
                carry=true;
                digits[i]=0;
            }
            i--;
        }
        while(i>=0 && carry);
        if(digits[0]==0){
            int[] digitsPlusOne=new int[digits.length+1];
            System.arraycopy(digits,0,digitsPlusOne,1,digits.length);
            digitsPlusOne[0]=1;
            return digitsPlusOne;
        }
        return digits;
    }
}