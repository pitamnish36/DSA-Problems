class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String str=strs[i];
            char[] cArr=str.toCharArray();
            Arrays.sort(cArr);

            String key=new String(cArr);
            map.computeIfAbsent(key,k->new ArrayList<>())
            .add(str);

        }
        return new ArrayList<>(map.values());
    }
}