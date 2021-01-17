import model.TreeNode;

// time o(n) n count of tree nodes
// space o(n)
public class DeterminingBalancing2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return height(root) > 0;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        int leftHeight, rightHeight;
        if ((leftHeight = height(root.left)) < 0 || (rightHeight = height(root.right)) < 0) {
            return -1;
        }

        return Math.abs(leftHeight - rightHeight) > 1 ? -1 : Math.max(leftHeight, rightHeight) + 1;
    }
}
