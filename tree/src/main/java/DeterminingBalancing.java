import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

// recursive way
// time complexity o(n^2): time efficiency not so good!
// space complexity o(n)
public class DeterminingBalancing {
    private static Map<TreeNode, Integer> heightCache = new HashMap<>();

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int leftTreeHeight = computeHeight(root.left);
        int rightTreeHeight = computeHeight(root.right);
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(leftTreeHeight - rightTreeHeight) <= 1;
    }

    private int computeHeight(TreeNode root) {
        if (heightCache.containsKey(root)) {
            return heightCache.get(root);
        }
        if (root == null) return 0;
        int leftTreeHeight = computeHeight(root.left), rightTreeHeight = computeHeight(root.right);
        int result =  leftTreeHeight < rightTreeHeight ? rightTreeHeight + 1 : leftTreeHeight + 1;
        heightCache.put(root, result);
        return result;
    }
}
