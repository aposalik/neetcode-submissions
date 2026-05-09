class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int maxWater = 0;

        while(left < right){
            int width = right - left;
            int heigh = Math.min(heights[left],heights[right]);
            int area = width * heigh;

            maxWater = Math.max(maxWater,area);

            if(heights[left] <= heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxWater;
    }
}
