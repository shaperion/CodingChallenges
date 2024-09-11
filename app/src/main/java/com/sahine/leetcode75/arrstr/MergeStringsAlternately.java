package java.com.sahine.ArrStr;

class MergeStringsAlternately {
	public MergeStringsAlternately(){}
	
    public String mergeAlternately(String word1, String word2) {
        // Since this is not the #1 solution on the displayed chart on leetcode
        // there are other optimizations that can be made.
        // https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75

        StringBuilder str = new StringBuilder(); // More efficient than an empty String
        int minLen = word1.length() < word2.length() ? word1.length() : word2.length();

        // Removed decision making by judging by minimum length than maximum
        for(int i = 0; i < minLen; i++){
            str.append(word1.charAt(i)); // charAt seems to be more efficient than 
            str.append(word2.charAt(i)); // substring
        }

        // Instead of the decision made above for each character we make one decision here
        // to add the remaining characters of the longest word to the string
        if(word1.length() > word2.length()){
            str.append(word1.substring(minLen));
        }else{
            str.append(word2.substring(minLen));
        }

        return str.toString();
    }
}