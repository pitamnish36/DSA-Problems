class Solution {
    public int removeDuplicates(int[] nums) {
        int c1=0,c2=1,temp=0;
        int len=nums.length;
        while(c2<len){
            if(nums[c2]<=nums[c1]){
                c2++;
            }
            else{
                c1++;
                temp=nums[c1];
                nums[c1]=nums[c2];
                nums[c2]=temp;
                c2++;
            }
        }
        //System.out.println(c1);
        return c1+1;
    }
}