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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();
        
        getPath(root ,path1 , p);
        getPath(root,path2 , q);

        int i = 0;
        while(i < path1.size() && i < path2.size() && path1.get(i).equals(path2.get(i))){
            i++;
        }

        return path1.get(i-1);
        
    }
    private boolean getPath(TreeNode root , ArrayList<TreeNode> path , TreeNode target){
        if(root == null) return false;

        path.add(root);

        if(root == target) return true;

        if(getPath(root.left,path,target) || getPath(root.right , path ,target)){
            return true;
        }

        path.remove(path.size()-1);
        
        return false;
    }
}