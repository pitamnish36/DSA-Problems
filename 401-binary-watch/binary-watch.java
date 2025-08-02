class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        int bits=0;
        List<String> possibleTimes=new ArrayList<String>();
        for(int i=0;i<12;i++){
            for(int j=0;j<60;j++){
                bits=countSetBits(i)+countSetBits(j);
                if(bits==turnedOn){
                    possibleTimes.add(i+":"+(j>9?""+j:"0"+j));
                }
            }
        }
        //possibleTimes.add(Integer.toString(countSetBits(turnedOn)));
        return possibleTimes;
    }
    static int countSetBits(int n){
        int cnt=0;
        while(n>0){
            if((n & 1)!=0)
            cnt++;
            n=n>>1;
        }
        return cnt;
    }
}