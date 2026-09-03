/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void markParent( TreeNode root ,Map<TreeNode,TreeNode> parent_track){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node.left != null){
                parent_track.put(node.left , node);
                q.offer(node.left);
            }
            if(node.right != null){
                parent_track.put(node.right , node);
                q.offer(node.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //Parents mark for the upwards
        Map<TreeNode,TreeNode>parent_track = new HashMap<>();
        markParent(root,parent_track);
        //BFS
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        
        q.offer(target);
        visited.add(target);

        int distance = 0;

        while(!q.isEmpty()){

            if(distance == k){
                List<Integer> ans = new ArrayList<>();

                for(TreeNode node : q){
                    ans.add(node.val);
                }
                return ans;
            }

            int size = q.size();
            
            for(int i=0; i<size;i++){

                TreeNode node = q.poll();

                if(node.left != null && !visited.contains(node.left)){
                    q.offer(node.left);
                    visited.add(node.left);
                }
                if(node.right != null && !visited.contains(node.right)){
                    q.offer(node.right);
                    visited.add(node.right);
                }

                if(parent_track.containsKey(node) && !visited.contains(parent_track.get(node))){
                    q.offer(parent_track.get(node));
                    visited.add(parent_track.get(node));
                }
            }
            distance++;
        }
        return new ArrayList<>();

    }
}