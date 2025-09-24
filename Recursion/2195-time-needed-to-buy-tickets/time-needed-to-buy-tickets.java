class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<tickets.length;i++){
            queue.offer(i);
        }
        int timeTaken=0;
        while(tickets[k]>0){
            int get=queue.poll();
            tickets[get]--;
            timeTaken++;
            if(tickets[get]!=0){
                queue.offer(get);
            }
        }
        return timeTaken;
    }
}