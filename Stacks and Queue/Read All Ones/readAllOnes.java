import java.util.*;
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int arr[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        Stack<Integer> hist=new Stack<>();
        hist.push(-1);
        int heights[]=new int[n];
        int maxArea=0;
        for(int col=0;col<n;col++){
            int height=0;
            int row=m-1;
            while(row>0 && arr[row][col]==1){
                height++;
                row--;
            }
            heights[col]=height;
        }

        for(int i=0;i<=n;i++){
            int curVal=(i==n)?0:heights[i];

            while(hist.peek()!=-1 && curVal<heights[hist.peek()]){
                int length=heights[hist.pop()];
                int breadth=i-hist.peek()-1;
                maxArea=Math.max(maxArea,length*breadth);
            }
            hist.push(i);
        }
        System.out.println(maxArea);

    }
}