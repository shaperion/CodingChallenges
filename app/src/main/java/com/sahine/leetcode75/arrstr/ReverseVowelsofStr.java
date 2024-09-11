package java.com.sahine.ArrStr;

import java.util.List;
import java.util.ArrayList;

class ReverseVowelsofStr {
	public ReverseVowelsofStr(){}
	
    public String reverseVowels(String s) {
        int pos1 = findNextVowel(true, s.toCharArray(), 0);
        int pos2 = findNextVowel(false, s.toCharArray(), s.length() - 1);
        char[] chars = s.toCharArray();

        while(pos1 < pos2){
            char temp = chars[pos1];
            chars[pos1] = chars[pos2];
            chars[pos2] = temp;

            pos1 = findNextVowel(true, chars, ++pos1);
            pos2 = findNextVowel(false, chars, --pos2);
        }
        
        s = new String(chars);
        return s;
    }

    public int findNextVowel(boolean forward, char[] word, int currIndex) {
        if(currIndex >= word.length || currIndex < 0 )
            return -1;
		//Too expensive
        if(String.valueOf(word[currIndex]).equalsIgnoreCase("a") ||
           String.valueOf(word[currIndex]).equalsIgnoreCase("e") ||
           String.valueOf(word[currIndex]).equalsIgnoreCase("i") ||
           String.valueOf(word[currIndex]).equalsIgnoreCase("o") ||
           String.valueOf(word[currIndex]).equalsIgnoreCase("u") ){
            return currIndex;
        }else{
            currIndex = forward ? (currIndex + 1):(currIndex - 1);
            return findNextVowel(forward, word, currIndex);
        }
    }
	
	//Top Runtime Answer
	private static final boolean[] VOWELS = new boolean[128];

    static {
        VOWELS['a'] = true;
        VOWELS['e'] = true;
        VOWELS['i'] = true;
        VOWELS['o'] = true;
        VOWELS['u'] = true;
        VOWELS['A'] = true;
        VOWELS['E'] = true;
        VOWELS['I'] = true;
        VOWELS['O'] = true;
        VOWELS['U'] = true;
    }

    public String topRunReverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] result = s.toCharArray();
        while (i < j) {
            if (VOWELS[result[i]] && VOWELS[result[j]]) {
                char temp = result[i];
                result[i] = result[j];
                result[j] = temp;
                i++;
                j--;
            } else {
                if (!VOWELS[result[i]]) {
                    i++;
                }
                if (!VOWELS[result[j]]) {
                    j--;
                }
            }
        }
        return new String(result);
    }
	
	//Top Memory Answer
	public String topMemReverseVowels(String s) {
        int len = s.length();   
        int l = 0, r = len - 1;

        StringBuilder sb = new StringBuilder(s);

        while(l<r){
            if(isVowel(s.charAt(l)) && isVowel(s.charAt(r))){
                sb.setCharAt(l, s.charAt(r));
                sb.setCharAt(r, s.charAt(l));
                l++;
                r--;
            } else if(isVowel(s.charAt(l))){
                r--;
            } else if(isVowel(s.charAt(r))){
                l++;
            } else {
                l++;
                r--;
            }
        }
        System.gc();
        return sb.toString();
    }

    public static boolean isVowel(char c){

        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' ||
        c=='A' || c=='E' || c=='I' || c=='O' || c=='U'){
            return true;
        }
        return false;
    }
}