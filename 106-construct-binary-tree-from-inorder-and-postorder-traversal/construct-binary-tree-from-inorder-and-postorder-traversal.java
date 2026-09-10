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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> mp = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }

        TreeNode root = construct_uniqueTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1,mp);

        return root;
    }
    private TreeNode construct_uniqueTree(int[]postorder , int postStart, int postEnd,int[] inorder,int inStart,int inEnd,Map<Integer,Integer> mp){
        if(inStart > inEnd || postStart > postEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        int inRoot = mp.get(root.val);
        int divide_left = inRoot - inStart;

        root.left = construct_uniqueTree(postorder ,postStart ,postStart + divide_left -1,inorder , inStart ,inRoot - 1,mp);

        root.right = construct_uniqueTree(postorder ,postStart+divide_left ,postEnd-1 ,inorder , inRoot + 1 ,inEnd,mp);

        return root;
    }
}