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
    int count=0;
    public int goodNodes(TreeNode root) {
        int prev=root.val;
        calc(root,prev);
        return count;
    }
    public void calc(TreeNode root,int prev)
    {
        if (root==null)
        return;

        if(root.val >=prev)
        count++;

        calc(root.left,Math.max(root.val,prev));
        calc(root.right,Math.max(root.val,prev));


    }
}
