class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        backtrack(n, 0, 0, "", ans);

        return ans;
    }
    void backtrack(int n, int open, int close,

                   String str, List<String> ans) {

        // Base case

        if (open == n && close == n) {

            ans.add(str);

            return;

        }

        // Add '('

        if (open < n) {

            backtrack(n, open + 1, close,

                      str + "(", ans);

        }

        // Add ')'

        if (close < open) {

            backtrack(n, open, close + 1,

                      str + ")", ans);

        }

    }
}