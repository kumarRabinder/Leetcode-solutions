class Solution {
    public boolean judgePoint24(int[] cards) {
        double[] nums = new double[cards.length];
        for (int i = 0; i < cards.length; i++) {
            nums[i] = cards[i];
        }
        return solve(nums);
    }
    private boolean solve(double[] nums) {
        if (nums.length == 1) {
            return Math.abs(nums[0] - 24.0) < 1e-6;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                double a = nums[i];
                double b = nums[j];
                double[] results = {
                    a + b,
                    a - b,
                    b - a,
                    a * b
                };
                for (double result : results) {
                    if (solve(getNext(nums, i, j, result))) {
                        return true;
                    }
                }
                if (Math.abs(b) > 1e-6) {
                    if (solve(getNext(nums, i, j, a / b))) {
                        return true;
                    }
                }
                if (Math.abs(a) > 1e-6) {
                    if (solve(getNext(nums, i, j, b / a))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }    
    private double[] getNext(double[] nums, int i, int j, double result) {
        double[] next = new double[nums.length - 1];
        int index = 0;
        for (int k = 0; k < nums.length; k++) {
            if (k != i && k != j) {
                next[index++] = nums[k];
            }
        }
        next[index] = result;
        return next;
    }
}