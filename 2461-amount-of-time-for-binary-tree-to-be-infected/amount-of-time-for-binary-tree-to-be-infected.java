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
    public TreeNode parent_mark(TreeNode root , Map<TreeNode,TreeNode> mp,int start){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode find = null;
        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node.val == start){
                find = node;
            }
            if(node.left != null){
                q.offer(node.left);
                mp.put(node.left,node);
            }
            if(node.right != null){
                q.offer(node.right);
                mp.put(node.right,node);
            }
        }
        return find;
    }
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode,TreeNode> mp = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode startNode = parent_mark(root,mp,start);
        int minute = 0;

        HashSet<TreeNode> visited = new HashSet<>();
        q.offer(startNode);
        visited.add(startNode);
        while(!q.isEmpty()){
            int size = q.size();
            boolean infected = false;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();

                if(node.left != null && !visited.contains(node.left)){
                    q.offer(node.left);
                    visited.add(node.left);
                    infected = true;
                }
                if(node.right != null && !visited.contains(node.right)){
                    q.offer(node.right);
                    visited.add(node.right);
                    infected = true;
                }
                if(mp.containsKey(node) && !visited.contains(mp.get(node))){
                    q.offer(mp.get(node));
                    visited.add(mp.get(node));
                    infected = true;
                }
            }
            if(infected){
                minute++;
            }

        }
        return minute;
    }
}