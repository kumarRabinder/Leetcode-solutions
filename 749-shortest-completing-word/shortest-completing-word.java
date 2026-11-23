class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] count = new int[26];
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                count[c - 'a']++;
            }
        }
        String ans = "";
        for (String word : words) {
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
            boolean valid = true;
            for (int i = 0; i < 26; i++) {
                if (freq[i] < count[i]) {
                    valid = false;
                    break;
                }
            }
            if (valid && (ans.equals("") || word.length() < ans.length())) {
                ans = word;
            }
        }
        return ans;
    }
}