class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        // build s1 frequency map
        HashMap<Character, Integer> s1Map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }

        // build first window map
        HashMap<Character, Integer> windowMap = new HashMap<>();
        int left = 0;
        int right = s1.length() - 1;

        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
        }

        // check first window
        if (s1Map.equals(windowMap)) return true;

        // slide the window
        while (right < s2.length() - 1) {
            // add new right char
            right++;
            char newChar = s2.charAt(right);
            windowMap.put(newChar, windowMap.getOrDefault(newChar, 0) + 1);

            // remove old left char
            char oldChar = s2.charAt(left);
            windowMap.put(oldChar, windowMap.get(oldChar) - 1);
            if (windowMap.get(oldChar) == 0) {
                windowMap.remove(oldChar);
            }

            left++;

            // compare
            if (s1Map.equals(windowMap)) return true;
        }

        return false;
    }
}