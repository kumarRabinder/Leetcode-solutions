class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);

        for (int m = 63; m >= 1; m--) {
            long k = (long) Math.pow(num, 1.0 / m);
            if (k < 2) {
                continue;
            }
            long sum = 1;
            long term = 1;
            for (int i = 1; i <= m; i++) {
                if (term > (num - 1) / k) {
                    sum = num + 1;
                    break;
                }
                term *= k;
                if (sum > num - term) {
                    sum = num + 1;
                    break;
                }
                sum += term;
            }
            if (sum == num) {
                return String.valueOf(k);
            }
        }
        return String.valueOf(num - 1);
    }
}