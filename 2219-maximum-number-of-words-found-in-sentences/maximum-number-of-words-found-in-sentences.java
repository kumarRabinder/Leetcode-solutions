class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxwords=0;
        for(String sentence : sentences){
            int words=1;
            for(int i=0 ; i<sentence.length() ; i++){
                if(sentence.charAt(i) == ' '){
                    words++;
                }
            }
            
            maxwords=Math.max(words,maxwords);
        }
        return maxwords;
    }
}