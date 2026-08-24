class Solution {
    public List<List<Integer>> permute(int[] nums) {
        

        List<List<Integer>> ans = new ArrayList<>();

        generate(nums, new ArrayList<>(), ans);

        return ans;
    }
    void generate(int[] nums, List<Integer> current,

                  List<List<Integer>> ans) {

        if (current.size() == nums.length) {

            // check whether all elements are different

            Set<Integer> set = new HashSet<>(current);

            if (set.size() == nums.length) {

                ans.add(new ArrayList<>(current));

            }

            return;

        }

        for (int i = 0; i < nums.length; i++) {

            current.add(nums[i]);

            generate(nums, current, ans);

            current.remove(current.size() - 1);

        }

    }
}