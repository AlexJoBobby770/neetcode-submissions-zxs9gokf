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
    public boolean isValidBST(TreeNode root) {
        int min=-1000;
        int max=1000;
        return calc(root,min,max);
        
    }
    public boolean calc(TreeNode root,int min,int max)
    {
        if(root == null)
        return true;

        if(root.val <= min || root.val >=max)
        return false;

        return calc(root.left,min,root.val) && calc(root.right,root.val,max);

    }
}
