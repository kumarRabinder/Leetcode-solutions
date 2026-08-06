class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxwords=0;
        for(String sentence : sentences){
            int cnt=0;
            String[] words=sentence.split(" ");
            cnt = words.length;
            maxwords=Math.max(cnt,maxwords);
        }
        return maxwords;
    }
}