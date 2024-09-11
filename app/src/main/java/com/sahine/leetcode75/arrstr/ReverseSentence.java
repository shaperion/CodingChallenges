package java.com.sahine.ArrStr;

class ReverseSentence {
	public ReverseSentence(){}
	
	//My Solution
    public String reverseWords(String s) {
        String[] words = s.split(" +"); //Utilizes regex
        StringBuilder result = new StringBuilder();

        for(int i = words.length - 1; i >= 0; i--){
            result.append(words[i] + " ");
        }

        return result.toString().trim();
    }

	//Top Runtime Solution
	public String topRunReverseWords(String s) {
       char[] chars = s.toCharArray();
       char[] result = new char[chars.length];

       int resultCurrIndex = findAndCopy(chars, result, 0, 0);

       return new String(result, 0, resultCurrIndex);
    }

    private int findAndCopy(char[] chars, char[] result, int charsCurrIndex, int resultCurrIndex){
        while(charsCurrIndex < chars.length && chars[charsCurrIndex] == ' ') charsCurrIndex++;
        int endOfWordIndex = charsCurrIndex;
        while(endOfWordIndex < chars.length && chars[endOfWordIndex] != ' ') endOfWordIndex++;

        if(endOfWordIndex == charsCurrIndex) return resultCurrIndex;

        resultCurrIndex = findAndCopy(chars, result, endOfWordIndex + 1, resultCurrIndex);

        if(resultCurrIndex > 0) {
            result[resultCurrIndex] = ' ';
            resultCurrIndex++;
        }

        for(int j = charsCurrIndex; j < endOfWordIndex; j++){
            result[resultCurrIndex++] = chars[j];
        }

        return resultCurrIndex;
    }
	
	
	//Top Memory Solution
	public String topMemReverseWords(String s) {
        String[] words = s.split(" +");
        StringBuilder sb = new StringBuilder(); //Always use StringBuilder when manipulating Strings
        for(int i = words.length - 1; i >= 0; i--){
            sb.append(words[i]);
            sb.append(" ");    
        }
        return sb.toString().trim();
    }
}