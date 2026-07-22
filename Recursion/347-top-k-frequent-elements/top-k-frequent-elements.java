import java.util.stream.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        Queue<Map.Entry<Integer,Integer>> queue=new PriorityQueue<>((a,b)->{
            return a.getValue()-b.getValue();
        });

        int[] freq=new int[k]; 

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            queue.offer(entry);

            if(queue.size()>k){
                queue.poll();
            }
        }
        int i=0;
        while(!queue.isEmpty()){
            freq[i++]=queue.poll().getKey();
        }
        return freq;
    }
}