class Solution {
    public boolean isPalindrome(String s) {
        String word = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        int len = word.length();
        boolean result = false;

        for(int i=0; i<len/2; i++){
            if(word.charAt(i) != word.charAt(len-1-i)){
                return false;
            }
        }
        return true;
    }
}
