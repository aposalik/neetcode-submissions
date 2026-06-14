class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length -k +1 ];
        Deque<Integer> stack = new ArrayDeque<>();
        int resIdx =0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
    // step 1: pop from back while smaller than nums[right]
    // step 2: add right to deque
    // step 3: if front is outside window, pop it
            while(!stack.isEmpty() && nums[stack.peekLast()] < nums[right]){
                stack.pollLast();
            }
            stack.addLast(right);
            if(stack.peekFirst()< left){
                stack.pollFirst();
            }

            // step 4: if window is full, record max and move left
            if (right >= k - 1) {
                result[resIdx] = nums[stack.peekFirst()];
                resIdx++;
                left++;
        }
    }
    return result ;

     }

}