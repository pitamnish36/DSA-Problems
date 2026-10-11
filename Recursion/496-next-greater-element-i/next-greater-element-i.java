class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],i);
        }
        int []result=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            int el=-1;
            int idx=map.get(nums1[i]);
            for(int j=idx;j<nums2.length;j++){
                if(nums2[j]>nums1[i]){
                    el=nums2[j];
                    break;
                }
            }
            result[i]=el;
        }
        return result;
    }
}