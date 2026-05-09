
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false ;
        }


        HashMap<Character,Integer> table = new HashMap<>();

        for(char ch : s.toCharArray()){
            table.put(ch , table.getOrDefault(ch, 0) + 1) ;
        }

        for(char ch : t.toCharArray()){
            if(!table.containsKey(ch)) return false;

            int newCount = table.get(ch) - 1;
            if(newCount == 0){
                table.remove(ch);
            }else if(newCount <0 ){
                return false;
            }else {
                table.put(ch, newCount);
            }
        }

        return table.isEmpty();

    }
}
