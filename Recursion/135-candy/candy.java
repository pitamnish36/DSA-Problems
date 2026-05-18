class Solution {
    public int candy(int[] ratings) {
        if(ratings.length==1){
            return 1;
        }
        if(ratings.length==2){
            if(ratings[0]==ratings[1])
            return 2;
            else
            return 3;
        }
        int curr=1;
        int []candy=new int[ratings.length];
        Arrays.fill(candy,1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candy[i]=candy[i-1]+1;
            }
        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candy[i]=Math.max(candy[i],candy[i+1]+1);
            }
        }
        return Arrays.stream(candy).sum();
    }
}