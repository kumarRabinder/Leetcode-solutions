/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        int maxWidth = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            int first = q.peek().index;

            int last = first;

            for (int i = 0; i < size; i++) {

                Pair p = q.poll();

                last = p.index;

                if (p.node.left != null) {

                    q.offer(new Pair(p.node.left, 2 * p.index + 1));

                }

                if (p.node.right != null) {

                    q.offer(new Pair(p.node.right, 2 * p.index + 2));

                }

            }

            maxWidth = Math.max(maxWidth, last - first + 1);

        }

        return maxWidth;

    }
     class Pair {

        TreeNode node;

        int index;

        Pair(TreeNode node, int index) {

            this.node = node;

            this.index = index;

        }

    }
}