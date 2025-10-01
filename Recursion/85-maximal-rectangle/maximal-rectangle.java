class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length; //rows 
        int m=matrix[0].length;  //cols
        int [][]hist=new int[n][m]; 
        //each array is converted into histogram of height equal to 1's from curren to above rows
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){  //can contribute to recangle
                    //Calculating height of hist based on upper row
                    hist[i][j]=(i==0)?1:hist[i-1][j]+1;
                }
                else{
                    //cannot contribute to rectangle
                    hist[i][j]=0;  
                }
            }
        }
        int maxArea=0;
        for(int i=0;i<n;i++){
            Stack<Integer> stack=new Stack<>();
            stack.push(0);
            for(int j=0;j<=m;j++){
                int curr=(j==m)?0:hist[i][j];
                while(!stack.isEmpty() && hist[i][stack.peek()]>curr){
                    int height=hist[i][stack.pop()];
                    int width=stack.isEmpty()?j:j-stack.peek()-1;
                    maxArea=Math.max(maxArea,height*width);
                }
                stack.push(j);
            }
        }
        return maxArea;

    }
}