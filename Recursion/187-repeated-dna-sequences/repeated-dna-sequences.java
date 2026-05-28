class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> sequenceList=new HashSet<>();
        Map<String,Integer> map=new HashMap<>();
        if(s.length()<=10){
            return new ArrayList<>();
        }
        
        for(int i=0;i<=s.length()-10;i++){
            String sub=s.substring(i,i+10);
            if(map.containsKey(sub)){
                sequenceList.add(sub);
            }
            else{
                map.put(sub,1);
            }
            
        }
        return List.copyOf(sequenceList);
    }
}