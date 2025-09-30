class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int low=0;
        int high=Math.min(tasks.length,workers.length);
        Arrays.sort(tasks);
        Arrays.sort(workers);
        while(low<high){
            int mid=(low+high+1)/2;
            if(canAssign(tasks,workers,pills,strength,mid)){
                low=mid;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }
    public boolean canAssign(int[] tasks, int[] workers, int pills, int strength,int target){
        Deque<Integer> queue=new ArrayDeque<>();
        int w=workers.length-1;
        for(int t=target-1;t>=0;t--){
            int task=tasks[t];
            if(!queue.isEmpty() && queue.peekFirst()>=task){
                queue.pollFirst();
            }
            else if(w>=0 && workers[w]>=task){
                w--;
            }
            else{
                while(w>=0 && strength+workers[w]>=task){
                    queue.addLast(workers[w--]);
                }
                if(queue.isEmpty() || pills==0){
                    return false;
                }
                pills--;
                queue.pollLast();
            }
        }
        return true;
    }
}