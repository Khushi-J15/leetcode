class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<Integer> al = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i=0, j=0;
        
        while(i<n1 && j<n2){
            if(nums1[i] < nums2[j]) i++;
            else if(nums1[i] > nums2[j]) j++;
            else{
                al.add(nums1[i]);
                i++;
                j++;
            }
        }
        
        int[] res = new int[al.size()];
        
        for(int k=0; k<al.size(); k++){
            res[k] = al.get(k);
        }
        
        return res;
    }
}