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
    public class tuple{
        TreeNode node;
        int num;
        tuple(TreeNode node , int num){
            this.node = node;
            this.num = num;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<tuple> q = new LinkedList<>();
        int ans = 0;
        q.offer(new tuple(root , 0));
        while(!q.isEmpty()){
            int min = q.peek().num;
            int size= q.size();
            int first = 0;int last =0;

            for(int i=0;i<size;i++){
                int curr_id=q.peek().num - min;
                TreeNode curr = q.peek().node;
                q.poll();
                if(i == 0)first=curr_id;
                if(i == size-1) last=curr_id;

                if(curr.left != null){
                    q.offer(new tuple(curr.left , curr_id*2+1));
                }
                if(curr.right != null){
                    q.offer(new tuple(curr.right ,curr_id*2+2));
                }
            }
            ans = Math.max(ans , last - first + 1);
        }
        return ans;

    }
}