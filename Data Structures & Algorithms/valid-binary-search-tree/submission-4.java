class Solution {
    public boolean isValidBST(TreeNode root) {
        return calc(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean calc(TreeNode root, long min, long max) {
        if (root == null) return true;

        if (root.val <= min || root.val >= max)
            return false;

        return calc(root.left, min, root.val) &&
               calc(root.right, root.val, max);
    }
}
