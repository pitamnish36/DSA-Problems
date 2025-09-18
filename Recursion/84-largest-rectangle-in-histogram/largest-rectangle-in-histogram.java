class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        int maxArea=0;
        for(int i=0;i<=n;i++){
            int current=(i==n)?0:heights[i];
            while(!stack.isEmpty() && heights[stack.peek()]>current){
                int height=heights[stack.pop()];
                int width=stack.isEmpty()?i:i-stack.peek()-1;
                int area=width*height;
                maxArea=Math.max(area,maxArea);
            }
            stack.push(i);
        }

        return maxArea;
        
    }
}