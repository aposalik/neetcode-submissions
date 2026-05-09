class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer , Integer > frequet = new HashMap<>();

        for(int num : nums){
            if(frequet.containsKey(num)){
                frequet.put(num, frequet.get(num) + 1);
            } else { 
                frequet.put(num, 1);
            }
        }

        // Now I need to do the soring 
        List<Integer> keys = new ArrayList<>(frequet.keySet());
        // lambda
        Collections.sort(keys,(a,b)-> frequet.get(b) - frequet.get(a));

        int[] result = new int[k];
        for(int i=0; i<k;i++){
            result[i] = keys.get(i);
        }

        return result;
        
    }
}
