class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for(String word : strs){
            int len = word.length();
            result += len + "#"+word;
        };
        return result; 
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int i=0;
        while(i < str.length()){
            // Find the #
            int j = str.indexOf("#",i);
            int len = Integer.parseInt(str.substring(i,j));

            String word = str.substring(j+1,j+1+len);
            result.add(word);

            i = j+1+len;
    
        }
        return result;

        }
}
