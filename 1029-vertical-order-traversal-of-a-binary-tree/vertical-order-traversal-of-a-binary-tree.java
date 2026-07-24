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
    class Tuple{
        TreeNode node;
        int row;
        int column;

        public Tuple(TreeNode node,int column,int row){
            this.node = node;
            this.column = column;
            this.row = row;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Storing the column, then in treemap storing row and value in the PriorityQueue
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        //Storing the nodes with the col and row [(3,0,0)]
        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(root,0,0));

        while(!q.isEmpty()){
            Tuple tuple = q.poll();

            TreeNode node=tuple.node;
            int col=tuple.column;
            int row=tuple.row;

            if(!map.containsKey(col)){
                map.put(col,new TreeMap<>());
            }
            if(!map.get(col).containsKey(row)){
                map.get(col).put(row,new PriorityQueue<>());
            }
            map.get(col).get(row).offer(node.val);

            if(node.left != null){
                q.offer(new Tuple(node.left,col - 1 , row + 1));
            }
            if(node.right != null){
                q.offer(new Tuple(node.right , col + 1 , row + 1 ));
            }
        }

        ArrayList<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> rows : map.values()){
            
            List<Integer> currentcol = new ArrayList<>();

            for(PriorityQueue<Integer> values : rows.values()){
                while(!values.isEmpty()){
                    currentcol.add(values.poll());
                }
            }
            list.add(currentcol);
        }
        return list;
    }
}