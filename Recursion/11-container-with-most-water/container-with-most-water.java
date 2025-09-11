class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxW=0;
        int curW=0;
        while(left<=right){
            curW=(right-left)*Math.min(height[left],height[right]);
            if(curW>maxW){
                maxW=curW;
            }
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxW;
    }
}