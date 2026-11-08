class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        long num = Long.parseLong(n);
        Set<Long> candidates = new HashSet<>();
        
        candidates.add((long)Math.pow(10, len - 1) - 1);
        candidates.add((long)Math.pow(10, len) + 1);
        
        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        
        for (long i = prefix - 1; i <= prefix + 1; i++) {
            String left = String.valueOf(i);
            String palindrome;
            if (len % 2 == 0) {
                palindrome = left + new StringBuilder(left).reverse();
            } else {
                palindrome = left + new StringBuilder(left.substring(0, left.length() - 1)
            ).reverse();
            }
            candidates.add(Long.parseLong(palindrome));
        }
        
        long ans = -1;
        long minDiff = Long.MAX_VALUE;
        for (long candidate : candidates) {
            if (candidate == num) {
                continue;
            }
            long diff = Math.abs(candidate - num);
            if (diff < minDiff ||
                (diff == minDiff && candidate < ans)) {
                minDiff = diff;
                ans = candidate;
            }
        }
        return String.valueOf(ans);
    }
}