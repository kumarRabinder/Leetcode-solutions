class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();

        // Store 1 to n

        for (int i = 1; i <= n; i++) {

            numbers.add(i);

        }

        // Calculate (n - 1)!

        int fact = 1;

        for (int i = 1; i < n; i++) {

            fact *= i;

        }

        // Convert k to zero-based

        k--;

        StringBuilder ans = new StringBuilder();

        while (n > 0) {

            int index = k / fact;

            ans.append(numbers.get(index));

            numbers.remove(index);

            k = k % fact;

            n--;

            if (n > 0) {

                fact = fact / n;

            }

        }

        return ans.toString();
    }
}