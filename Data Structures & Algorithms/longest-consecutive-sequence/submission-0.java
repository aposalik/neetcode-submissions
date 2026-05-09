class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();

        for(int number : nums){
            hs.add(number);
        };

        int max = 0;
        for(int i=0; i<nums.length; i++){
            if(!hs.contains(nums[i]-1)){
                int lenght = 1;
                while(hs.contains(nums[i] + lenght)){
                    lenght++;
                }
                max = Math.max(max,lenght);
            }
        }
        return max;
        
    }
}
