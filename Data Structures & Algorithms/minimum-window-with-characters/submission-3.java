class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int left = 0; int right = 0;
        int need = tMap.size();
        int have = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        HashMap<Character, Integer> windowMap = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            if (tMap.containsKey(c) && windowMap.get(c).equals(tMap.get(c))) {
                have++;
            }

            while (have == need) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (tMap.containsKey(leftChar) && windowMap.get(leftChar) < tMap.get(leftChar)) {
                    have--;
                }
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}