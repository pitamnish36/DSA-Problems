class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        List<String> freqStrings=new ArrayList<>();
        PriorityQueue<StringWithFreq> minHeap=new PriorityQueue<>((a,b) -> {
            if(a.freq==b.freq){
                return b.str.compareTo(a.str);
            }
            else{
                return a.freq-b.freq;
            }
        });
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            minHeap.offer(new StringWithFreq(entry.getKey(),entry.getValue()));
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        while(minHeap.size()>0){
            freqStrings.add(minHeap.poll().str);
        }
        Collections.reverse(freqStrings);
        return freqStrings;
    }
}
class StringWithFreq{
    String str;
    int freq;
    StringWithFreq(String str,int freq){
        this.str=str;
        this.freq=freq;
    }
}