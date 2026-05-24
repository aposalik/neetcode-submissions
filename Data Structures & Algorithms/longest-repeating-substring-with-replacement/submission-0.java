class Solution {
    public int characterReplacement(String s, int k) {
        int maxLenght = 0;
        int maxCount = 0;
        int startP =0;

        Map<Character, Integer> countMap = new HashMap<>();

        for(int i=0;i<s.length(); i++){
            char iChar = s.charAt(i);
            countMap.put(iChar, countMap.getOrDefault(iChar, 0) + 1);
            maxCount = Math.max(maxCount, countMap.get(iChar));

            if(i- startP + 1 - maxCount > k){
                char firstChar = s.charAt(startP);
                countMap.put(firstChar, countMap.get(firstChar) - 1);
                startP++;
            }
            maxLenght = Math.max(maxLenght, i - startP + 1);
        }
        return maxLenght;
    }
}
